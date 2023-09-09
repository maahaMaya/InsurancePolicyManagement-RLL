package com.gfive.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserQuestion {
	
	private Integer userquestion_id;

	private String userquestion_email;

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
