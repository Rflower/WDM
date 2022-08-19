package com.wdm.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@SequenceGenerator(name = "RESTAURANT_COMMENT_SEQ_GENERATOR",
sequenceName="RESTAURANT_COMMENT_SEQ",
initialValue = 1,
allocationSize = 1)
public class Restaurant_Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
	generator = "RESTAURANT_COMMENT_SEQ_GENERATOR")
	private Long rcseq;
	private Long rseq;
	private String content;
	private String id;
	private String nickname;
	@Temporal(TemporalType.DATE)
	private Date regdate = new Date();

}

