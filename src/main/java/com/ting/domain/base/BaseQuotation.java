package com.ting.domain.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseQuotation<M extends BaseQuotation<M>> extends Model<M> implements IBean {

	public void setId(java.lang.Long id) {
		set("id", id);
	}

	public java.lang.Long getId() {
		return get("id");
	}

	public void setFromid(java.lang.Long fromid) {
		set("fromid", fromid);
	}

	public java.lang.Long getFromid() {
		return get("fromid");
	}

	public void setFromuser(java.lang.String fromuser) {
		set("fromuser", fromuser);
	}

	public java.lang.String getFromuser() {
		return get("fromuser");
	}

	public void setToid(java.lang.Long toid) {
		set("toid", toid);
	}

	public java.lang.Long getToid() {
		return get("toid");
	}

	public void setTouser(java.lang.String touser) {
		set("touser", touser);
	}

	public java.lang.String getTouser() {
		return get("touser");
	}

	public void setTax(java.lang.Boolean tax) {
		set("tax", tax);
	}

	public java.lang.Boolean getTax() {
		return get("tax");
	}

	public void setItemid(java.lang.Long itemid) {
		set("itemid", itemid);
	}

	public java.lang.Long getItemid() {
		return get("itemid");
	}

	public void setTitle(java.lang.String title) {
		set("title", title);
	}

	public java.lang.String getTitle() {
		return get("title");
	}

	public void setCatid(java.lang.Integer catid) {
		set("catid", catid);
	}

	public java.lang.Integer getCatid() {
		return get("catid");
	}

	public void setAmount(java.lang.Integer amount) {
		set("amount", amount);
	}

	public java.lang.Integer getAmount() {
		return get("amount");
	}

	public void setPrice(java.math.BigDecimal price) {
		set("price", price);
	}

	public java.math.BigDecimal getPrice() {
		return get("price");
	}

	public void setStatus(java.lang.Integer status) {
		set("status", status);
	}

	public java.lang.Integer getStatus() {
		return get("status");
	}

	public void setQueryid(java.lang.Long queryid) {
		set("queryid", queryid);
	}

	public java.lang.Long getQueryid() {
		return get("queryid");
	}

	public void setAddtime(java.util.Date addtime) {
		set("addtime", addtime);
	}

	public java.util.Date getAddtime() {
		return get("addtime");
	}

	public void setUpdatetime(java.util.Date updatetime) {
		set("updatetime", updatetime);
	}

	public java.util.Date getUpdatetime() {
		return get("updatetime");
	}

	public void setUrl(java.lang.String url) {
		set("url", url);
	}

	public java.lang.String getUrl() {
		return get("url");
	}

}
