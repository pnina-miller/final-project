package com.wuwei.entity;


import javax.persistence.*;

@Entity(name = "Value")
@Table(name = "Value")
public class Value {
	
	 public Value(String valueName,Option option, User user) {
		super();
		this.valueName=valueName;
		this.optionId=option;
		this.userId=user;
	}
	 public Value() {
		}

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "ValueId")
	private int valueId;
	
	@Column(unique = true, name = "ValueName")
	private String valueName;
	
	 @ManyToOne(fetch = FetchType.LAZY)
	    private Option optionId;
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	    private User userId;
}


