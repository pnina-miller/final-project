package com.wuwei.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wuwei.dao.IHibernate;
import com.wuwei.dao.OptionHibernet;
import com.wuwei.dao.UserHibernet;
import com.wuwei.dao.ValueHibernet;
import com.wuwei.entity.Option;
import com.wuwei.entity.Result;
import com.wuwei.entity.User;
import com.wuwei.entity.Value;

@Service
public class ValueService {

	@Resource(name = "ValueHibernet")
	private ValueHibernet ValueHibernet;
	@Resource(name = "OptionHibernet")
	private OptionHibernet optionHibernet;
	
	@Resource(name = "UserHibernet")
	private UserHibernet userHibernet;
	private static final Logger logger = Logger.getLogger(ValueService.class.getName());

	public Result updateValues(Object value) {
		Result result = new Result();
		try {
			Value newValue=new Value("jjj",new Option("fff"),new User( "jj@h.com","hhh"));
			result.setStatus(ValueHibernet.update(newValue));
		} catch (Exception e) {
			logger.log(Level.SEVERE, null, e);
		}
		return result;
	}

	public Result createValue(LinkedHashMap value) throws Exception {
		System.out.println("on createValues service value:"+value);
		Result result = new Result();
		User user;
		Option option = null;
		try {
			user=(User) getFromValue(value,"user",userHibernet);
			option=(Option) getFromValue(value,"option",optionHibernet);
			Value newValue=new Value((String)value.get("valueName"),option, user);
		
			result.setStatus(ValueHibernet.create(newValue));
			
		} catch (Exception e) {
			logger.log(Level.SEVERE, null, e);
			result.setStatus(0);
		}
		return result;
	}

	public Result getValueByEmail(String name, String password) {
		Result result = new Result();
		System.out.println("values: " + name + " password: " + password);
		try {
			result.setData(ValueHibernet.getByName(name));
			if (result.getData() == null)
				result.setStatus(0);
			else
				result.setStatus(1);
			
		} catch (Exception e) {
			logger.log(Level.SEVERE, null, e);
		}
		return result;
	}

	public Result getValues() {
		Result result = new Result();
		try {
			List<Object> values = ValueHibernet.getAll();
			result.setStatus(1);
			result.setData(values);
		} catch (Exception e) {
			logger.log(Level.SEVERE, null, e);
		}
		return result;
	}

	public Result deleteValues(String email, String password) {
		Result result = new Result();
		try {

			result.setStatus(ValueHibernet.delete(email));
		} catch (Exception e) {
			logger.log(Level.SEVERE, null, e);
		}
		return result;
	}


	public Result getValuesByUser() {
		// TODO Auto-generated method stub
		return null;
	}

	public Result getAllValues() {
		Result result = new Result();
		try {
			result.setData(ValueHibernet.getAll());
			if(result.getData()!=null)
				result.setStatus(1);
			else
				result.setStatus(0);
		} catch (Exception e) {
			logger.log(Level.SEVERE, null, e);
		}
		return result;
	}
	
	private Object getFromValue(LinkedHashMap value, String key,IHibernate hibernate) throws Exception {

		Object object = null;
		if(value.get(key+"Name")!=null) {
			object=hibernate.getByName((String) value.get(key+"Name"));
		}else
			if(value.get(key+"Id")!=null)
				object=hibernate.getById((Integer) value.get(key+"Id"));
			else
				throw new Exception(key+" is required");
		return object;
			
	}

}
