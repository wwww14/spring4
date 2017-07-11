package com.ywx.tiles.account.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/frame")
public class FrameControl {

	/** 模块前缀 **/
	private static final String PREFIX = "frame/";

	@RequestMapping("/top")
	public String top() {
		return PREFIX + "top";
	}
	
	@RequestMapping("/left")
	public String left() {
		return PREFIX + "left";
	}
	
	@RequestMapping("/bottom")
	public String bottom() {
		return PREFIX + "bottom";
	}
	
	@RequestMapping("/right")
	public String right() {
		return PREFIX + "right";
	}

}
