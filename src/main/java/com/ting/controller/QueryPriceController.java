package com.ting.controller;

import com.jfinal.core.Controller;
import com.jfinal.kit.JsonKit;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.ting.domain.Mall;
import com.ting.domain.Member;
import com.ting.domain.QueryPrice;
import com.ting.domain.Quotation;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by tingsky on 16/1/13.
 */
public class QueryPriceController extends Controller{

    public static Executor executor = Executors.newCachedThreadPool();

    /**
     * 用户发起针对某分类商品发起询价请求
     */
    public void query(){
        final int catid = getParaToInt("catid");
        final long userId = getParaToLong("userId");
        final String username = getPara("username");
        final boolean tax = getParaToBoolean("tax");
        final int a = getParaToInt("amount",1);

        Member.dao.auth(userId, username);

        final List<Mall> list = Mall.dao.getStockGoodsByCatid(catid,a);

        //10分钟内不允许第二次询价
        QueryPrice q = QueryPrice.dao.getLatestQuery(catid, username);
        if(q != null){
            long l = new Date().getTime() - 10*60*1000;
            if(q.getAddtime().after(new Date(l))){
                Map<String,Object> result = new HashMap<String,Object>();
                result.put("amount",-1);
                r(result);
                return;
            }
        }

        if(list != null){
            final long id = QueryPrice.dao.insert(catid, username);

            Map<String,Object> result = new HashMap<String,Object>();
            result.put("amount",list.size()-1);
            r(result);

            Date now = new Date();

            //发起异步线程
            executor.execute(() -> {
                for (Mall m : list){
                    Quotation vo = new Quotation();
                    vo.setAddtime(now);
                    vo.setUpdatetime(null);
                    vo.setCatid(catid);
                    vo.setFromid(userId);
                    vo.setFromuser(username);
                    vo.setItemid(m.getItemid().longValue());
                    vo.setAmount(a);
                    vo.setPrice(null);
                    vo.setQueryid(id);
                    vo.setStatus(0);
                    vo.setTax(tax);
                    vo.setTitle(m.getTitle());
                    vo.setToid(Member.dao.findByUsername(m.getUsername()).getUserid().longValue());
                    vo.setTouser(m.getUsername());
                    vo.setUrl(m.getThumb());
                    vo.save();
                }
            });
        }
    }

    /**
     * 查询某用户针对某分类的最后一次询价价格清单,显示所有有报价的商家
     */
    public void list(){
        int catid = getParaToInt("catid");
        long userId = getParaToLong("userId");
        String username = getPara("username");
        Integer type = getParaToInt("type");
        Integer pageNo = getParaToInt("pageNo",1);
        Integer pageSize = getParaToInt("pageSize",10);
        Integer isDesc = getParaToInt("isDesc", 0);


        Member.dao.auth(userId, username);

        QueryPrice vo = QueryPrice.dao.getLatestQuery(catid, username);
        if(vo == null){
            r(0);
        }else{
            Page<Quotation> page = Quotation.dao.listQuotation(userId, vo.getId(), type, pageNo, pageSize, isDesc);
            r(page);
        }
    }

    public void update(){
        try {
            long userId = getParaToLong("userId");
            String username = getPara("username");
            long id = getParaToLong("id");
            double price = Double.parseDouble(getPara("price"));

            Member.dao.auth(userId, username);

            Map<String, Object> result = new HashMap<String, Object>();
            result.put("isUpdate", Quotation.dao.update(id, price));
            r(result);
        }catch (Exception e){
            Map<String, Object> result = new HashMap<String, Object>();
            result.put("isUpdate", -1);
            r(result);
            e.printStackTrace();
        }
    }

    public void expire(){
        long userId = getParaToLong("userId");
        String username = getPara("username");
        long toid = getParaToLong("toid");
        long catid = getParaToLong("catid");

        Member.dao.auth(userId, username);

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("isExpired", Db.update("update destoon_quotation set status=-1 where fromid="+ userId+" and toid="+toid+" and  catid="+catid )>0?1:0);
        r(result);
    }

    private void r(Object obj){
        String callback = getPara("callback");
        if(callback == null){
            renderJson(obj);
            return;
        }
        String text = JsonKit.toJson(obj);
        renderJson(callback+"("+text+")");
    }

}
