package com.wuwei.dao;

import java.util.List;

import com.wuwei.entity.Option;

public interface IOptionHibernate {

	int updateOption(Option option);

	int createOption(Option option);

	List<Option> getAllOptions();

	List<Option> getOption(String option);

	int deleteOption(String option);

}