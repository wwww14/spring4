package com.ywx.tiles.dic.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ywx.core.orm.hibernate.HibernateDao;
import com.ywx.tiles.dic.entity.DicResource;

/**
 * 字典资源的泛型DAO
 */
@Component
public class DicResourceDao extends HibernateDao<DicResource> {

	/**
	 * 获取所有字典项列表.
	 * @return 字典项列表.
	 */
	public List<DicResource> findResourceList(String catalog){
		String hql = "from DicResource a where a.catalog=? order by a.listNum";
		return this.find(hql,new Object[]{catalog});
	}
	
	/**
	 * 保存字典项.
	 */
	public void saveResource(DicResource resource){
		this.saveOrUpdate(resource);
	}

}
