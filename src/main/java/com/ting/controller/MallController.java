package com.ting.controller;

import com.jfinal.core.Controller;
import com.jfinal.json.FastJson;
import com.jfinal.json.Json;
import com.jfinal.kit.JsonKit;
import com.ting.domain.Mall;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tingsky on 16/1/13.
 */
public class MallController extends Controller{
    public void isStock(){

        Integer catid = getParaToInt("catid");
        Integer areaid = getParaToInt("areaid", null);
        int amount = getParaToInt("amount",1);


        Map<String,Object> result = new HashMap<String,Object>();
        result.put("isStock",Mall.dao.isStock(catid,amount,areaid));
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
