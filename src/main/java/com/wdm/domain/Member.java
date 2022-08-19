package com.wdm.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Member {

	@Id
	private String id;
	private String name;
	private String nickname;
	private String pwd;
	private String email;
	private char gender;
	private String address;
	private String address_detail;
	private String phone;
	@Enumerated(EnumType.STRING)
	private Role role;


	
}
