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
        </div>
        <div class="col-md-10 col-md-offset-1">

            <div class="btn-group">
                <button class="btn btn-default btn-primary btn-lg" data-toggle="modal" data-target="#changeBuilding">
                    <span class="glyphicon glyphicon-repeat"></span> Change Building</button>
            </div>
            <div class="btn-group">
                <button class="btn btn-default btn-primary btn-lg" data-toggle="modal" data-target="#editBuilding">
                    <span class="glyphicon glyphicon-pencil"></span>  Edit Cost</button>
            </div>
            <div class="btn-group">
                <button class="btn btn-default btn-primary btn-lg" data-toggle="modal" data-target="#moveUser">
                    <span class="glyphicon glyphicon-plus">
                    </span> Add User To Building</button>
            </div>
            <div class="btn-group">
                <button class="btn btn-default btn-primary btn-lg" data-toggle="modal" data-target="#createRoom">
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
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel">
                            Edit Building
                        </h4>
                    </div>
                    <div class="modal-body">

                        <div class="form-group">
                            <label for="newBuildingNameid">Building Name</label>
                            <input name="newBuildingName" type="text" class="form-control" id="newBuildingNameid" placeholder="Enter building name">
                        </div>

                        <div class="form-group">
                            <label for="newRenterInsuranceid">Renters Insurance</label>
                            <input name="newRenterInsurance" type="text" class="form-control" id="newRenterInsuranceid" placeholder="Enter Renters Insurance">
                        </div>

                        <div class="form-group">
                            <label for="newBuildingRentid">Building Rent</label>
                            <input name="newBuildingRent" type="text" class="form-control" id="newBuildingRentid" placeholder="Enter building rent">
                        </div>

                        <div class="form-group">
                            <label for="newBuildingFloorSpaceid">Building Floor Space (SqFt)</label>
                            <input name="newBuildingFloorSpace" type="text" class="form-control" id="newBuildingFloorSpaceid" placeholder="Enter building floor space in SqFt">
                        </div>

                        <b><p>Utilities:</p></b>
                        <div class="form-inline" >
                            <div class="form-group">
                                <input name="utilWater" type="text" class="form-control" id="utilWaterid" placeholder="Water">
                            </div>
                            <div class="form-group">
                                <input name="utilInter" type="text" class="form-control" id="utilInterid" placeholder="Internet">
                            </div>
                            <div class="form-group">
                                <input name="UtilTrash" type="text" class="form-control" id="UtilTrashid" placeholder="Trash">
                            </div>
                            <div class="form-group">
                                <input name="UtilElec" type="text" class="form-control" id="UtilElecid" placeholder="Electricity">
                            </div>
                            <div class="form-group">
                                <input name="UtilGas" type="text" class="form-control" id="UtilGasid" placeholder="Gas">
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">

                        <button type="submit" class="btn btn-primary" >Submit</button>
                    </div>
                </div>
            </div>
        </div>
        <!-- Modal to add a user to a building-->
        <div class="modal fade" id="moveUser" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel">
                            Move user into building
                        </h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label for="newUserid">User Name</label>
                            <input name="newUser" type="text" class="form-control" id="newUserid" placeholder="Enter user">
                        </div>
                    </div>
                    <div class="modal-footer">

                        <button type="submit" class="btn btn-primary" >Submit</button>
                    </div>
                </div>
            </div>
        </div>




        <div class="middle col-md-10 col-md-offset-1 ">
            <div class="col-md-6 mid-left " >
                <h3>Building Name:</h3>
                <h3>Renters  Insurance:</h3>
                <h3>Utilities:</h3>
                <h3>Base Rent:</h3>
                <h3>Floor Space (SqFt):</h3>

            </div>
            <div class="col-md-6 mid-right" >
                <h3>Internet:</h3>
                <h3>Water:</h3>
                <h3>Trash:</h3>
                <h3>Electric:</h3>
                <h3>Gas:</h3>

            </div>

        </div><!-- /container -->



        <!нн jQuery (necessary for Bootstrap's JavaScript plugins) нн>
        <script src="../js/jquery.js" ></script>
        <!нн Include all compiled plugins, or include individual files as needed нн>
        <script src="../js/bootstrap.js" ></script>

    </body>



</html>