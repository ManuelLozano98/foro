package com.manuel.forum.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the images_comments database table.
 * 
 */
@Entity
@Table(name="images_comments")
@NamedQuery(name="ImagesComment.findAll", query="SELECT i FROM ImagesComment i")
public class ImagesComment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	//bi-directional many-to-one association to TopicsComment
	@ManyToOne
	@JoinColumn(name="id_comment")
	private TopicsComment topicsComment;

	//bi-directional many-to-one association to Image
	@ManyToOne
	@JoinColumn(name="id_image")
	private Image image;

	public ImagesComment() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TopicsComment getTopicsComment() {
		return this.topicsComment;
	}

	public void setTopicsComment(TopicsComment topicsComment) {
		this.topicsComment = topicsComment;
	}

	public Image getImage() {
		return this.image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

}