package com.wdm.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Likes {
	
	// pk값으로 쓸 번호
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
	generator = "LIKES_SEQ_GENERATOR")
	private Long lseq;
	
	// 회원 id
	private String id;
	
	// 식당 번호
	private Long rseq;
	
}

