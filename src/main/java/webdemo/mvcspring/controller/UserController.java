package webdemo.mvcspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import webdemo.mvcspring.dto.UserLoginDTO;
import webdemo.mvcspring.dto.UserSearchDTO;
import webdemo.mvcspring.model.User;
import webdemo.mvcspring.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	@ResponseBody
	public void register(@RequestBody User user)
	{
		userService.register(user);
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ResponseBody
	public String login(@RequestBody UserLoginDTO loginDTO)
	{
		return userService.login(loginDTO);
	}
	
	@RequestMapping(value="/search",method=RequestMethod.POST)
	@ResponseBody
	public List<User> search(@RequestBody UserSearchDTO searchDTO)
	{
		 return userService.search(searchDTO);
	}
	
	
	@RequestMapping(value="/permutation/{input}",method=RequestMethod.GET)
	@ResponseBody
	public String permutation(@PathVariable String input)
	{
		return userService.permutation(input).toString();
	}
	
	
	

}
