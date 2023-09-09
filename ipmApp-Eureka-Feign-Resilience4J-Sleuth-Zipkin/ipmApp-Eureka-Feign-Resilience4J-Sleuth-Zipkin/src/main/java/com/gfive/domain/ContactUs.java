package com.gfive.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactUs {
	private Integer contactus_id;

	private String contactus_name;

	private String contactus_email;

	private String contactus_message;

	public ContactUs() {

	}

	public ContactUs(Integer contactus_id, String contactus_name, String contactus_email, String contactus_message) {
		this.contactus_id = contactus_id;
		this.contactus_name = contactus_name;
		this.contactus_email = contactus_email;
		this.contactus_message = contactus_message;
	}

	public Integer getContactus_id() {
		return contactus_id;
	}

	public void setContactus_id(Integer contactus_id) {
		this.contactus_id = contactus_id;
	}

	public String getContactus_name() {
		return contactus_name;
	}

	public void setContactus_name(String contactus_name) {
		this.contactus_name = contactus_name;
	}

	public String getContactus_email() {
		return contactus_email;
	}

	public void setContactus_email(String contactus_email) {
		this.contactus_email = contactus_email;
	}

	public String getContactus_message() {
		return contactus_message;
	}

	public void setContactus_message(String contactus_message) {
		this.contactus_message = contactus_message;
	}

}
