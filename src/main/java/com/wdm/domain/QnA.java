package com.wdm.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicInsert;

import lombok.Data;

@Data
@Entity
@SequenceGenerator(name = "QNA_SEQ_GENERATOR",
sequenceName="QNA_SEQ",
initialValue = 1,
allocationSize = 1)
@DynamicInsert
public class QnA {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
	generator = "QNA_SEQ_GENERATOR")
	private Long qseq;
	private String id;
	private String nickname;
	private String content;
	private String refid;
	@Column(columnDefinition="CHAR(1) DEFAULT 'N'")
	private String replyyn;
	private int qdepth;
	private Long qgrp;
	@Temporal(TemporalType.DATE)
	private Date regdate = new Date();

	
}
