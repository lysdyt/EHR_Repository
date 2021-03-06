package com.babifood.control;



import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.babifood.entity.LoginEntity;
import com.babifood.entity.UserRoleEntity;
import com.babifood.service.HomePageService;

@Controller
public class HomePageControl {
	@Autowired
	HomePageService homePageService;
	/**
	 * 获取导航菜单列表
	 * @param id父及菜单id
	 * @return 返回菜单对象集合
	 */
	@ResponseBody
	@RequestMapping("/loadTerr")
	public List<Map<String,Object>> loadTreeMenu(String id,HttpServletRequest request){
		//从shiro的session中取activeUser
		Subject subject = SecurityUtils.getSubject();
		//取身份信息
		LoginEntity activeUser = (LoginEntity) subject.getPrincipal();
		StringBuffer strRole = new StringBuffer();
		List<UserRoleEntity> roleList = activeUser.getRoleList();
		for (int i = 0;i<roleList.size();i++) {
			strRole.append("'");
			strRole.append(roleList.get(i).getRole_id());
			if(i==roleList.size()-1){
				strRole.append("'");
			}else{
				strRole.append("',");
			}
		}
		
		return homePageService.LoadTerrMenu(id,strRole.toString());
	}
	//系统首页
	@RequestMapping("/HomePage")
	public String first(Model model)throws Exception{
		
		//从shiro的session中取activeUser
		Subject subject = SecurityUtils.getSubject();
		//取身份信息
		LoginEntity activeUser = (LoginEntity) subject.getPrincipal();
		//通过model传到页面
		model.addAttribute("activeUser", activeUser);
		
		return "/HomePage";
	}	
}
