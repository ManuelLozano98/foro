package com.manuel.forum.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the categories database table.
 * 
 */
@Entity
@Table(name="categories")
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String description;

	private String name;

	@Column(name="num_message")
	private int numMessage;

	@Column(name="num_topic")
	private int numTopic;

	private int order;

	//bi-directional many-to-one association to Topic
	@OneToMany(mappedBy="category")
	private List<Topic> topics;

	public Category() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumMessage() {
		return this.numMessage;
	}

	public void setNumMessage(int numMessage) {
		this.numMessage = numMessage;
	}

	public int getNumTopic() {
		return this.numTopic;
	}

	public void setNumTopic(int numTopic) {
		this.numTopic = numTopic;
	}

	public int getOrder() {
		return this.order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public List<Topic> getTopics() {
		return this.topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

	public Topic addTopic(Topic topic) {
		getTopics().add(topic);
		topic.setCategory(this);

		return topic;
	}

	public Topic removeTopic(Topic topic) {
		getTopics().remove(topic);
		topic.setCategory(null);

		return topic;
	}

}