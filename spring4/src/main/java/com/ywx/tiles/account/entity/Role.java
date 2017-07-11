package com.ywx.tiles.account.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.ywx.tiles.common.support.UuidEntity;

/**
 * 角色信息. <br>
 * 注释见{@link User}.
 */
@Entity
@Table(name = "UA_ROLE")
public class Role extends UuidEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4786169671830374363L;

	/** 角色名称 **/
	private String roleName;
	/** 角色类型 **/
	private String roleType;
	/** 角色描述 **/
	private String description;
	/** 角色中包含的用户 **/
	private Set<User> users = new HashSet<User>();
	/** 角色中包含的权限 **/
	private Set<Authority> authorityList = new HashSet<Authority>();

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToMany
	@JoinTable(name = "UA_USER_ROLE", joinColumns = { @JoinColumn(name = "ROLE_ID") }, inverseJoinColumns = { @JoinColumn(name = "USER_ID") })
	@Fetch(FetchMode.SUBSELECT)
	@OrderBy("id")
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@ManyToMany
	@JoinTable(name = "UA_ROLE_AUTHORITY", joinColumns = { @JoinColumn(name = "ROLE_ID") }, inverseJoinColumns = { @JoinColumn(name = "AUTHORITY_ID") })
	@Fetch(FetchMode.SUBSELECT)
	public Set<Authority> getAuthorityList() {
		return authorityList;
	}

	public void setAuthorityList(Set<Authority> authorityList) {
		this.authorityList = authorityList;
	}
}
