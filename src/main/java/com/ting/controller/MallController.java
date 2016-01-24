package com.ting.controller;

import com.jfinal.core.Controller;
import com.ting.domain.Mall;
import com.ting.domain.Member;

/**
 * Created by tingsky on 16/1/13.
 */
public class MallController extends Controller{
    public void isStock(){

//        final long userId = getParaToLong("userId");
//        final String username = getPara("username");
        Integer catid = getParaToInt("catid");
        Integer areaid = getParaToInt("areaid", null);

//        Member.dao.auth(userId, username);


        renderJson("isStock", Mall.dao.isStock(catid,areaid));
    }
}
