package com.manuel.forum.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the users_notifications database table.
 * 
 */
@Entity
@Table(name="users_notifications")
@NamedQuery(name="UsersNotification.findAll", query="SELECT u FROM UsersNotification u")
public class UsersNotification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name="date_readed")
	private Date dateReaded;

	private byte readed;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="id_user_emitter")
	private User userEmitter;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="id_user_receiver")
	private User userReceiver;

	public UsersNotification() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateReaded() {
		return this.dateReaded;
	}

	public void setDateReaded(Date dateReaded) {
		this.dateReaded = dateReaded;
	}

	public byte getReaded() {
		return this.readed;
	}

	public void setReaded(byte readed) {
		this.readed = readed;
	}

	public User getUserEmitter() {
		return this.userEmitter;
	}

	public void setUserEmitter(User userEmitter) {
		this.userEmitter = userEmitter;
	}

	public User getUserReceiver() {
		return this.userReceiver;
	}

	public void setUserReceiver(User userReceiver) {
		this.userReceiver = userReceiver;
	}

}