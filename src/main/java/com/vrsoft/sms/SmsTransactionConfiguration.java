package com.vrsoft.sms;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.*;

public class SmsTransactionConfiguration extends Configuration {
	@NotEmpty
	private String api_url;
	
	@NotEmpty
	private String api_method;
	
	@NotEmpty
	private String api_key;
	
	@NotEmpty
	private String api_test;
	
	@JsonProperty
	public String getApi_url() {
		return api_url;
	}

	@JsonProperty
	public void setApi_url(String api_url) {
		this.api_url = api_url;
	}

	@JsonProperty
	public String getApi_method() {
		return api_method;
	}

	@JsonProperty
	public void setApi_method(String api_method) {
		this.api_method = api_method;
	}

	@JsonProperty
	public String getApi_key() {
		return api_key;
	}

	@JsonProperty
	public void setApi_key(String api_key) {
		this.api_key = api_key;
	}

	@JsonProperty
	public String getApi_test() {
		return api_test;
	}

	@JsonProperty
	public void setApi_test(String api_test) {
		this.api_test = api_test;
	}
	
	
}
