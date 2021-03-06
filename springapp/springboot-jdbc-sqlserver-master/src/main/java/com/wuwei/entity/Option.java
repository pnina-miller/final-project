package com.wuwei.entity;

import javax.persistence.*;


@Entity(name = "Option")
@Table(name = "Options")
public class Option {

	 public Option(String optionName) {
		super();
		this.optionName=optionName;
	}
	 public Option() {
			super();
		}

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "OptionId")
	private int optionId;
	
	@Column(unique = true, name = "OptionName")
	private String optionName;
	
	  
	public int getOptionId() {
		return optionId;
	}

	public String getOptionName() {
		return optionName;
	}

	public void setOptionName(String option) {
		this.optionName = option;
	}
}


	