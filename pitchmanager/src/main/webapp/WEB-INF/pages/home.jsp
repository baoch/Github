<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vieth
  Date: 5/16/2017
  Time: 7:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <c:import url="header.jsp"/>
    <title>PitchManager</title>
</head>
<body>
<c:import url="navbar.jsp"/>
<div class="container-fluid">
    <div class="row col-md-6 col-md-offset-3 text-center">
        <h1>Reference Prices</h1>
    </div>
    <div class="row col-md-6 col-md-offset-3">
        <table id="referencePrice" class="table table-striped table-bordered">
            <thead>
                <tr>
                    <th>Pitch Type</th>
                    <th>From Time</th>
                    <th>To Time</th>
                    <th>Reference Price</th>
                </tr>
            </thead>
            <tbody></tbody>
            <tfoot>
                <tr>
                    <th>Pitch Type</th>
                    <th>From Time</th>
                    <th>To Time</th>
                    <th>Reference Price</th>
                </tr>
            </tfoot>
        </table>
        <script>
            $(document).ready(function() {
                $('#referencePrice').DataTable({
                    "ajax": {
                        "type": "POST",
                        "url": "${pageContext.request.contextPath}/get-reference-price",
                        "dataSrc": ""
                    },
                    "columns": [
                        {"data": "pitchTypeName"},
                        {"data": "fromTime"},
                        {"data": "toTime"},
                        {
                            "data": "referencePrice",
                            "render": function(data, type, full, meta){
                                return data + " <span class='pull-right'>VNĐ/h</span>";
                            }
                        }
                    ]
                });
            } );
        </script>
    </div>

</div>
</body>
</html>
