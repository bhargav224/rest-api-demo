package webdemo.mvcspring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import webdemo.mvcspring.dto.UserLoginDTO;
import webdemo.mvcspring.dto.UserSearchDTO;
import webdemo.mvcspring.model.User;
import webdemo.mvcspring.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;

	@Transactional
	public void register(User user)
	{
		userRepo.register(user);
	}
	
	
	public String login(UserLoginDTO loginDTO)
	{
		return userRepo.login(loginDTO);
	}
	
	
	public List<User> search(UserSearchDTO searchDTO)
	{
		return userRepo.search(searchDTO);
	}
	
	
	public List<String> permutation(String input)
	{
		List<String> result = new ArrayList<String>();
		return findPermutation("",input,result);
	}
	
	private List<String> findPermutation(String s1,String s2,List<String> result)
	{
		int len = s2.length();
		if(len == 0 ) result.add(s1);
		else {
			for(int i=0;i<len;i++)
			{
				findPermutation(s1+s2.charAt(i),s2.substring(0,i)+s2.substring(i+1,len),result);
			}
		}
		
		return result;
	}
	
	
	
	
}
