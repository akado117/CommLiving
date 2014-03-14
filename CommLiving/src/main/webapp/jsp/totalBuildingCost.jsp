<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link  href="../css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link  href="../css/table.css" rel="stylesheet" media="screen">
        <link href="../css/extra.css" rel="stylesheet">

        <title>Login</title>
    </head>
    <body>


        <!-- nav bar -->
        <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>

                </div>
                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="displayUserHome">Home</a></li>
                        <li><a href="../j_spring_security_logout">Log Out</a></li>

                    </ul>

                </div>
            </div>
        </div>

        <!-- center holder-->
        <div class="mid-header ">
            <h1>Total Building Cost for ${buildingName} </h1>
            <h2>${message}</h2>
        </div>
        <div class="col-md-10 col-md-offset-1">

            <div class="btn-group">
                <button class="btn btn-default btn-primary btn-lg" data-toggle="modal" data-target="#changeBuilding">
                    <span class="glyphicon glyphicon-repeat"></span> Change Building</button>
            </div>
            <div class="btn-group">
                <button class="btn btn-default btn-primary btn-lg" data-toggle="modal" data-target="#editBuilding">
                    <span class="glyphicon glyphicon-pencil"></span>  Edit Building</button>
            </div>
            <div class="btn-group">
                <button class="btn btn-default btn-primary btn-lg" data-toggle="modal" data-target="#moveUser">
                    <span class="glyphicon glyphicon-plus">
                    </span> Add User To Room From This Building</button>
            </div>
            <div class="btn-group">
                <button class="btn btn-default btn-primary btn-lg" data-toggle="modal" data-target="#addRoom">
                    <span class="glyphicon glyphicon-plus">
                    </span> Add Room To Building</button>
            </div>

            <p> <P>
        </div>

        <!-- Modal to change building-->
        <div class="modal fade" id="changeBuilding" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel">
                            Change Building
                        </h4>
                    </div>
                    <div class="modal-body">
                        <form>
                            <div class="form-group">
                                <label for="newBuilding">Building</label>
                                <input name="building" class="form-control" id="newBuilding" placeholder="Enter building">
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">

                        <button type="submit" class="btn btn-primary" >Submit</button>
                    </div>
                </div>
            </div>
        </div>
        <!-- Modal to edit building costs-->
        <div class="modal fade" id="editBuilding" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form:form method="POST" action="editBuilding" commandName="building">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title" id="myModalLabel">
                                Add Building
                            </h4>
                        </div>
                        <div class="modal-body">

                            <div class="form-group">
                                <form:label path="buildingName">Building Name</form:label>
                                <form:input path="buildingName" type="text" class="form-control" id="newBuildingNameid" placeholder="Enter building name"/>
                            </div>

                            <div class="form-group">
                                <form:label path="renterInsurance">Renters Insurance</form:label>
                                <form:input path="renterInsurance" type="text" class="form-control" id="newRenterInsuranceid" placeholder="Enter Renters Insurance"/>
                            </div>

                            <div class="form-group">
                                <form:label path="totalBaseRent">Building Rent</form:label>
                                <form:input path="totalBaseRent" type="text" class="form-control" id="newBuildingRentid" placeholder="Enter building rent"/>
                            </div>

                            <div class="form-group">
                                <form:label path="totalSqFt">Building Floor Space (SqFt)</form:label>
                                <form:input path="totalSqFt" type="text" class="form-control" id="newBuildingFloorSpaceid" placeholder="Enter building floor space in SqFt"/>
                            </div>

                            <div class="modal-header">
                                <b><h4>Utilities:</h4></b>
                            </div>

                            <div class=" form-inline" >
                                <div class="form-group">
                                    <form:label path="water">Building Water Cost</form:label>
                                    <form:input path="water" type="text" class="form-control" id="utilWaterid" placeholder="Water"/>
                                </div>
                                <div class="form-group">
                                    <form:label path="internet">Building Internet Cost</form:label>
                                    <form:input path="internet" type="text" class="form-control" id="utilInterid" placeholder="Internet"/>
                                </div>
                                <div class="form-group">
                                    <form:label path="trash">Building Trash Cost</form:label>
                                    <form:input path="trash" type="text" class="form-control" id="UtilTrashid" placeholder="Trash"/>
                                </div>
                                <div class="form-group">
                                    <form:label path="electric">Building Electric Cost</form:label>
                                    <form:input path="electric" type="text" class="form-control" id="UtilElecid" placeholder="Electricity"/>
                                </div>
                                <div class="form-group">
                                    <form:label path="gas">Building Gas Cost</form:label>
                                    <form:input path="gas" type="text" class="form-control" id="UtilGasid" placeholder="Gas"/>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">

                            <button type="submit" class="btn btn-primary" >Submit</button>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
        <!-- Modal to move a user to a building-->
        <div class="modal fade" id="moveUser" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form method="POST" action="addUserToRoom">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title" id="myModalLabel">
                                Move user into building
                            </h4>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                                <label for="userToRoom">Username of user to place in room:</label>
                                <input name="userToRoom" type="text" class="form-control" id="userToRoom" placeholder="Enter user">
                            </div>
                            <div class="form-group">
                                <label for="moveToRoom" >What room should the user be put into? </label>
                                <select name="moveToRoom" id="moveToRoom">
                                    <c:forEach var="curRoom" items="${rooms}">
                                        <option value="${curRoom.roomId}">${curRoom.roomNumber}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="modal-footer">

                            <button type="submit" class="btn btn-primary" >Submit</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- Modal to add a room-->
        <div class="modal fade" id="addRoom" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="addRoom" method="POST">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title" id="myModalLabel">
                                Add a room to a building
                            </h4>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                                <label for="buildingNumber" >Building room is in: </label>
                                <select name="buildingNumber" id="buildingNumber">
                                    <c:forEach var="curBuilding" items="${buildings}">
                                        <option value="${curBuilding.buildingId}">${curBuilding.buildingName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="roomNumber">Suite Number: </label>
                                <input name="roomNumber" type="text" class="form-control" id="roomNumber" placeholder="Suite Number">
                            </div>
                            <div class="form-group">
                                <label for="roomSqFt">Room Size (in nearest SqFt): </label>
                                <input name="roomSqFt" type="text" class="form-control" id="roomSqFt" placeholder="Must be a whole Number">
                            </div>
                        </div>
                        <div class="modal-footer">

                            <button type="submit" class="btn btn-primary" >Submit</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>




        <div class="middle col-md-10 col-md-offset-1 ">
            <div class="col-md-6 mid-left " >
                <h3>Building Name: ${building.buildingName}</h3>
                <h3>Renters  Insurance: $${building.renterInsurance}</h3>
                <h3>Utilities: $${building.totalUtil}</h3>
                <h3>Base Rent: $${building.totalBaseRent}</h3>
                <h3>Floor Space: ${building.totalSqFt}SqFt</h3>

            </div>
            <div class="col-md-6 mid-right" >
                <h3>Internet: $${building.internet}</h3>
                <h3>Water: $${building.water}</h3>
                <h3>Trash: $${building.trash}</h3>
                <h3>Electric: $${building.electric}</h3>
                <h3>Gas: $${building.gas}</h3>

            </div>

        </div><!-- /container -->



        <!нн jQuery (necessary for Bootstrap's JavaScript plugins) нн>
        <script src="../js/jquery.js" ></script>
        <!нн Include all compiled plugins, or include individual files as needed нн>
        <script src="../js/bootstrap.js" ></script>

    </body>



</html>