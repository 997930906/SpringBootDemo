package cn.whu.controller;

import cn.whu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Controller
public class IndexController {
	//单实现类注入
	/*@Autowired
	private UserService userService;*/
	//多实现类注入
	@Resource(name="UserserviceImpl")
	private UserService userServiceImpl;

	@RequestMapping(path={"/setting"})
	@ResponseBody
	public String setting() {
		userServiceImpl.setting();
		return "setting";
	}

	@RequestMapping("/index")
	public String index() {
		System.out.println("Hello World!");
		return "index";
	}

	//restful风格传参
	@RequestMapping(path={"/profile/{userId}/{groupId}"})
	@ResponseBody
	public String profile(@PathVariable("userId") int userId,
						  @PathVariable("groupId") int groupId) {

		System.out.println(String.format("profile id is %d" , userId));
		return String.format("your profile id is  %d/ %d" , userId,groupId);
	}

	@RequestMapping(path={"/home"})
	@ResponseBody
	public String home() {
		return "home";
	}


}
