package com.ting.domain;

import com.ting.domain.base.BaseMall;

import java.util.List;

/**
 * Generated by JFinal.
 */
@SuppressWarnings("serial")
public class Mall extends BaseMall<Mall> {
	public static final Mall dao = new Mall();

    public List<Mall> getStockGoodsByCatid(Integer catid, Integer amount){
        return dao.find("select * from destoon_mall where amount>sales+"+ amount +" and status=3 and catid = ? and username!='dlbdlb'", catid);
    }

    public boolean isStock(Integer catid, Integer amount,Integer areaid){
        if(areaid == null){
            return getStockGoodsByCatid(catid,amount).size() > 0;
        }else {
            return dao.find("select * from destoon_mall where amount>sales+"+ amount +" and status=3 and catid = ? and areaid = ? and username!='dlbdlb'", catid , areaid).size() > 0;
        }
    }

}
