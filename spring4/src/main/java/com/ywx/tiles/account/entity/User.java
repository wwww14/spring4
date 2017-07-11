package com.ywx.tiles.account.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import com.ywx.tiles.common.support.UuidEntity;

/**
 * 用户信息.<br>
 * 使用JPA annotation定义ORM关系.
 */
@Entity
@Table(name = "UA_USER")
public class User extends UuidEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3997322258166615391L;

	/** 登录名称 **/
	private String loginName;
	/** 登录密码 **/
	private String password;
	/** 显示名称 **/
	private String displayName;
	/** 性别 **/
	private String gender;
	/** 状态 **/
	private String status;
	/** 本次登录日期 **/
	private Timestamp currentLoginDate;
	/** 上次登录日期 **/
	private Timestamp lastLoginDate;
	/** 登录失败次数 **/
	private Integer FailTimes;
	/** 是否锁定标记：1-锁定，0-否 **/
	private String lockFlag;
	/** 锁定日期 **/
	private Timestamp lockDate;
	/** 联系电话 **/
	private String mobilePhone;
	/** 电子邮箱 **/
	private String email;
	/** 人员排序 **/
	private String orderNum;

	/** 所属部门 **/
	private Department department;
	/** 角色 **/
	private Set<Role> roles = new HashSet<Role>();

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getCurrentLoginDate() {
		return currentLoginDate;
	}

	public void setCurrentLoginDate(Timestamp currentLoginDate) {
		this.currentLoginDate = currentLoginDate;
	}

	public Timestamp getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Timestamp lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public Integer getFailTimes() {
		return FailTimes;
	}

	public void setFailTimes(Integer failTimes) {
		FailTimes = failTimes;
	}

	public String getLockFlag() {
		return lockFlag;
	}

	public void setLockFlag(String lockFlag) {
		this.lockFlag = lockFlag;
	}

	public Timestamp getLockDate() {
		return lockDate;
	}

	public void setLockDate(Timestamp lockDate) {
		this.lockDate = lockDate;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	@ManyToOne(cascade = CascadeType.REFRESH, optional = false)
	@JoinColumn(name="department_id")
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	// 多对多定义
	@ManyToMany
	// 中间表定义,表名采用默认命名规则
	@JoinTable(name = "UA_USER_ROLE", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = { @JoinColumn(name = "ROLE_ID") })
	// Fecth策略定义
	@Fetch(FetchMode.SUBSELECT)
	// 集合按id排序.
	@OrderBy("id")
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
