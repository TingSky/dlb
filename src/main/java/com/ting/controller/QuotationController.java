package com.ting.controller;

import com.jfinal.core.Controller;
import com.jfinal.kit.JsonKit;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.ting.domain.Member;
import com.ting.domain.Quotation;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tingsky on 16/1/13.
 */
public class QuotationController extends Controller{


    /**
     * 查询某用户针对某分类的最后一次询价价格清单,显示所有有报价的商家
     */
    public void bossList(){
        final long userId = getParaToLong("userId");
        final String username = getPara("username");
        Integer type = getParaToInt("type",null);
        Integer pageNo = getParaToInt("pageNo",1);
        Integer pageSize = getParaToInt("pageSize",10);

        Member.dao.auth(userId, username);

        r(Quotation.dao.listByBoss(username, type, pageNo, pageSize));
    }

    /**
     * 查询某用户针对某分类的最后一次询价价格清单,显示所有有报价的商家
     */
    public void customerList(){
        final long userId = getParaToLong("userId");
        final String username = getPara("username");
        Integer type = getParaToInt("type",null);
        Integer pageNo = getParaToInt("pageNo",1);
        Integer pageSize = getParaToInt("pageSize",10);

        Member.dao.auth(userId, username);

        Page<Quotation> page = Quotation.dao.listByCustomer(username, type, pageNo, pageSize);
        r(page);

    }

    public void unread(){
        final long userId = getParaToLong("userId");
        final String username = getPara("username");

        Member.dao.auth(userId, username);

        Long boss_unread = Db.queryLong("select count(1) from destoon_quotation where toid=? and status=0",userId);
        Long customer_unread = Db.queryLong("select count(1) from destoon_quotation where fromid=? and status=2 ",userId);
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("boss_unread",boss_unread);
        result.put("customer_unread",customer_unread);
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
