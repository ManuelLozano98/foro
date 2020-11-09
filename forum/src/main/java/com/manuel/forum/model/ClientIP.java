package com.manuel.forum.model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import javax.servlet.http.HttpServletRequest;
import com.manuel.forum.model.UserAttempt;

public class ClientIP {

	private final static int TIME_BAN_IN_MINUTES = 60;

	private final static int TIME_BAN_IN_HOURS = 1;

	public static String getClientIP(HttpServletRequest request) {

		String remoteAddr = "";

		if (request != null) {
			remoteAddr = request.getHeader("X-FORWARDED-FOR");
			if (remoteAddr == null || "".equals(remoteAddr)) {
				remoteAddr = request.getRemoteAddr();
			}
		}

		return remoteAddr;
	}

	public static boolean isNotBanned(UserAttempt userIP) {
		boolean isExpired = false;
		UserAttempt ipBanned = userIP;
		LocalDateTime timeIpBanned = LocalDateTime.of(ipBanned.getYear(),
				ipBanned.getMonth(), ipBanned.getDay(),
				ipBanned.getHour(), ipBanned.getMinutes());


		if (TIME_BAN_IN_MINUTES <= ChronoUnit.MINUTES.between(timeIpBanned,LocalDateTime.now())) {
			isExpired = true;

		}

		return isExpired;
	}

	public static int getTimeBanInMinutes() {
		return TIME_BAN_IN_MINUTES;
	}

	public static int getTimeBanInHours() {
		return TIME_BAN_IN_HOURS;
	}

}
