package cn.whu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class IndexController {

	@RequestMapping("/index")
	public String index() {
		System.out.println("Hello World!");
		return "index";
	}

	@RequestMapping(path={"/profile/{userId}/{groupId}"})
	@ResponseBody
	public String profile(@PathVariable("userId") int userId,
						  @PathVariable("groupId") int groupId) {

		System.out.println(String.format("profile id is %d" , userId));
		return String.format("your profile id is  %d/ %d" , userId,groupId);
	}
}
