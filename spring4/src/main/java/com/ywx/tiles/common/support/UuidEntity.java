package com.ywx.tiles.common.support;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import org.hibernate.annotations.GenericGenerator;

/**
 * 统一定义id的entity基类.
 * 
 * 基类统一定义id的属性名称、数据类型、列名映射及生成策略. 子类可重载getId()函数重定义id的列名映射和生成策略.
 * 
 */
@SuppressWarnings("serial")
@MappedSuperclass
public abstract class UuidEntity implements Serializable {

	protected String id;

	// 采用hibernate uuid生成器
	@Id
	// 指定生成器名称
	@GeneratedValue(generator = "uuid2")
	// 生成器名称，uuid生成类
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
