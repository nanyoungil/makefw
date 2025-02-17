<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.util.Random"%>

<!DOCTYPE html>
<html>
<body>
	<!-- java 에서의 util 을 마찬가지로 import 할 수 있다. -->
    <% 
        Random ran = new Random();
        int num = ran.nextInt(45)+1;
        out.print("<h1램덤>: "+ num + "</h1>");
    %> 
	<h2>Hello World!</h2>

</body>
</html>
