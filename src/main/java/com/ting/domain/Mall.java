package com.ting.domain;

import com.ting.domain.base.BaseMall;

import java.util.List;

/**
 * Generated by JFinal.
 */
@SuppressWarnings("serial")
public class Mall extends BaseMall<Mall> {
	public static final Mall dao = new Mall();

    public List<Mall> getStockGoodsByCatid(Integer catid){
        return dao.find("select * from destoon_mall where amount>sales and status=3 and catid = ?", catid);
    }

    public boolean isStock(Integer catid, Integer areaid){
        if(areaid == null){
            return getStockGoodsByCatid(catid).size() > 0;
        }else {
            return dao.find("select * from destoon_mall where amount>sales and status=3 and catid = ? and areaid = ?", catid , areaid).size() > 0;
        }
    }

}