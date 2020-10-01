package com.manuel.forum.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the survey_options database table.
 * 
 */
@Entity
@Table(name="survey_options")
@NamedQuery(name="SurveyOption.findAll", query="SELECT s FROM SurveyOption s")
public class SurveyOption implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String text;

	private int votes;

	//bi-directional many-to-one association to Poll
	@ManyToOne
	@JoinColumn(name="id_poll")
	private Poll poll;

	public SurveyOption() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getVotes() {
		return this.votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}

	public Poll getPoll() {
		return this.poll;
	}

	public void setPoll(Poll poll) {
		this.poll = poll;
	}

}