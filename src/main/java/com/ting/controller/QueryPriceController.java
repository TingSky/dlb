package com.ting.controller;

import com.jfinal.core.Controller;
import com.jfinal.kit.JsonKit;
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
//        String ip = getRequest().getRemoteAddr();

        Member.dao.auth(userId, username);

        final List<Mall> list = Mall.dao.getStockGoodsByCatid(catid);

        QueryPrice q = QueryPrice.dao.getLatestQuery(catid, username);
        if(q != null){
            long l = new Date().getTime() - 10*60*1000;
            if(q.getAddtime().after(new Date(l))){
//                renderJson("amount",-1);
                Map<String,Object> result = new HashMap<String,Object>();
                result.put("amount",-1);
                r(result);
                return;
            }
        }

        if(list != null){
            final long id = QueryPrice.dao.insert(catid, username);
//            renderJson("amount",(list.size()-1) + "");

            Map<String,Object> result = new HashMap<String,Object>();
            result.put("amount",list.size()-1);
            r(result);

            Date now = new Date();

            executor.execute(() -> {
                for (Mall m : list){
                    if(m.getUsername().equals("dlbdlb")){
                        continue;
                    }
                    Quotation vo = new Quotation();
                    vo.setAddtime(now);
                    vo.setUpdatetime(null);
                    vo.setCatid(catid);
                    vo.setFromid(userId);
                    vo.setFromuser(username);
                    vo.setItemid(m.getItemid().longValue());
                    vo.setPrice(null);
                    vo.setQueryid(id);
                    vo.setStatus(false);
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


        Member.dao.auth(userId, username);

        QueryPrice vo = QueryPrice.dao.getLatestQuery(catid, username);
        if(vo == null){
            r(0);
        }else{
            Page<Quotation> page = Quotation.dao.listQuotation(vo.getId(), type, pageNo, pageSize);
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

            //        renderJson("isUpdate",Quotation.dao.update(id, price));
            //        r("{\"isUpdate\":"+Quotation.dao.update(id,price) + "}");
            Map<String, Object> result = new HashMap<String, Object>();
            result.put("isUpdate", Quotation.dao.update(id, price));
            r(result);
        }catch (Exception e){
            Map<String, Object> result = new HashMap<String, Object>();
            result.put("isUpdate", -1);
            r(result);
        }
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
