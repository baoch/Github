<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vieth
  Date: 5/26/2017
  Time: 10:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bill Details</title>
    <c:import url="header.jsp"/>
</head>
<body>
<c:import url="navbar.jsp"/>
<form id="form-update-price" class="form-horizontal col-md-6 col-md-offset-3">
    <div class="form-group">
        <label class="control-label">Bill Id</label>
        <input class="form-control" id="txtBillId" value = '${bill.billId}' readonly />
    </div>
    <div class="form-group">
        <label class="control-label">From-time</label>
        <input class="form-control" value = '${listSlot.get(0).fromTime}' readonly />
    </div>
    <div class="form-group">
        <label class="control-label">To-time</label>
        <input class="form-control" value = '${listSlot.get(1).toTime}' readonly />
    </div>
    <div class="form-group">
        <label class="control-label">Date</label>
        <input class="form-control" value = '${date}' readonly />
    </div>
    <div class="form-group">
        <label class="control-label">Price: </label>
        <input class="form-control" id="txtBillPrice" type="number" step="0.5"/>
    </div>
    <div class="form-group">
        <button class="btn btn-primary">Submit</button>
    </div>
</form>
<script>
    $("#form-update-price").submit(function(event){
        var billId = $("#txtBillId").val();
        var billPrice = $("#txtBillPrice").val();
        var bill = {"billId": billId,"totalPrice": billPrice};
        event.preventDefault();

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "${pageContext.request.contextPath}/update-reservation-price",
            data: JSON.stringify(bill),
        })
    });
</script>
</body>
</html>
