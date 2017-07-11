package com.ywx.tiles.dic.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import org.springframework.orm.hibernate4.SessionFactoryUtils;
import org.springframework.stereotype.Component;

import com.google.common.collect.Maps;
import com.ywx.core.orm.hibernate.HibernateDao;
import com.ywx.tiles.dic.entity.DicConfig;

/**
 * 字典配置的泛型DAO.
 */
@Component
public class DicConfigDao extends HibernateDao<DicConfig> {

	/**
	 * 取得数据库中字典值的列表
	 * 
	 * @param dicConfig
	 *            字典配置信息
	 * @return Map 字典值列表
	 */
	public Map<String, String> findDicDataList(String dicCode, String sql) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Map<String, String> map = Maps.newLinkedHashMap();

		try {
			// 执行SQL语句并得到结果集
			conn = SessionFactoryUtils.getDataSource(getSessionFactory()).getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) { // 遍历结果集

				// 添加字典信息
				map.put(rs.getString(1), rs.getString(2));
			}
		} catch (Exception ex) {
			logger.error("字典数据加载错误。 dic_id = " + dicCode);
			logger.error(ex.getMessage(), ex);
		} finally {
			this.release(rs, stmt, conn);
		}

		return map;
	}

	/**
	 * 释放链接
	 * 
	 * @param rs
	 * @param stmt
	 * @param conn
	 */
	protected void release(ResultSet rs, Statement stmt, Connection conn) {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}
	}
}
