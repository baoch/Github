<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vieth
  Date: 5/24/2017
  Time: 8:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pitch</title>
    <c:import url="header.jsp"/>
</head>
<body>
<c:import url="navbar.jsp"/>
<div class="container-fluid">
    <div class="row col-md-6 col-md-offset-3">
        <table class="table table-striped table-bordered" id="tblPitch">
            <thead>
                <tr>
                    <th>PitchID</th>
                    <th>Pitch Name</th>
                    <th>Pitch Width (m)</th>
                    <th>Pitch Length (m)</th>
                    <th>Pitch Status</th>
                </tr>
            </thead>
            <tbody></tbody>
            <tfoot>
                <tr>
                    <th>PitchID</th>
                    <th>Pitch Name</th>
                    <th>Pitch Width (m)</th>
                    <th>Pitch Length (m)</th>
                    <th>Pitch Status</th>
                </tr>
            </tfoot>
        </table>
        <script>
            $(document).ready(function() {
               $("#tblPitch").DataTable({
                    "ajax": {
                        "url": "${pageContext.request.contextPath}/get-list-pitch",
                        "type": "POST",
                        "dataSrc": ""
                    },
                   "columns":[
                       {"data": "pitchId", "visible": false},
                       {"data": "pitchName"},
                       {"data": "pitchWidth"},
                       {"data": "pitchLength"},
                       {
                           "data": "status",
                           "render": function(data, type, full, meta){
                                if(data){
                                    return "<p class='btn btn-success'>Available</p>";
                                } else {
                                    return "<p class='btn btn-danger'>Unavailable</p>";
                                }
                           }
                       }
                   ]
               });
            });
        </script>
    </div>
    <div class="row">
        <form id="form-add-pitch" class="form-horizontal col-md-4 col-md-offset-4">
            <div class="form-group">
                <label class="label-control">Pitch Name: </label>
                <input id="add-pitch-name" class="form-control" required/>
            </div>
            <div class="form-group">
                <label class="label-control">Pitch Width: </label>
                <input type="number" id="add-pitch-width" step=0.01 class="form-control" required/>
            </div>
            <div class="form-group">
                <label class="label-control">Pitch Length: </label>
                <input type="number" id="add-pitch-length" step=0.01 class="form-control" required/>
            </div>
            <div class="form-group">
                <label class="label-control">Available: </label>
                <input type="checkbox" id="add-pitch-status" class="form-group"/>
            </div>
            <div class="form-group">
                <label class="label-control">Maximum player</label>
                <select id="add-pitch-type" class="form-control">
                    <c:forEach var="pitchType" items="${listPitchType}">
                        <option value=${pitchType.pitchTypeId}>${pitchType.maxPlayers}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <button class="btn btn-primary">Submit</button>
            </div>
        </form>
        <script>
            $("#form-add-pitch").submit(function(event){
                var pitchName = $("#add-pitch-name").val();
                var pitchWidth = $("#add-pitch-width").val();
                var pitchLength = $("#add-pitch-length").val();
                var pitchStatus = $("#add-pitch-status").is(":checked")? true : false;
                var pitchTypeId = $("#add-pitch-type").val();
                var pitch = {"pitchName": pitchName, "pitchWidth": pitchWidth, "pitchLength": pitchLength, "status": pitchStatus, "pitchTypeId": pitchTypeId};
                event.preventDefault();
                $.ajax({
                    type: "POST",
                    url: "${pageContext.request.contextPath}/save-pitch",
                    contentType: "application/json",
                    data: JSON.stringify(pitch)
                });
                setTimeout(function(){
                    $('#tblPitch').DataTable().ajax.reload(null,false);// reload without come back to the first page
                }, 1000); //reload the table after 0.2s
            });
        </script>
    </div>
</div>
</body>
</html>
