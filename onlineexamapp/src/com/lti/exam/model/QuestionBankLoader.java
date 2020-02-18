package com.lti.exam.model;

import java.util.ArrayList;
import java.util.List;

public class QuestionBankLoader {

	public List<Question> loadQuestionsOnJava(){
		QuestionBank qb = new QuestionBank();
		qb.addSubject("Java");
		
		Question q = new Question("What is Java");
		List<Option> options = new ArrayList<Option>();
		options.add(new Option("Java is an OS",false));
		options.add(new Option("Java is a Database",false));
		options.add(new Option("Java is a Programming Lang",true));
		options.add(new Option("Java is a Browser",false));
		q.setOptions(options);
		qb.addQuestion("Java", q);
		
		 q = new Question("What is Object");
		 options = new ArrayList<Option>();
		options.add(new Option("Object is an entity of OS",false));
		options.add(new Option("Object is an entity of Database",false));
		options.add(new Option("Object is an entity of class",true));
		options.add(new Option("Object is an entity of Browser",false));
		q.setOptions(options);
		qb.addQuestion("Java", q);
		
		q = new Question("What is name of constructor");
		 options = new ArrayList<Option>();
		options.add(new Option("Constructor is name of OS",false));
		options.add(new Option("Constructor is name of Database",false));
		options.add(new Option("Constructor is name of class",true));
		options.add(new Option("Constructor is name of Browser",false));
		q.setOptions(options);
		qb.addQuestion("Java", q);
		
		 q = new Question("What is type of Exception");
		 options = new ArrayList<Option>();
		options.add(new Option("Multithreading",false));
		options.add(new Option("Serialization with JDBC",false));
		options.add(new Option("Runtime Exception",true));
		//options.add(new Option("",false));
		q.setOptions(options);
		qb.addQuestion("Java", q);
		
		
		return qb.getQuestion("Java");
		
	}
}
