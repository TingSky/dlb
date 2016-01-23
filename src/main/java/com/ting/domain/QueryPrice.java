package com.ting.domain;

import com.ting.domain.base.BaseQueryPrice;

import java.util.Date;

/**
 * Generated by JFinal.
 */
@SuppressWarnings("serial")
public class QueryPrice extends BaseQueryPrice<QueryPrice> {
	public static final QueryPrice dao = new QueryPrice();

    public long insert(int catid , String username){
        QueryPrice vo = new QueryPrice();
        vo.setCatid(catid);
        vo.setUsername(username);
        vo.setAddtime(new Date());
        vo.save();
        return vo.getId();
    }

    public QueryPrice getLatestQuery(int catid, String username){
        return dao.findFirst("select * from destoon_query_price where catid=? and username=? order by addtime desc limit 1", catid, username);
    }
}
