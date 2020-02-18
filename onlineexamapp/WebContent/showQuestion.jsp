<%@page import="com.lti.exam.model.Option"%>
<%@page import="java.util.List"%>
<%@page import="com.lti.exam.model.Question"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="CalculateScoreServlet">
<%
	Question q=(Question) session.getAttribute("currentQs");
    int opNo=0;
    int a=(int)session.getAttribute("ques");

%>
<h3>Q.<%=a %> <%=q.getQuestion() %></h3>
<% List<Option> ops=q.getOptions();
	for(Option op:ops){
		

%>
<h3><input type="radio" name="op" value="<%=opNo++%>"> <%=op.getOption() %></h3>
<% 
		}
	%>
	<%
	Integer question=(Integer)session.getAttribute("totalQuestion");
	Integer currentQna=(Integer)session.getAttribute("ques");
	String btnlabel="Continue";
	if(question == currentQna){
		btnlabel="Finish";
		}
	%>
	<!-- <a href="LoadQuestionServlet">Continue</a> -->
	<button type="submit" ><%=btnlabel %></button>
	</form>
</body>
</html>