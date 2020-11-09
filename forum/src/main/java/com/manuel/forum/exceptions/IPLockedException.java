package com.manuel.forum.exceptions;

import org.springframework.security.authentication.LockedException;

public class IPLockedException extends LockedException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IPLockedException(String message) {
		super(message);
	}
}
