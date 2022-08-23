package com.wdm.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class AuthEmail {

	@Id
	private String email;
	private String authKey;

}
