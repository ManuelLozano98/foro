package com.manuel.forum.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the topics_comments database table.
 * 
 */
@Entity
@Table(name="topics_comments")
@NamedQuery(name="TopicsComment.findAll", query="SELECT t FROM TopicsComment t")
public class TopicsComment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	//bi-directional many-to-one association to ImagesComment
	@OneToMany(mappedBy="topicsComment")
	private List<ImagesComment> imagesComments;

	//bi-directional many-to-one association to Comment
	@ManyToOne
	@JoinColumn(name="id_comment")
	private Comment comment;

	//bi-directional many-to-one association to Topic
	@ManyToOne
	@JoinColumn(name="id_topic")
	private Topic topic;

	public TopicsComment() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<ImagesComment> getImagesComments() {
		return this.imagesComments;
	}

	public void setImagesComments(List<ImagesComment> imagesComments) {
		this.imagesComments = imagesComments;
	}

	public ImagesComment addImagesComment(ImagesComment imagesComment) {
		getImagesComments().add(imagesComment);
		imagesComment.setTopicsComment(this);

		return imagesComment;
	}

	public ImagesComment removeImagesComment(ImagesComment imagesComment) {
		getImagesComments().remove(imagesComment);
		imagesComment.setTopicsComment(null);

		return imagesComment;
	}

	public Comment getComment() {
		return this.comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public Topic getTopic() {
		return this.topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

}