package com.ywx.tiles.account.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import com.ywx.tiles.common.support.UuidEntity;

/**
 * 权限信息.<br>
 * 注释见{@link User}.
 */
@Entity
@Table(name = "UA_AUTHORITY")
public class Authority extends UuidEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2320379782504112249L;
	
	/**
	 * SpringSecurity中默认的角色/授权名前缀.
	 */
	public static final String AUTHORITY_PREFIX = "ROLE_";

	/** 权限名称 **/
	private String name;
	/** 权限url **/
	private String url;
	/** 所在角色 **/
	private Set<Role> roles = new HashSet<Role>();
	/** 上级权限 **/
	private Authority parent;
	/** 下级权限 **/
	private Set<Authority> children = new HashSet<Authority>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@ManyToMany
	@JoinTable(name = "UA_ROLE_AUTHORITY", joinColumns = { @JoinColumn(name = "AUTHORITY_ID") }, inverseJoinColumns = { @JoinColumn(name = "ROLE_ID") })
	@Fetch(FetchMode.SUBSELECT)
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@ManyToOne(cascade = CascadeType.REFRESH, optional = false)
	@JoinColumn(name = "parent_id")
	public Authority getParent() {
		return parent;
	}

	public void setParent(Authority parent) {
		this.parent = parent;
	}

	@OneToMany(cascade = { CascadeType.REMOVE, CascadeType.PERSIST })
	@JoinColumn(name = "parent_id")
	public Set<Authority> getChildren() {
		return children;
	}

	public void setChildren(Set<Authority> children) {
		this.children = children;
	}
}
