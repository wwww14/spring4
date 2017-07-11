package com.ywx.tiles.dic;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.google.common.collect.Maps;

/**
 * 字典数据管理工具类.
 * <p>
 * 通过该类的方法可以进行以下的操作：<br>
 * 1.得到某个字典的内容列表。<br>
 * 2.根据字典项代码得到字典项名称。<br>
 * 3.将新加载的字典数据保存到该类中。 
 * <p>
 */
public class DicDataUtils {

	/** 日志 **/
	private static Logger logger = Logger.getLogger(DicDataUtils.class);

	/** 唯一类实例 **/
	private static DicDataUtils instance = new DicDataUtils();

	/** 字典配置信息列表 **/
	public static Map<String, Map<String, String>> dicMap = Maps.newHashMap();

	/**
	 * 默认的私有构建器
	 */
	private DicDataUtils() {
	}

	/**
	 * 得到该类的唯一实例。
	 * <p>
	 * 
	 * @return 该类的唯一实例
	 */
	public static DicDataUtils getInstance() {
		return instance;
	}

	/**
	 * 将加载的字典放入该工具类中。
	 * 
	 * @param dicId
	 *            字典编号
	 * @param dataMap
	 *            字典数据列表
	 */
	public synchronized void putDic(String dicId, Map<String, String> dataMap) {
		if (dicMap.containsKey(dicId)) {
			dicMap.remove(dicId);
		}
		dicMap.put(dicId, dataMap);
	}

	/**
	 * 根据字典编号得到字典内容列表。
	 * <p>
	 * 
	 * @param dicId
	 *            字典编号
	 * @return 字典内容列表
	 */
	public static Map<String, String> getDic(String dicId) {
		if (dicMap.containsKey(dicId) == false) {
			logger.error("该字典不存在。 dic_id = " + dicId);
			return Maps.newHashMap();
		}
		return dicMap.get(dicId);
	}

	/**
	 * 根据传入的字典编号和键值得到描述信息。
	 * <p>
	 * 
	 * @param dicId
	 *            字典编号
	 * @param itemKey
	 *            键值
	 * 
	 * @return 描述信息
	 */
	public static String getDicItemName(String dicId, Object itemKey) {
		if (itemKey == null) {
			return null;
		}
		Map<String, String> map = getDic(dicId);
		String itemName = (String) map.get(itemKey);

		if (StringUtils.isEmpty(itemName)) {
			return itemKey.toString();
		} else {
			return itemName;
		}
	}

}
