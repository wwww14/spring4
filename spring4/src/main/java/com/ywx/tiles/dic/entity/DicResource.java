package com.ywx.tiles.dic.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.ywx.tiles.common.support.UuidEntity;

/**
 * 字典资源类.
 */
@Entity
@Table(name = "XT_DIC_RESOURCE")
public class DicResource extends UuidEntity{

	/** 代码 */
	private String typeId;

	/** 名称 */
	private String typeName;

	/** 父类主键 */
	private String parentUid;

	/** 类型 */
	private String catalog;

	/** 有效性 */
	private String validity;

	/** 排序 */
	private Integer listNum;

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getParentUid() {
		return parentUid;
	}

	public void setParentUid(String parentUid) {
		this.parentUid = parentUid;
	}

	public String getCatalog() {
		return catalog;
	}

	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}

	public String getValidity() {
		return validity;
	}

	public void setValidity(String validity) {
		this.validity = validity;
	}

	public Integer getListNum() {
		return listNum;
	}

	public void setListNum(Integer listNum) {
		this.listNum = listNum;
	}
}
