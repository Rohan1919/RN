package com.lti.exam.model;

import java.util.List;

public class Question {
	
	private String question;
	private List<Option> options;
	public Question(String question) {
			this.question=question;
 
	}
	public Question(String question, List<Option> options) {
		
		this.question = question;
		
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public List<Option> getOptions() {
		return options;
	}
	public void setOptions(List<Option> options) {
		this.options = options;
	}
	
}
