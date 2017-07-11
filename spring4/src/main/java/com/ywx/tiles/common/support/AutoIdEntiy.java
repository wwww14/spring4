package com.ywx.tiles.common.support;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * 统一定义id的entity基类.
 * 生成方式：自增长.
 */
@SuppressWarnings("serial")
@MappedSuperclass
public abstract class AutoIdEntiy implements Serializable{
	protected Long id;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
