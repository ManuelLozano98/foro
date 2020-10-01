package com.manuel.forum.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the topics database table.
 * 
 */
@Entity
@Table(name="topics")
@NamedQuery(name="Topic.findAll", query="SELECT t FROM Topic t")
public class Topic implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name="creation_date")
	private Date creationDate;

	@Lob
	@Column(name="formatted_text")
	private String formattedText;

	@Column(name="num_message")
	private int numMessage;

	@Lob
	private String text;

	private String title;

	private int visit;

	//bi-directional many-to-one association to ImagesTopic
	@OneToMany(mappedBy="topic")
	private List<ImagesTopic> imagesTopics;

	//bi-directional many-to-one association to Poll
	@OneToMany(mappedBy="topic")
	private List<Poll> polls;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="id_category")
	private Category category;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="id_author")
	private User user;

	//bi-directional many-to-one association to TopicsComment
	@OneToMany(mappedBy="topic")
	private List<TopicsComment> topicsComments;

	public Topic() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getFormattedText() {
		return this.formattedText;
	}

	public void setFormattedText(String formattedText) {
		this.formattedText = formattedText;
	}

	public int getNumMessage() {
		return this.numMessage;
	}

	public void setNumMessage(int numMessage) {
		this.numMessage = numMessage;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getVisit() {
		return this.visit;
	}

	public void setVisit(int visit) {
		this.visit = visit;
	}

	public List<ImagesTopic> getImagesTopics() {
		return this.imagesTopics;
	}

	public void setImagesTopics(List<ImagesTopic> imagesTopics) {
		this.imagesTopics = imagesTopics;
	}

	public ImagesTopic addImagesTopic(ImagesTopic imagesTopic) {
		getImagesTopics().add(imagesTopic);
		imagesTopic.setTopic(this);

		return imagesTopic;
	}

	public ImagesTopic removeImagesTopic(ImagesTopic imagesTopic) {
		getImagesTopics().remove(imagesTopic);
		imagesTopic.setTopic(null);

		return imagesTopic;
	}

	public List<Poll> getPolls() {
		return this.polls;
	}

	public void setPolls(List<Poll> polls) {
		this.polls = polls;
	}

	public Poll addPoll(Poll poll) {
		getPolls().add(poll);
		poll.setTopic(this);

		return poll;
	}

	public Poll removePoll(Poll poll) {
		getPolls().remove(poll);
		poll.setTopic(null);

		return poll;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<TopicsComment> getTopicsComments() {
		return this.topicsComments;
	}

	public void setTopicsComments(List<TopicsComment> topicsComments) {
		this.topicsComments = topicsComments;
	}

	public TopicsComment addTopicsComment(TopicsComment topicsComment) {
		getTopicsComments().add(topicsComment);
		topicsComment.setTopic(this);

		return topicsComment;
	}

	public TopicsComment removeTopicsComment(TopicsComment topicsComment) {
		getTopicsComments().remove(topicsComment);
		topicsComment.setTopic(null);

		return topicsComment;
	}

}