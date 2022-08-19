package com.wdm.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@SequenceGenerator(name = "RESTAURANT_SEQ_GENERATOR",
sequenceName="RESTAURANT_SEQ",
initialValue = 1,
allocationSize = 1)
public class Restaurant {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
	generator = "RESTAURANT_SEQ_GENERATOR")
	private Long rseq;
	private String name;
	private char kind;
	private String menu;
	private String address_name;
	private String address_detail;
	private String dong;
	private String content;
	private int likescnt;
	
	@Temporal(TemporalType.DATE)
	private Date regdate = new Date();
	private String image1;
	private String image2;
	private String image3;
	private String id;
	
	
}

