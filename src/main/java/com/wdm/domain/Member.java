package com.wdm.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
	private char socialyn;
	@Enumerated(EnumType.STRING)
	private Role role;
	
//	public String getId() {
//		return id;
//	}
//	public void setId(String id) {
//		this.id = id;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getNickname() {
//		return nickname;
//	}
//	public void setNickname(String nickname) {
//		this.nickname = nickname;
//	}
//	public String getPwd() {
//		return pwd;
//	}
//	public void setPwd(String pwd) {
//		this.pwd = pwd;
//	}
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	public char getGender() {
//		return gender;
//	}
//	public void setGender(char gender) {
//		this.gender = gender;
//	}
//	public String getAddress() {
//		return address;
//	}
//	public void setAddress(String address) {
//		this.address = address;
//	}
//	public String getAddress_detail() {
//		return address_detail;
//	}
//	public void setAddress_detail(String address_detail) {
//		this.address_detail = address_detail;
//	}
//	public String getPhone() {
//		return phone;
//	}
//	public void setPhone(String phone) {
//		this.phone = phone;
//	}
//	public char getSocialyn() {
//		return socialyn;
//	}
//	public void setSocialyn(char socialyn) {
//		this.socialyn = socialyn;
//	}
//	
//	
//	public Role getRole() {
//		return role;
//	}
//	public void setRole(Role role) {
//		this.role = role;
//	}
//	@Override
//	public String toString() {
//		return "Member [id=" + id + ", name=" + name + ", nickname=" + nickname + ", pwd=" + pwd + ", email=" + email
//				+ ", gender=" + gender + ", address_name=" + address + ", address_detail=" + address_detail
//				+ ", phone=" + phone + ", socialyn=" + socialyn + "]";
//	}

	
}
