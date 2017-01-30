package com.vrsoft.sms.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.codahale.metrics.annotation.Timed;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.vrsoft.sms.SmsTransactionConfiguration;
import com.vrsoft.sms.api.SmsStatus;

@Path("/sendSms")
public class Sms {

	private static Logger log = Logger.getLogger(Sms.class.getName());
	private final SmsTransactionConfiguration c_config;
	private final AtomicLong counter;

	public Sms(SmsTransactionConfiguration config) {
		this.c_config = config;
		this.counter = new AtomicLong();
	}

	@GET
	@Timed
	@Produces(MediaType.APPLICATION_JSON)
	public SmsStatus sendSms(@QueryParam("mobile") final String c_Mobile,
			@QueryParam("text") final String c_Message) {

		String message = "";
		String url = "";

		try {

			message = URLEncoder.encode(c_Message, "UTF-8");
			url = c_config.getApi_url().replace("number", c_Mobile).replace("text", message);

		} catch (UnsupportedEncodingException e) {
			log.error("Please check the Url", e);
		}

		return new SmsStatus(counter.incrementAndGet(),sendRequest(c_config.getApi_method(),url));
	}

	private String sendRequest(final String method, final String url) {
		String result = "";
		try {
			if (("GET").equals(method)) {
				result = Unirest.get(url).asString().toString();
			}

			else if (("POST").equals(method)) {
				result = Unirest.post(url).asString().toString();
			}

		} catch (UnirestException e) {
			log.error("Please check the Url", e);
		}

		return result;
	}
}
