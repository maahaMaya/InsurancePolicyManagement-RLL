package com.gfive.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "userquestion_details")
public class UserQuestion {
	@Id
	@Column(name = "userquestion_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userquestion_id;

	@Column(name = "userquestion_email")
	private String userquestion_email;

	@Column(name = "userquestion_message")
	private String userquestion_message;

	public UserQuestion() {

	}

	public UserQuestion(Integer userquestion_id, String userquestion_email, String userquestion_message) {
		this.userquestion_id = userquestion_id;
		this.userquestion_email = userquestion_email;
		this.userquestion_message = userquestion_message;
	}

	public Integer getUserquestion_id() {
		return userquestion_id;
	}

	public void setUserquestion_id(Integer userquestion_id) {
		this.userquestion_id = userquestion_id;
	}

	public String getUserquestion_email() {
		return userquestion_email;
	}

	public void setUserquestion_email(String userquestion_email) {
		this.userquestion_email = userquestion_email;
	}

	public String getUserquestion_message() {
		return userquestion_message;
	}

	public void setUserquestion_message(String userquestion_message) {
		this.userquestion_message = userquestion_message;
	}

}
