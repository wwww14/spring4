package com.ywx.tiles.dic.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.ywx.tiles.common.support.AutoIdEntiy;

/**
 * 字典配置类.
 */
@Entity
@Table(name = "XT_DIC_CONFIG")
public class DicConfig extends AutoIdEntiy {
	/**
	 * 字典名称.
	 */
	private String dicName;
	/**
	 * 字典代码.
	 */
	private String dicCode;
	/**
	 * 字典类型.
	 */
	private Integer dicType;
	/**
	 * 对应数据库表名.
	 */
	private String tableName;
	/**
	 * 字典项键值对应字段名.
	 */
	private String itemKeyColumn;
	/**
	 * 字典项名称对应字段名.
	 */
	private String itemNameColumn;
	/**
	 * 附加sql条件.
	 */
	private String appendSql;
	/**
	 * 列表值.
	 */
	private String valueList;
	/**
	 * 描述.
	 */
	private String dicDesc;
	/**
	 * 构造函数.
	 */
	public DicConfig() {
		
	}

	public String getDicName() {
		return dicName;
	}

	public void setDicName(String dicName) {
		this.dicName = dicName;
	}

	public String getDicCode() {
		return dicCode;
	}

	public void setDicCode(String dicCode) {
		this.dicCode = dicCode;
	}

	public Integer getDicType() {
		return dicType;
	}

	public void setDicType(Integer dicType) {
		this.dicType = dicType;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getItemKeyColumn() {
		return itemKeyColumn;
	}

	public void setItemKeyColumn(String itemKeyColumn) {
		this.itemKeyColumn = itemKeyColumn;
	}

	public String getItemNameColumn() {
		return itemNameColumn;
	}

	public void setItemNameColumn(String itemNameColumn) {
		this.itemNameColumn = itemNameColumn;
	}

	public String getAppendSql() {
		return appendSql;
	}

	public void setAppendSql(String appendSql) {
		this.appendSql = appendSql;
	}

	public String getValueList() {
		return valueList;
	}

	public void setValueList(String valueList) {
		this.valueList = valueList;
	}

	public String getDicDesc() {
		return dicDesc;
	}

	public void setDicDesc(String dicDesc) {
		this.dicDesc = dicDesc;
	}
}
