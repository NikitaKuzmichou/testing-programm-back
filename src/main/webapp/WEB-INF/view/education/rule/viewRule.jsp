<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>"/>
    <title>${rule.name}</title>
</head>
<body>
<div class="container">
    <div class="card bg-light" style="width: available">
        <div class="card-body">
            <h4 class="card-header text-white bg-primary">${rule.name}</h4>
            <p class="card-text">${rule.description}</p>
            <p class="card-footer text-white bg-info">${rule.note}</p>
        </div>
    </div>
</div>

<script src="<c:url value="/js/bootstrap.min.js"/>"></script>
</body>
</html>
