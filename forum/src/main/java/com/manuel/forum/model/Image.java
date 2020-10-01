package com.manuel.forum.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the images database table.
 * 
 */
@Entity
@Table(name="images")
@NamedQuery(name="Image.findAll", query="SELECT i FROM Image i")
public class Image implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Lob
	private String css;

	private int height;

	private String type;

	private String url;

	private int width;

	//bi-directional many-to-one association to ImagesComment
	@OneToMany(mappedBy="image")
	private List<ImagesComment> imagesComments;

	//bi-directional many-to-one association to ImagesTopic
	@OneToMany(mappedBy="image")
	private List<ImagesTopic> imagesTopics;

	public Image() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCss() {
		return this.css;
	}

	public void setCss(String css) {
		this.css = css;
	}

	public int getHeight() {
		return this.height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getWidth() {
		return this.width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public List<ImagesComment> getImagesComments() {
		return this.imagesComments;
	}

	public void setImagesComments(List<ImagesComment> imagesComments) {
		this.imagesComments = imagesComments;
	}

	public ImagesComment addImagesComment(ImagesComment imagesComment) {
		getImagesComments().add(imagesComment);
		imagesComment.setImage(this);

		return imagesComment;
	}

	public ImagesComment removeImagesComment(ImagesComment imagesComment) {
		getImagesComments().remove(imagesComment);
		imagesComment.setImage(null);

		return imagesComment;
	}

	public List<ImagesTopic> getImagesTopics() {
		return this.imagesTopics;
	}

	public void setImagesTopics(List<ImagesTopic> imagesTopics) {
		this.imagesTopics = imagesTopics;
	}

	public ImagesTopic addImagesTopic(ImagesTopic imagesTopic) {
		getImagesTopics().add(imagesTopic);
		imagesTopic.setImage(this);

		return imagesTopic;
	}

	public ImagesTopic removeImagesTopic(ImagesTopic imagesTopic) {
		getImagesTopics().remove(imagesTopic);
		imagesTopic.setImage(null);

		return imagesTopic;
	}

}