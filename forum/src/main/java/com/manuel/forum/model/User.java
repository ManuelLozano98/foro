package com.manuel.forum.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Lob
	private byte[] avatar;

	@Lob
	private String description;

	private String email;

	@Column(name="num_comments")
	private int numComments;

	@Column(name="num_topics")
	private int numTopics;

	private String password;

	@Temporal(TemporalType.DATE)
	@Column(name="registration_date")
	private Date registrationDate;

	private String status;

	private String username;

	//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="user")
	private List<Comment> comments;

	//bi-directional many-to-one association to Topic
	@OneToMany(mappedBy="user")
	private List<Topic> topics;

	//bi-directional many-to-one association to UsersNotification
	@OneToMany(mappedBy="userEmitter")
	private List<UsersNotification> usersNotificationsEmitter;

	//bi-directional many-to-one association to UsersNotification
	@OneToMany(mappedBy="userReceiver")
	private List<UsersNotification> usersNotificationsReceiver;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte[] getAvatar() {
		return this.avatar;
	}

	public void setAvatar(byte[] avatar) {
		this.avatar = avatar;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getNumComments() {
		return this.numComments;
	}

	public void setNumComments(int numComments) {
		this.numComments = numComments;
	}

	public int getNumTopics() {
		return this.numTopics;
	}

	public void setNumTopics(int numTopics) {
		this.numTopics = numTopics;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getRegistrationDate() {
		return this.registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Comment> getComments() {
		return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Comment addComment(Comment comment) {
		getComments().add(comment);
		comment.setUser(this);

		return comment;
	}

	public Comment removeComment(Comment comment) {
		getComments().remove(comment);
		comment.setUser(null);

		return comment;
	}

	public List<Topic> getTopics() {
		return this.topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

	public Topic addTopic(Topic topic) {
		getTopics().add(topic);
		topic.setUser(this);

		return topic;
	}

	public Topic removeTopic(Topic topic) {
		getTopics().remove(topic);
		topic.setUser(null);

		return topic;
	}

	public List<UsersNotification> getUsersNotificationsEmitter() {
		return this.usersNotificationsEmitter;
	}

	public void setUsersNotificationsEmitter(List<UsersNotification> usersNotificationsEmitter) {
		this.usersNotificationsEmitter = usersNotificationsEmitter;
	}

	public UsersNotification addUsersNotificationsEmitter(UsersNotification usersNotificationsEmitter) {
		getUsersNotificationsEmitter().add(usersNotificationsEmitter);
		usersNotificationsEmitter.setUserEmitter(this);

		return usersNotificationsEmitter;
	}

	public UsersNotification removeUsersNotificationsEmitter(UsersNotification usersNotificationsEmitter) {
		getUsersNotificationsEmitter().remove(usersNotificationsEmitter);
		usersNotificationsEmitter.setUserEmitter(null);

		return usersNotificationsEmitter;
	}

	public List<UsersNotification> getUsersNotificationsReceiver() {
		return this.usersNotificationsReceiver;
	}

	public void setUsersNotificationsReceiver(List<UsersNotification> usersNotificationsReceiver) {
		this.usersNotificationsReceiver = usersNotificationsReceiver;
	}

	public UsersNotification addUsersNotificationsReceiver(UsersNotification usersNotificationsReceiver) {
		getUsersNotificationsReceiver().add(usersNotificationsReceiver);
		usersNotificationsReceiver.setUserReceiver(this);

		return usersNotificationsReceiver;
	}

	public UsersNotification removeUsersNotificationsReceiver(UsersNotification usersNotificationsReceiver) {
		getUsersNotificationsReceiver().remove(usersNotificationsReceiver);
		usersNotificationsReceiver.setUserReceiver(null);

		return usersNotificationsReceiver;
	}

}