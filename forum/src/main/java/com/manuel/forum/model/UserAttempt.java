package com.manuel.forum.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;

/**
 * The persistent class for the user_attempts database table.
 * 
 */
@Entity
@Table(name = "user_attempts")
@NamedQuery(name = "UserAttempt.findAll", query = "SELECT u FROM UserAttempt u")
public class UserAttempt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int attempts;

	@Column(name = "last_modified")
	private LocalDateTime lastModified;

	@Column(name = "time_block_in_minutes")
	private int timeBlockInMinutes;

	private String ip;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAttempts() {
		return this.attempts;
	}

	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}

	public LocalDateTime getLastModified() {
		return this.lastModified;
	}

	public void setLastModified(LocalDateTime lastModified) {
		this.lastModified = lastModified;
	}

	public String getIP() {
		return this.ip;
	}

	public void setIP(String ip) {
		this.ip = ip;
	}

	public int getTimeBlockInMinutes() {
		return this.timeBlockInMinutes;
	}

	public void setTimeBlockInMinutes(int timeBlockInMinutes) {
		this.timeBlockInMinutes = timeBlockInMinutes;
	}

	public UserAttempt() {
		this(0, LocalDateTime.now(), null);
	}

	public UserAttempt(String IP) {

		this(0, LocalDateTime.now(), IP);
	}

	public UserAttempt(int attempts, LocalDateTime lastModified, String ip) {
		this.attempts = attempts;
		this.lastModified = lastModified;
		this.ip = ip;
	}

	public String getTime() {

		return getLastModified().getHour() + ":" + getLastModified().getMinute();
	}

	public int getHour() {
		return getLastModified().getHour();
	}

	public int getMinutes() {
		return getLastModified().getMinute();
	}

	public int getMonth() {
		return getLastModified().getMonthValue();
	}

	public int getDay() {
		return getLastModified().getDayOfMonth();
	}

	public int getYear() {
		return getLastModified().getYear();
	}
	

}
