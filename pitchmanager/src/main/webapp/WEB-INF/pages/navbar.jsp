<%--
  Created by IntelliJ IDEA.
  User: vieth
  Date: 5/24/2017
  Time: 8:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/">PMS</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="${pageContext.request.contextPath}/">Home</a></li>
            <li><a href="${pageContext.request.contextPath}/pitch">Pitch Manager</a></li>
            <li><a href="${pageContext.request.contextPath}/pitch-reserve">Pitch Reservation</a></li>
        </ul>
    </div>
</nav>
