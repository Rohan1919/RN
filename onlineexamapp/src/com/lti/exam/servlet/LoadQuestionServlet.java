package com.lti.exam.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lti.exam.model.Option;
import com.lti.exam.model.Question;
import com.lti.exam.model.QuestionBankLoader;

/**
 * Servlet implementation class LoadQuestionServlet
 */
@WebServlet("/LoadQuestionServlet")
public class LoadQuestionServlet extends HttpServlet {
	   int qNo=0;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QuestionBankLoader qbLoader=new QuestionBankLoader();
		List<Question> questions=qbLoader.loadQuestionsOnJava();
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		qNo=qNo;
		
		if(qNo<questions.size()){
			Question q=questions.get(qNo++);
		
		
		session.setAttribute("currentQs", q);
		List<Option> op=q.getOptions();
		session.setAttribute("questionOption", op);
		session.setAttribute("ques", qNo);
		response.sendRedirect("showQuestion.jsp");
		}
		else{
			
			session.setAttribute("totalQuestion", questions.size());
			
			response.sendRedirect("ResultServlet.jsp");
			
			
		}

	}
	
	
}
