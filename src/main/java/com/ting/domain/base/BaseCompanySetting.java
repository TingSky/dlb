package com.ting.domain.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseCompanySetting<M extends BaseCompanySetting<M>> extends Model<M> implements IBean {

	public void setUserid(java.math.BigInteger userid) {
		set("userid", userid);
	}

	public java.math.BigInteger getUserid() {
		return get("userid");
	}

	public void setItemKey(java.lang.String itemKey) {
		set("item_key", itemKey);
	}

	public java.lang.String getItemKey() {
		return get("item_key");
	}

	public void setItemValue(java.lang.String itemValue) {
		set("item_value", itemValue);
	}

	public java.lang.String getItemValue() {
		return get("item_value");
	}

}
