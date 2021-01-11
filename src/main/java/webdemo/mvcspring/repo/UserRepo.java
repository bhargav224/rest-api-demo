package webdemo.mvcspring.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import webdemo.mvcspring.dto.UserLoginDTO;
import webdemo.mvcspring.dto.UserSearchDTO;
import webdemo.mvcspring.model.User;

@Repository
public class UserRepo{
	
	
	public void register(User user)
	{
		
	}
	
	
	public String login(UserLoginDTO loginDTO)
	{
		return "login";
	}
	
	
	public List<User> search(UserSearchDTO searchDTO)
	{
		return null;
	}

}
