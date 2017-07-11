package com.ywx.tiles.dic.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ywx.tiles.dic.dao.DicResourceDao;
import com.ywx.tiles.dic.entity.DicResource;

/**
 * 字典资源管理类.
 */

@Component
// 默认将类中的所有函数纳入事务管理.
@Transactional
public class DicResourceManager {

	private DicResourceDao dicResourceDao;

	@Autowired
	public void setDicResourceDao(DicResourceDao dicResourceDao) {
		this.dicResourceDao = dicResourceDao;
	}

	/**
	 * 使用属性过滤条件查询.
	 */
	@Transactional(readOnly = true)
	public List<DicResource> findResourceList(String catalog) {
		List<DicResource> retList = dicResourceDao.findResourceList(catalog);
		if (retList == null) {
			retList = new ArrayList<DicResource>();
		}
		return retList;
	}

	/**
	 * 保存字资源列表
	 */
	@Transactional(readOnly = false)
	public void saveResourceList(List<DicResource> resourceList, String delList) {

		// 保存修改的数据

		if (resourceList != null) {
			for (DicResource resource : resourceList) {
				if (resource != null) {
					if (StringUtils.isEmpty(resource.getParentUid())) {
						resource.setParentUid("0");
					}
					dicResourceDao.saveResource(resource);
				}
			}
		}
		// 删除数据
		if (StringUtils.isNotEmpty(delList)) {
			delList = delList.substring(0, delList.length() - 1);
			String[] delListStr = delList.split(",");
			for (String resId : delListStr) {
				dicResourceDao.delete(resId);
			}
		}
	}

	/**
	 * 根据resId获取resource对象.
	 */
	@Transactional(readOnly = true)
	public DicResource findResourceByResId(String resId) {
		return dicResourceDao.get(resId);
	}

}
