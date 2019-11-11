<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
<%  
String firstNumber=request.getParameter("uname");  
String secondNumber=request.getParameter("pass"); 
int sum = Integer.parseInt(firstNumber) + Integer.parseInt(secondNumber);
if(sum%2 != 0)
{
	out.println("The sum is an odd number");
}
else
{
	out.println("The sum is an even number");
}


%> 

 
</body>
</html>