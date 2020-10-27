package com.manuel.forum.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Oauth2Config {

	private static String clientID;

	private static String clientSecret;

	protected static String getClientID() {
		return clientID;
	}

	protected static String getClientSecret() {
		return clientSecret;
	}

	@Value("${spring.security.oauth2.client.clientId}")
	private void setClientID(String client) {
		clientID = client;
	}

	@Value("${spring.security.oauth2.client.clientSecret}")
	private void setClientSecret(String secret) {
		clientSecret = secret;
	}

}
