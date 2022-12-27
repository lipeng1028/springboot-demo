package com.sxit.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import lombok.Data;


@TableName("PGC_ACCOUNT")
@Data
public class PgcAccount extends Model<PgcAccount> {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
	@TableId("ID")
	private Integer id;
    /**
     * 最后登录时间
     */
	@TableField("LASTLOGINDATE")
	private Date lastlogindate;
    /**
     * 用户归属渠道id
     */
	@TableField("CNANNEL_ID")
	private String cnannelId;
    /**
     * 账户未过期
     */
	@TableField("ACCOUNTNONEXPIRED")
	private String accountnonexpired;
    /**
     * 最后登出时间
     */
	@TableField("LASTLOGOUTDATE")
	private Date lastlogoutdate;
    /**
     * 身份证
     */
	@TableField("IDCARD")
	private String idcard;
    /**
     * 市
     */
	@TableField("CITY")
	private String city;
    /**
     * 用户角色id
     */
	@TableField("ROLE_ID")
	private String roleId;
    /**
     * 登录名
     */
	@TableField("LOGINNAME")
	private String loginname;
	/**
     * 4A登录名
     */
	@TableField("LOGINNAME4A")
	private String loginname4A;
    /**
     * 密码未过期
     */
	@TableField("CREDENTIALSNONEXPIRED")
	private String credentialsnonexpired;
    /**
     * 创建人
     */
	@TableField("CREATE_ID")
	private Integer createId;
    /**
     * 区
     */
	@TableField("AREA")
	private String area;
    /**
     * 手机号
     */
	@TableField("PHONE")
	private String phone;
    /**
     * 创建时间
     */
	@TableField("CREATE_TIME")
	private Date createTime;
    /**
     * 账户未锁定
     */
	@TableField("ACCOUNTNONLOCKED")
	private String accountnonlocked;
    /**
     * 最后登录IP
     */
	@TableField("LASTLOGINIP")
	private String lastloginip;
    /**
     * 是否生效
     */
	@TableField("ENABLED")
	private String enabled;
    /**
     * 密码
     */
	@TableField("PASSWORD")
	private String password;
    /**
     * 街道
     */
	@TableField("STREET")
	private String street;
    /**
     * 省
     */
	@TableField("PROVINCE")
	private String province;
    /**
     * 邮件
     */
	@TableField("EMAIL")
	private String email;
    /**
     * 用户名
     */
	@TableField("USERNAME")
	private String username;

//	@Override
//	protected Serializable pkVal() {
//		return this.id;
//	}
//
//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	public Date getLastlogindate() {
//		return lastlogindate;
//	}
//
//	public void setLastlogindate(Date lastlogindate) {
//		this.lastlogindate = lastlogindate;
//	}
//
//	public String getCnannelId() {
//		return cnannelId;
//	}
//
//	public void setCnannelId(String cnannelId) {
//		this.cnannelId = cnannelId;
//	}
//
//	public String getAccountnonexpired() {
//		return accountnonexpired;
//	}
//
//	public void setAccountnonexpired(String accountnonexpired) {
//		this.accountnonexpired = accountnonexpired;
//	}
//
//	public Date getLastlogoutdate() {
//		return lastlogoutdate;
//	}
//
//	public void setLastlogoutdate(Date lastlogoutdate) {
//		this.lastlogoutdate = lastlogoutdate;
//	}
//
//	public String getIdcard() {
//		return idcard;
//	}
//
//	public void setIdcard(String idcard) {
//		this.idcard = idcard;
//	}
//
//	public String getCity() {
//		return city;
//	}
//
//	public void setCity(String city) {
//		this.city = city;
//	}
//
//	public String getRoleId() {
//		return roleId;
//	}
//
//	public void setRoleId(String roleId) {
//		this.roleId = roleId;
//	}
//
//	public String getLoginname() {
//		return loginname;
//	}
//
//	public void setLoginname(String loginname) {
//		this.loginname = loginname;
//	}
//
//	public String getLoginname4A() {
//		return loginname4A;
//	}
//
//	public void setLoginname4A(String loginname4a) {
//		loginname4A = loginname4a;
//	}
//
//	public String getCredentialsnonexpired() {
//		return credentialsnonexpired;
//	}
//
//	public void setCredentialsnonexpired(String credentialsnonexpired) {
//		this.credentialsnonexpired = credentialsnonexpired;
//	}
//
//	public Integer getCreateId() {
//		return createId;
//	}
//
//	public void setCreateId(Integer createId) {
//		this.createId = createId;
//	}
//
//	public String getArea() {
//		return area;
//	}
//
//	public void setArea(String area) {
//		this.area = area;
//	}
//
//	public String getPhone() {
//		return phone;
//	}
//
//	public void setPhone(String phone) {
//		this.phone = phone;
//	}
//
//	public Date getCreateTime() {
//		return createTime;
//	}
//
//	public void setCreateTime(Date createTime) {
//		this.createTime = createTime;
//	}
//
//	public String getAccountnonlocked() {
//		return accountnonlocked;
//	}
//
//	public void setAccountnonlocked(String accountnonlocked) {
//		this.accountnonlocked = accountnonlocked;
//	}
//
//	public String getLastloginip() {
//		return lastloginip;
//	}
//
//	public void setLastloginip(String lastloginip) {
//		this.lastloginip = lastloginip;
//	}
//
//	public String getEnabled() {
//		return enabled;
//	}
//
//	public void setEnabled(String enabled) {
//		this.enabled = enabled;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public String getStreet() {
//		return street;
//	}
//
//	public void setStreet(String street) {
//		this.street = street;
//	}
//
//	public String getProvince() {
//		return province;
//	}
//
//	public void setProvince(String province) {
//		this.province = province;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//	@Override
//	public String toString() {
//		return "PgcAccount [id=" + id + ", lastlogindate=" + lastlogindate + ", cnannelId=" + cnannelId
//				+ ", accountnonexpired=" + accountnonexpired + ", lastlogoutdate=" + lastlogoutdate + ", idcard="
//				+ idcard + ", city=" + city + ", roleId=" + roleId + ", loginname=" + loginname + ", loginname4A="
//				+ loginname4A + ", credentialsnonexpired=" + credentialsnonexpired + ", createId=" + createId
//				+ ", area=" + area + ", phone=" + phone + ", createTime=" + createTime + ", accountnonlocked="
//				+ accountnonlocked + ", lastloginip=" + lastloginip + ", enabled=" + enabled + ", password=" + password
//				+ ", street=" + street + ", province=" + province + ", email=" + email + ", username=" + username + "]";
//	}

}
