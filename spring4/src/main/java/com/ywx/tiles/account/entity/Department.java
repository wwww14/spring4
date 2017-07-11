package com.ywx.tiles.account.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ywx.tiles.common.support.UuidEntity;

/**
 * 部门信息.<br>
 * 注释见{@link User}.
 */
@Entity
@Table(name = "UA_DEPARTMENT")
public class Department extends UuidEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3568385824250455284L;

	/** 部门名称 **/
	private String name;
	/** 描述 **/
	private String description;
	/** 部门下的用户 **/
	private Set<User> users = new HashSet<User>();
	/** 上级部门 **/
	private Department parent;
	/** 下级部门 **/
	private Set<Department> children = new HashSet<Department>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(targetEntity = User.class, cascade = { CascadeType.REMOVE, CascadeType.PERSIST })
	@JoinColumn(name = "department_id")
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "parent_id")
	public Department getParent() {
		return parent;
	}

	public void setParent(Department parent) {
		this.parent = parent;
	}

	@OneToMany(cascade = { CascadeType.REMOVE, CascadeType.PERSIST })
	@JoinColumn(name = "parent_id")
	public Set<Department> getChildren() {
		return children;
	}

	public void setChildren(Set<Department> children) {
		this.children = children;
	}

}
