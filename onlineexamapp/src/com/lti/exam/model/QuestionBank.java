package com.lti.exam.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionBank {
	 
	private Map<String,List<Question>> questionBank;
	/*
	 * private List<Question> questionOnjava;
	 * private List<Question> questionOnDotNet;
	 * ..........
	 * */
	public QuestionBank() {
		questionBank=new HashMap<>();
	}
	public void addSubject(String subjectName){
		questionBank.put(subjectName,new ArrayList<>());
	}
	public void addSubject(String subjectName,List<Question> questions){
		questionBank.put(subjectName,questions);
	}
	
	
	public void addQuestion(String subjectName,Question question){
		List<Question> questions=questionBank.get(subjectName);
		questions.add(question);
	}
	public List<Question> getQuestion(String subjectName){
		return questionBank.get(subjectName);
	}

}
