package com.ting.controller;

import com.jfinal.core.Controller;
import com.jfinal.kit.JsonKit;
import com.ting.domain.Member;
import com.ting.domain.Quotation;

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

//        renderJson(Quotation.dao.listByBoss(username, type, pageNo, pageSize));
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

//        renderJson(Quotation.dao.listByCustomer(username, type, pageNo, pageSize));
        r(Quotation.dao.listByCustomer(username, type, pageNo, pageSize));
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
