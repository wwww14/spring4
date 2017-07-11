package com.ywx.tiles.common.servlet;

import javax.servlet.http.HttpServlet;
import org.springframework.context.ApplicationContext;
import com.ywx.core.utils.SpringContextHolder;
import com.ywx.tiles.dic.service.DicConfigManager;

public class ConfigServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 381853424148858718L;

	/**
	 * 初始化servlet
	 */
	public void init() {
		// 获取上下文环境
		ApplicationContext ctx = SpringContextHolder.getApplicationContext();
		// 获取字典管理bean
		DicConfigManager dicConfigManager = ctx.getBean(DicConfigManager.class);
		// 加载所有字典
		dicConfigManager.loadAllDic();
	}

}
