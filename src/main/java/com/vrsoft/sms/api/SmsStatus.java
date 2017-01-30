package com.vrsoft.sms.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SmsStatus {
	private long id;
	private String status;
	
	public SmsStatus(long id, String status) {
		super();
		this.id = id;
		this.status = status;
	}
	
    @JsonProperty
    public long getId() {
        return id;
    }
    
    @JsonProperty
    public String getStatus() {
        return status;
    }

}
