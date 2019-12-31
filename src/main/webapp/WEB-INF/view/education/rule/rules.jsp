<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>"/>
    <title>Добавленные правила</title>
</head>
<body>
<div class="container-lg bg-light">
    <label class="row col-auto bg-light">
        <p class="h3">Список добавленных правил</p>
    </label>

    <table class="table table-borderless">
        <thead class="bg-light">
        <tr>
            <th class="bg-info text-white" scope="col">Название</th>
        </tr>
        </thead>
        <tbody>
          <c:forEach items="${rules}" var="rule">
              <tr>
                  <th scope="row">
                      <a class="btn btn-outline-primary"
                              <c:redirect url="/rules/${rule.id}"/>>${rule.name}</a>
                  </th>
              </tr>
          </c:forEach>
        </tbody>
    </table>
</div>

<script src="<c:url value="/js/bootstrap.min.js"/>"></script>
</body>
</html>
