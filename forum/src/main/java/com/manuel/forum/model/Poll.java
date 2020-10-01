package com.manuel.forum.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the polls database table.
 * 
 */
@Entity
@Table(name="polls")
@NamedQuery(name="Poll.findAll", query="SELECT p FROM Poll p")
public class Poll implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private int options;

	private String title;

	private int votes;

	//bi-directional many-to-one association to Topic
	@ManyToOne
	@JoinColumn(name="id_topic")
	private Topic topic;

	//bi-directional many-to-one association to SurveyOption
	@OneToMany(mappedBy="poll")
	private List<SurveyOption> surveyOptions;

	public Poll() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOptions() {
		return this.options;
	}

	public void setOptions(int options) {
		this.options = options;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getVotes() {
		return this.votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}

	public Topic getTopic() {
		return this.topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public List<SurveyOption> getSurveyOptions() {
		return this.surveyOptions;
	}

	public void setSurveyOptions(List<SurveyOption> surveyOptions) {
		this.surveyOptions = surveyOptions;
	}

	public SurveyOption addSurveyOption(SurveyOption surveyOption) {
		getSurveyOptions().add(surveyOption);
		surveyOption.setPoll(this);

		return surveyOption;
	}

	public SurveyOption removeSurveyOption(SurveyOption surveyOption) {
		getSurveyOptions().remove(surveyOption);
		surveyOption.setPoll(null);

		return surveyOption;
	}

}