package com.manuel.forum.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the comments database table.
 * 
 */
@Entity
@Table(name="comments")
@NamedQuery(name="Comment.findAll", query="SELECT c FROM Comment c")
public class Comment implements Serializable {
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

	@Lob
	private String text;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="id_author")
	private User user;

	//bi-directional many-to-one association to TopicsComment
	@OneToMany(mappedBy="comment")
	private List<TopicsComment> topicsComments;

	public Comment() {
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

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
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
		topicsComment.setComment(this);

		return topicsComment;
	}

	public TopicsComment removeTopicsComment(TopicsComment topicsComment) {
		getTopicsComments().remove(topicsComment);
		topicsComment.setComment(null);

		return topicsComment;
	}

}