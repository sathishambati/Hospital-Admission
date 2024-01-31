<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isErrorPage="true" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.sql.SQLException" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Error</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .error-container {
            text-align: center;
            margin-top: 50px;
        }
        .error-heading {
            font-size: 24px;
            color: #FF0000;
        }
        .error-message {
            font-size: 18px;
            color: #FF0000;
        }
    </style>
</head>
<body>
    <div class="error-container">
        <h1 class="error-heading">An error occurred</h1>
        
        <%-- Check if exception is not null before accessing its methods --%>
        <c:if test="${not empty exception}">
            <p class="error-message">${exception.getMessage()}</p>
            <p class="error-message">Exception type: ${exception.getClass().getName()}</p>
        </c:if>
        
    </div>
</body>
</html>
