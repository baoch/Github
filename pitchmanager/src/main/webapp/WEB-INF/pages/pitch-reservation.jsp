<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vieth
  Date: 5/24/2017
  Time: 9:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pitch Reservation</title>
    <c:import url="header.jsp"/>
</head>
<body>
<c:import url="navbar.jsp"/>
<div class="container-fluid">
    <div class="row col-md-6 col-md-offset-3">
        <form id="form-reserve" class="form-horizontal">
            <div class="form-group">
                <label class="control-label">Reserve Date: </label>
                <input id="reserve-date" type="date" class="form-control" />
            </div>
            <div class="form-group">
                <label class="control-label">From Time: </label>
                <select id="reserve-from-time" class="form-control">
                    <c:forEach var="slot" items="${listSlot}">
                        <option value="${slot.slotId}">${slot.fromTime}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label class="control-label">To Time: </label>
                <select id="reserve-to-time" class="form-control">
                    <c:forEach var="slot" items="${listSlot}">
                        <option value=${slot.slotId}>${slot.toTime}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label class="control-label">Pitch's list: </label>
                <select id="reserve-pitch-id" class="form-control">
                    <c:forEach var="pitch" items="${listPitch}">
                        <option value=${pitch.pitchId}>${pitch.pitchName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label class="control-label">Customer Name: </label>
                <input id="reserve-customer-name" class="form-control"/>
            </div>
            <div class="form-group">
                <label class="control-label">Phone number: </label>
                <input type="tel" id="reserve-phone" class="form-control"/>
            </div>
            <div class="form-group">
                <button class="btn btn-primary">Submit</button>
            </div>
        </form>
        <p id="result-text"></p>
        <script>
            $("#form-reserve").submit(function(event){
                var reserveDate = $("#reserve-date").val();
                var fromSlot = $("#reserve-from-time").val();
                var toSlot = $("#reserve-to-time").val();
                var pitchId = $("#reserve-pitch-id").val();
                var customerName = $("#reserve-customer-name").val();
                var phone = $("#reserve-phone").val();

                event.preventDefault();

                $.ajax({
                    type: "POST",
                    url: "${pageContext.request.contextPath}/save-reservation",
                    data: {"date": reserveDate, "fromSlot": fromSlot, "toSlot": toSlot, "pitchId": pitchId, "customerName": customerName, "phone": phone},
                    success: function (result) {
                      $("#result-text").html(result);
                    },
                    error: function (result) {
                        $("#result-text").html(result);
                    }
                });
            });
        </script>
    </div>
</div>
</body>
</html>
