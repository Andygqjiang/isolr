package com.sys.manager.model;

import javacommon.base.BaseModel;

import java.util.List;

/**
 * 类描述: 用户登录数据对象
 * 
 * @author Andy
 * @since 2016/4/28
 */
public class LoginUser implements java.io.Serializable {

	private static final long serialVersionUID = -8181177514586902210L;

	private long id;

	private long companyId;

	private String cpAccount;

	private String account;

	private String password;

	private long dpId;

	private String dpName;

	private String dpCode;

	private String childrenUser;

	private String imAccount;

	private String token;

	private String cpName; // 公司名

	private String name; // 用户真实姓名

	private int userType;

	private int webChat;// 是否同意使用叮当享,1=同意,2=禁止

	private String jobRole;

	private List<String> inChargeDpCode;
	
	private Integer versionNum;//公司所使用的版本信息

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	public List<String> getInChargeDpCode() {
		return inChargeDpCode;
	}

	public void setInChargeDpCode(List<String> inChargeDpCode) {
		this.inChargeDpCode = inChargeDpCode;
	}

	public int getUserType() {
		return userType;
	}

	public Integer getVersionNum() {
		return versionNum;
	}

	public void setVersionNum(Integer versionNum) {
		this.versionNum = versionNum;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public String getDpCode() {
		return dpCode;
	}

	public void setDpCode(String dpCode) {
		this.dpCode = dpCode;
	}

	public String getCpName() {
		return cpName;
	}

	public void setCpName(String cpName) {
		this.cpName = cpName;
	}

	public String getJobRole() {
		return jobRole;
	}

	public void setJobRole(String jobRole) {
		this.jobRole = jobRole;
	}

	public int getWebChat() {
		return webChat;
	}

	public void setWebChat(int webChat) {
		this.webChat = webChat;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getImAccount() {
		return imAccount;
	}

	public void setImAccount(String imAccount) {
		this.imAccount = imAccount;
	}

	public long getDpId() {
		return dpId;
	}

	public void setDpId(long dpId) {
		this.dpId = dpId;
	}

	public String getDpName() {
		return dpName;
	}

	public void setDpName(String dpName) {
		this.dpName = dpName;
	}

	public String getChildrenUser() {
		return childrenUser;
	}

	public void setChildrenUser(String childrenUser) {
		this.childrenUser = childrenUser;
	}

	public String getCpAccount() {
		return cpAccount;
	}

	public void setCpAccount(String cpAccount) {
		this.cpAccount = cpAccount;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginUser{" + "id=" + getId() + ", cpAccount='" + cpAccount + '\'' + ", account='" + account + '\''
				+ ", password='" + password + '\'' + ", dpId=" + dpId + ", dpName='" + dpName + '\''
				+ ", childrenUser='" + childrenUser + '\'' + ", imAccount='" + imAccount + '\'' + ", token='" + token
				+ '\'' + ", companyId=" + getCompanyId() + ", name='" + name + '\'' + '}';
	}
}
