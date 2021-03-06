package com.wuwei.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;

import org.hibernate.validator.constraints.Email;
import org.springframework.stereotype.Service;
import com.wuwei.dao.UserHibernet;
import com.wuwei.entity.Result;
import com.wuwei.entity.User;

@Service
public class UserService {

	@Resource(name = "UserHibernet")
	private UserHibernet userHibernet;
	private static final Logger logger = Logger.getLogger(UserService.class.getName());

	public Result getAllUsers() {
		Result result = new Result();
		try {
			result.setData(userHibernet.getAll());
			if(result.getData()!=null)
				result.setStatus(1);
				else
					result.setStatus(0);
		} catch (Exception e) {
			logger.log(Level.SEVERE, null, e);
		}
		return result;
	}

	public Result getUserByEmail(String email) {
		Result result = new Result();
		try {
			result.setData(userHibernet.getByName(email));
			if(result.getData()!=null)
			result.setStatus(1);
			else
				result.setStatus(0);
		} catch (Exception e) {
			logger.log(Level.SEVERE, null, e);
		}
		return result;
	}
	
	public Result getUserById(int id) {
		Result result = new Result();
		try {
			result.setData(userHibernet.getById(id));
			if(result.getData()!=null)
			result.setStatus(1);
			else
				result.setStatus(0);
		} catch (Exception e) {
			logger.log(Level.SEVERE, null, e);
		}
		return result;
	}

	public Result createUser(String email, String password) {
		Result result = new Result();
		try {
			User newUser=new User(email, password);
			result.setStatus(userHibernet.create(newUser));
		} catch (Exception e) {
			logger.log(Level.SEVERE, null, e);
		}
		return result;
	}

	public Result updateUser(String email, String password) {
		Result result = new Result();
		try {
			User user=new User(email, password);
			result.setStatus(userHibernet.update(user));
		} catch (Exception e) {
			logger.log(Level.SEVERE, null, e);
		}
		return result;
	}
	
	public Result deleteUser(String email) {
		Result result = new Result();
		try {

			result.setStatus(userHibernet.delete(email));
		} catch (Exception e) {
			logger.log(Level.SEVERE, null, e);
		}
		return result;
	}

	public Result deleteAllUsers() {
		Result result = new Result();
		try {
			result.setStatus(userHibernet.deleteAll());
		} catch (Exception e) {
			logger.log(Level.SEVERE, null, e);
		}
		return result;
	}


}
