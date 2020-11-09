package com.manuel.forum.security;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

import com.manuel.forum.exceptions.IPLockedException;
import com.manuel.forum.model.ClientIP;
import com.manuel.forum.model.UserAttempt;
import com.manuel.forum.service.UserAttemptImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.security.core.userdetails.UserDetailsService;

@Component("LimitLoginAuthenticationConfig")
public class LimitLoginAuthenticationConfig extends DaoAuthenticationProvider {

	@Autowired
	private UserAttemptImpl userAttemptService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public LimitLoginAuthenticationConfig() {
	}

	@Autowired
	@Qualifier("UserDetailsImpl")
	@Override
	public void setUserDetailsService(UserDetailsService UserDetailsImpl) {
		super.setUserDetailsService(UserDetailsImpl);
		super.setPasswordEncoder(passwordEncoder);
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		HttpServletRequest httpRequest = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		UserAttempt userAttempts = null;
		Authentication auth = null;
		String IP = ClientIP.getClientIP(httpRequest);
		try {
			if (!userAttemptService.isNumberMaxAttempts(IP)) {
				userAttempts = userAttemptService.getUserAttempts(IP);
				if (userAttempts.getTimeBlockInMinutes() == 0) {
					auth = super.authenticate(authentication);
				}

			} else {
				throw new IPLockedException("Has superado el numero maximo de intentos");
			}
			return auth;

		} catch (BadCredentialsException badCredentials) {
			if (!userAttemptService.isNumberMaxAttempts(IP)) {
				userAttemptService.updateFailAttempts(IP);
			}
			

			throw badCredentials;

		} catch (IPLockedException ipBanned) {
			userAttempts = userAttemptService.getUserAttempts(IP);
			if (userAttempts.getTimeBlockInMinutes() == 0) {
				userAttempts.setTimeBlockInMinutes(ClientIP.getTimeBanInMinutes());
				try {
					userAttemptService.save(userAttempts);
				} catch (Exception sqlException) {
					// TODO Auto-generated catch block
					sqlException.printStackTrace();
				}
				
			}
			if(ClientIP.isNotBanned(userAttempts)) {
				try {
					userAttemptService.resetFailAttempts(IP);
				} catch (Exception sqlException) {
					// TODO Auto-generated catch block
					sqlException.printStackTrace();
				}
			}

			
			throw ipBanned;

		} catch (Exception exception) {
			throw exception;
		}
	}
}
