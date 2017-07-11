package com.ywx.tiles.dic.service;

import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Maps;
import com.ywx.core.orm.Page;
import com.ywx.core.orm.PropertyFilter;
import com.ywx.tiles.dic.DicDataUtils;
import com.ywx.tiles.dic.dao.DicConfigDao;
import com.ywx.tiles.dic.dao.DicResourceDao;
import com.ywx.tiles.dic.entity.DicConfig;
import com.ywx.tiles.dic.entity.DicResource;

/**
 * 字典配置装载的管理类.
 */

@Component
//默认将类中的所有函数纳入事务管理.
@Transactional
public class DicConfigManager {
	private static Logger logger = LoggerFactory.getLogger(DicConfigManager.class);

	/** 字典类型“字典表” */
	public static final int DIC_TYPE_TABLE = 1;

	/** 字典类型“列表” */
	public static final int DIC_TYPE_VALUELIST = 2;

	/** 字典内容字符串中每一个条目之间的分隔符 */
	public static final String SEP_VALUELIST = "|";

	/** 字典内容字符串中每一个条目的键值与描述之间的分隔符 */
	public static final String SEP_ID_AND_DESCRIPTION = "=";

	@Autowired
	private DicConfigDao dicConfigDao;

	private DicResourceDao dicResourceDao;

	@Autowired
	public void setDicConfigDao(DicConfigDao dicConfigDao) {
		this.dicConfigDao = dicConfigDao;
	}

	public DicResourceDao getDicResourceDao() {
		return dicResourceDao;
	}

	@Transactional(readOnly = true)
	public DicConfig dicConfig(Long id) {
		return dicConfigDao.get(id);
	}

	@Transactional(readOnly = true)
	public List<DicConfig> getAllDicConfig() {
		return dicConfigDao.getAll("id", true);
	}

	public void saveDic(DicConfig entity) {
		dicConfigDao.save(entity);
	}

	/**
	 * 使用属性过滤条件查询用户.
	 */
	@Transactional(readOnly = true)
	public Page<DicConfig> searchDicConfig(final Page<DicConfig> page, final List<PropertyFilter> filters) {
		return dicConfigDao.findPage(page, filters);
	}

	/**
	 * 加载所有字典的数据,启动时加载。
	 */
	public void loadAllDic() {
		// 获取字典配置信息
		List<DicConfig> configList = dicConfigDao.getAll("id", true);
		if (configList != null) {
			// 依次加载字典信息
			for (DicConfig config : configList) {
				this.loadDic(config);
			}
			logger.info("加载了字典数量：" + configList.size());
		}
	}

	/**
	 * 加载字典的数据。
	 * 
	 * 
	 * @param config
	 *            字典配置信息
	 */
	private void loadDic(DicConfig config) {
		if (config.getDicType() == null) {
			logger.error("字典配置信息不完整。dic_id = " + config.getDicCode());
			return;
		}
		Map<String, String> map = null;
		int dicType = config.getDicType().intValue();

		switch (dicType) {
		case DIC_TYPE_TABLE:
			map = this.findDicDataList(config);
			break;
		case DIC_TYPE_VALUELIST:
			map = this.parseDicDataOfList(config);
			break;
		default:
			logger.error("字典类型错误。 dic_id = " + config.getDicCode());
			return;
		}
		// 将载入的字典数据放入字典工具类中
		DicDataUtils.getInstance().putDic(config.getDicCode(), map);
	}

	/**
	 * 解析列表字典。
	 * 
	 * 
	 * @param config
	 *            字典配置信息
	 * @return Map 字典列表
	 */
	private Map<String, String> parseDicDataOfList(DicConfig config) {
		// 检查配置信息

		if (StringUtils.isEmpty(config.getValueList())) {
			// 如果配置信息错误，则不加载，并抛错

			logger.error("字典配置信息不完整。dic_id = " + config.getDicCode());
		}
		// 解析字符串

		StringTokenizer token = new StringTokenizer(config.getValueList(), SEP_VALUELIST);
		Map<String, String> map = Maps.newHashMap();
		while (token.hasMoreTokens()) { // 遍历
			// 得到键值和描述
			String entry = token.nextToken();
			int pos = entry.indexOf(SEP_ID_AND_DESCRIPTION);
			if (pos > 0 && pos < entry.length() - 1) {
				// 如果找到分隔符并确实存在键值和描述
				String key = entry.substring(0, pos);
				String name = entry.substring(pos + SEP_ID_AND_DESCRIPTION.length());
				// 添加至列表中
				map.put(key, name);
			}
		}
		return map;
	}

	/**
	 * 取得数据库中字典值的列表
	 * 
	 * @param dicConfig
	 *            字典配置信息
	 * @return Map 字典值列表
	 */
	private Map<String, String> findDicDataList(DicConfig dicConfig) {
		// 检查配置信息

		if (StringUtils.isEmpty(dicConfig.getTableName()) || StringUtils.isEmpty(dicConfig.getItemKeyColumn()) || StringUtils.isEmpty(dicConfig.getItemNameColumn())) {
			// 如果配置信息错误，则不加载，并抛错

			logger.error("字典配置信息不完整。 dic_id = " + dicConfig.getDicCode());
		}
		// 根据配置信息设置SQL语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append(dicConfig.getItemKeyColumn());
		sql.append(",");
		sql.append(dicConfig.getItemNameColumn());
		sql.append(" FROM ");
		sql.append(dicConfig.getTableName());
		if (StringUtils.isNotEmpty(dicConfig.getAppendSql())) { // 如果条件不为空

			// 则添加条件
			sql.append(" WHERE VALIDITY='1' AND ");
			sql.append(dicConfig.getAppendSql());
		}
		Map<String, String> map = this.dicConfigDao.findDicDataList(dicConfig.getDicCode(), sql.toString());
		return map;
	}

	/**
	 * 检查字典代码或者字典名称是否唯一.
	 * 
	 * @return dicCode或dicName在数据库中唯一时返回true.
	 */
	@Transactional(readOnly = true)
	public boolean isDicUnique(String oldValue, String newValue, String checkColumn) {
		return dicConfigDao.isPropertyUnique(checkColumn, newValue, oldValue);
	}

	/**
	 * 删除字典
	 */
	public void deleteDic(Long id) {
		DicConfig dicConfig = dicConfigDao.get(id);
		// 如果是字典表，循环删除字典值

		if (dicConfig.getDicType() == DIC_TYPE_TABLE) {
			// 获取字典值列表

			List<DicResource> dicResourceList = dicResourceDao.findBy("catalog", dicConfig.getDicCode());
			if (dicResourceList != null && dicResourceList.size() > 0) {
				for (int i = 0; i < dicResourceList.size(); i++) {
					dicResourceDao.delete(dicResourceList.get(i));
				}
			}
		}
		dicConfigDao.delete(id);
	}

}
