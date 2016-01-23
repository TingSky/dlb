package com.ting.domain.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseMember<M extends BaseMember<M>> extends Model<M> implements IBean {

	public void setUserid(java.math.BigInteger userid) {
		set("userid", userid);
	}

	public java.math.BigInteger getUserid() {
		return get("userid");
	}

	public void setUsername(java.lang.String username) {
		set("username", username);
	}

	public java.lang.String getUsername() {
		return get("username");
	}

	public void setPassport(java.lang.String passport) {
		set("passport", passport);
	}

	public java.lang.String getPassport() {
		return get("passport");
	}

	public void setCompany(java.lang.String company) {
		set("company", company);
	}

	public java.lang.String getCompany() {
		return get("company");
	}

	public void setPassword(java.lang.String password) {
		set("password", password);
	}

	public java.lang.String getPassword() {
		return get("password");
	}

	public void setPasssalt(java.lang.String passsalt) {
		set("passsalt", passsalt);
	}

	public java.lang.String getPasssalt() {
		return get("passsalt");
	}

	public void setPayword(java.lang.String payword) {
		set("payword", payword);
	}

	public java.lang.String getPayword() {
		return get("payword");
	}

	public void setPaysalt(java.lang.String paysalt) {
		set("paysalt", paysalt);
	}

	public java.lang.String getPaysalt() {
		return get("paysalt");
	}

	public void setEmail(java.lang.String email) {
		set("email", email);
	}

	public java.lang.String getEmail() {
		return get("email");
	}

	public void setMessage(java.lang.Integer message) {
		set("message", message);
	}

	public java.lang.Integer getMessage() {
		return get("message");
	}

	public void setChat(java.lang.Integer chat) {
		set("chat", chat);
	}

	public java.lang.Integer getChat() {
		return get("chat");
	}

	public void setSound(java.lang.Boolean sound) {
		set("sound", sound);
	}

	public java.lang.Boolean getSound() {
		return get("sound");
	}

	public void setOnline(java.lang.Boolean online) {
		set("online", online);
	}

	public java.lang.Boolean getOnline() {
		return get("online");
	}

	public void setAvatar(java.lang.Boolean avatar) {
		set("avatar", avatar);
	}

	public java.lang.Boolean getAvatar() {
		return get("avatar");
	}

	public void setGender(java.lang.Boolean gender) {
		set("gender", gender);
	}

	public java.lang.Boolean getGender() {
		return get("gender");
	}

	public void setTruename(java.lang.String truename) {
		set("truename", truename);
	}

	public java.lang.String getTruename() {
		return get("truename");
	}

	public void setMobile(java.lang.String mobile) {
		set("mobile", mobile);
	}

	public java.lang.String getMobile() {
		return get("mobile");
	}

	public void setMsn(java.lang.String msn) {
		set("msn", msn);
	}

	public java.lang.String getMsn() {
		return get("msn");
	}

	public void setQq(java.lang.String qq) {
		set("qq", qq);
	}

	public java.lang.String getQq() {
		return get("qq");
	}

	public void setAli(java.lang.String ali) {
		set("ali", ali);
	}

	public java.lang.String getAli() {
		return get("ali");
	}

	public void setSkype(java.lang.String skype) {
		set("skype", skype);
	}

	public java.lang.String getSkype() {
		return get("skype");
	}

	public void setDepartment(java.lang.String department) {
		set("department", department);
	}

	public java.lang.String getDepartment() {
		return get("department");
	}

	public void setCareer(java.lang.String career) {
		set("career", career);
	}

	public java.lang.String getCareer() {
		return get("career");
	}

	public void setAdmin(java.lang.Boolean admin) {
		set("admin", admin);
	}

	public java.lang.Boolean getAdmin() {
		return get("admin");
	}

	public void setRole(java.lang.String role) {
		set("role", role);
	}

	public java.lang.String getRole() {
		return get("role");
	}

	public void setAid(java.lang.Long aid) {
		set("aid", aid);
	}

	public java.lang.Long getAid() {
		return get("aid");
	}

	public void setGroupid(java.lang.Integer groupid) {
		set("groupid", groupid);
	}

	public java.lang.Integer getGroupid() {
		return get("groupid");
	}

	public void setRegid(java.lang.Integer regid) {
		set("regid", regid);
	}

	public java.lang.Integer getRegid() {
		return get("regid");
	}

	public void setAreaid(java.lang.Long areaid) {
		set("areaid", areaid);
	}

	public java.lang.Long getAreaid() {
		return get("areaid");
	}

	public void setSms(java.lang.Integer sms) {
		set("sms", sms);
	}

	public java.lang.Integer getSms() {
		return get("sms");
	}

	public void setCredit(java.lang.Integer credit) {
		set("credit", credit);
	}

	public java.lang.Integer getCredit() {
		return get("credit");
	}

	public void setMoney(java.math.BigDecimal money) {
		set("money", money);
	}

	public java.math.BigDecimal getMoney() {
		return get("money");
	}

	public void setDeposit(java.math.BigDecimal deposit) {
		set("deposit", deposit);
	}

	public java.math.BigDecimal getDeposit() {
		return get("deposit");
	}

	public void setBank(java.lang.String bank) {
		set("bank", bank);
	}

	public java.lang.String getBank() {
		return get("bank");
	}

	public void setBanktype(java.lang.Boolean banktype) {
		set("banktype", banktype);
	}

	public java.lang.Boolean getBanktype() {
		return get("banktype");
	}

	public void setBranch(java.lang.String branch) {
		set("branch", branch);
	}

	public java.lang.String getBranch() {
		return get("branch");
	}

	public void setAccount(java.lang.String account) {
		set("account", account);
	}

	public java.lang.String getAccount() {
		return get("account");
	}

	public void setEdittime(java.lang.Long edittime) {
		set("edittime", edittime);
	}

	public java.lang.Long getEdittime() {
		return get("edittime");
	}

	public void setRegip(java.lang.String regip) {
		set("regip", regip);
	}

	public java.lang.String getRegip() {
		return get("regip");
	}

	public void setRegtime(java.lang.Long regtime) {
		set("regtime", regtime);
	}

	public java.lang.Long getRegtime() {
		return get("regtime");
	}

	public void setLoginip(java.lang.String loginip) {
		set("loginip", loginip);
	}

	public java.lang.String getLoginip() {
		return get("loginip");
	}

	public void setLogintime(java.lang.Long logintime) {
		set("logintime", logintime);
	}

	public java.lang.Long getLogintime() {
		return get("logintime");
	}

	public void setLogintimes(java.lang.Long logintimes) {
		set("logintimes", logintimes);
	}

	public java.lang.Long getLogintimes() {
		return get("logintimes");
	}

	public void setBlack(java.lang.String black) {
		set("black", black);
	}

	public java.lang.String getBlack() {
		return get("black");
	}

	public void setSend(java.lang.Boolean send) {
		set("send", send);
	}

	public java.lang.Boolean getSend() {
		return get("send");
	}

	public void setAuth(java.lang.String auth) {
		set("auth", auth);
	}

	public java.lang.String getAuth() {
		return get("auth");
	}

	public void setAuthvalue(java.lang.String authvalue) {
		set("authvalue", authvalue);
	}

	public java.lang.String getAuthvalue() {
		return get("authvalue");
	}

	public void setAuthtime(java.lang.Long authtime) {
		set("authtime", authtime);
	}

	public java.lang.Long getAuthtime() {
		return get("authtime");
	}

	public void setVemail(java.lang.Boolean vemail) {
		set("vemail", vemail);
	}

	public java.lang.Boolean getVemail() {
		return get("vemail");
	}

	public void setVmobile(java.lang.Boolean vmobile) {
		set("vmobile", vmobile);
	}

	public java.lang.Boolean getVmobile() {
		return get("vmobile");
	}

	public void setVtruename(java.lang.Boolean vtruename) {
		set("vtruename", vtruename);
	}

	public java.lang.Boolean getVtruename() {
		return get("vtruename");
	}

	public void setVbank(java.lang.Boolean vbank) {
		set("vbank", vbank);
	}

	public java.lang.Boolean getVbank() {
		return get("vbank");
	}

	public void setVcompany(java.lang.Boolean vcompany) {
		set("vcompany", vcompany);
	}

	public java.lang.Boolean getVcompany() {
		return get("vcompany");
	}

	public void setVtrade(java.lang.Boolean vtrade) {
		set("vtrade", vtrade);
	}

	public java.lang.Boolean getVtrade() {
		return get("vtrade");
	}

	public void setTrade(java.lang.String trade) {
		set("trade", trade);
	}

	public java.lang.String getTrade() {
		return get("trade");
	}

	public void setSupport(java.lang.String support) {
		set("support", support);
	}

	public java.lang.String getSupport() {
		return get("support");
	}

	public void setInviter(java.lang.String inviter) {
		set("inviter", inviter);
	}

	public java.lang.String getInviter() {
		return get("inviter");
	}

	public void setNote(java.lang.String note) {
		set("note", note);
	}

	public java.lang.String getNote() {
		return get("note");
	}

}
