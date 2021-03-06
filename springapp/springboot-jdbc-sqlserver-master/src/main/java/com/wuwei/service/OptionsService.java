package com.wuwei.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.wuwei.dao.OptionHibernet;
import com.wuwei.entity.Option;
import com.wuwei.entity.Result;


@Service
public class OptionsService {


	@Resource(name = "OptionHibernet")
	private OptionHibernet optionHibernate;
	private static final Logger logger = Logger.getLogger(OptionsService.class.getName());

	public Result updateOption(Object option) {
		Result result = new Result();
		try {
			result.setStatus(optionHibernate.update(option));
		} catch (Exception e) {
			logger.log(Level.SEVERE, null, e);
		}
		return result;
	}

	public Result createOption(String optionName) {
		Result result = new Result();
	Option option=new Option(optionName);
		try {
			result.setStatus(optionHibernate.create(option));
		} catch (Exception e) {
			logger.log(Level.SEVERE, null, e);
		}
		return result;
	}


	public Result getByName(String optionName) {
		Result result = new Result();
		try {
			result.setData(optionHibernate.getByName(optionName));
			if (result.getData() == null)
				result.setStatus(0);
			else
				result.setStatus(1);
		} catch (Exception e) {
			logger.log(Level.SEVERE, null, e);
		}
		return result;
	}

	public Result getById(int optionId) {
		Result result = new Result();
		try {
			result.setData(optionHibernate.getById(optionId));
			if (result.getData() == null)
				result.setStatus(0);
			else
				result.setStatus(1);
		} catch (Exception e) {
			logger.log(Level.SEVERE, null, e);
		}
		return result;
	}
	public Result getOptions() {
		Result result = new Result();
		try {
			result.setData(optionHibernate.getAll());
			if (result.getData() == null)
				result.setStatus(0);
			else
				result.setStatus(1);
		} catch (Exception e) {
			logger.log(Level.SEVERE, null, e);
		}
		return result;
	}

	public Result deleteOption(String option) {
		Result result = new Result();
		try {

			result.setStatus(optionHibernate.delete(option));
		} catch (Exception e) {
			logger.log(Level.SEVERE, null, e);
		}
		return result;
	}

	public Result createOptions(String[] optionsName) {
		// TODO Auto-generated method stub
		Result result = new Result();
		try {
//			result.setStatus(optionHibernate.create(option));
			result.setStatus(11);
		} catch (Exception e) {
			
			logger.log(Level.SEVERE, null, e);
		}
		return result;
	}

	public Result deleteAllOptions() {
		Result result = new Result();
		try {
			result.setStatus(optionHibernate.deleteAll());
		} catch (Exception e) {
			logger.log(Level.SEVERE, null, e);
		}
		return result;
	}


}
