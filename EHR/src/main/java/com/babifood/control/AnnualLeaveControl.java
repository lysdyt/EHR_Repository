package com.babifood.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.babifood.service.AnnualLeaveService;


@Controller
public class AnnualLeaveControl{
	@Autowired
	AnnualLeaveService AnnualLeaveService;
	/**
	 * 查询所有当前年假记录
	 * @return 返回年假记录json
	 */
	@ResponseBody
	@RequestMapping("/loadNowAnnualLeave")
	public Map<String,Object> loadNowAnnualLeave(String npname){
		Map<String,Object> map =new HashMap<String,Object>();
		List<Map<String, Object>> list = AnnualLeaveService.loadNowAnnualLeave(npname);
		map.put("total", list.size());
		map.put("rows", list);
		return map;
	}
	/**
	 * 查询所有历史年假记录
	 * @return 返回年假记录json
	 */
	@ResponseBody
	@RequestMapping("/loadHistoryAnnualLeave")
	public Map<String,Object> loadHistoryAnnualLeave(String lpname){
		Map<String,Object> map =new HashMap<String,Object>();
		List<Map<String, Object>> list = AnnualLeaveService.loadHistoryAnnualLeave(lpname);
		map.put("total", list.size());
		map.put("rows", list);
		return map;
	}
	

	
}
