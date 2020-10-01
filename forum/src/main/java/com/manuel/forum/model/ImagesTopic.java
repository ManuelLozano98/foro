package com.manuel.forum.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the images_topics database table.
 * 
 */
@Entity
@Table(name="images_topics")
@NamedQuery(name="ImagesTopic.findAll", query="SELECT i FROM ImagesTopic i")
public class ImagesTopic implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	//bi-directional many-to-one association to Image
	@ManyToOne
	@JoinColumn(name="id_image")
	private Image image;

	//bi-directional many-to-one association to Topic
	@ManyToOne
	@JoinColumn(name="id_topic")
	private Topic topic;

	public ImagesTopic() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Image getImage() {
		return this.image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public Topic getTopic() {
		return this.topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

}