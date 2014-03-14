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

        <title><sec:authentication property="principal.username" /> Home</title>
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
                        <li><a href="#">Individual Costs</a></li>
                        <li><a href="#">House Hold Costs</a></li>
                        <li><a href="../j_spring_security_logout">Log Out</a></li>

                    </ul>

                </div>
            </div>
        </div>

        <!-- center holder-->
        <div class="mid-header ">
            <h1>Welcome <sec:authentication property="principal.username" /></h1>
            <h2>${addBuildingMessage}</h2>
        </div>
        <div class="col-md-10 col-md-offset-1">

            <div class="btn-group">
                <button class="btn btn-default btn-primary btn-lg">
                    <span class="glyphicon glyphicon-arrow-right"></span>See personal breakdown</button>
            </div>
            <div class="btn-group">
                <button class="btn btn-default btn-primary btn-lg">
                    <span class="glyphicon glyphicon-arrow-right"></span>See household breakdown</button>
            </div>
            <div class="btn-group">
                <button class="btn btn-default btn-primary btn-lg" data-toggle="modal" data-target="#newBuilding">
                    <span class="glyphicon glyphicon-pencil">
                    </span> Add building/Show building breakdown</button>
            </div>
            <!-- Modal for select building -->
            <div class="modal fade" id="newBuilding" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form method="POST" action="BuildingPage" >
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h4 class="modal-title" id="myModalLabel">
                                    Select a building to go to
                                </h4>

                            </div>
                            <div class="modal-body">

                                <div class="form-group">
                                    <form:label for="buildingName" path="buildingName">Building</form:label>

                                    <form:select name="buildingName" path="buildingName">
                                        <form:options items="${buildingNames}" />
                                    </form:select>

                                </div>

                            </div>
                            <div class="modal-footer">
                                <a href="#" class="btn btn-primary btn-default btn-sm" id="addBuildingButton"><span class="glyphicon glyphicon-plus">
                                    </span>Add Building</a>
                                <button type="submit" class="btn btn-primary" x>Submit</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

            <p> <P>
        </div>
        <!-- Modal to add a building -->
        <div class="modal fade" id="addBuilding" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form:form method="POST" action="addBuilding" commandName="newBuilding">
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





        <div class="middle col-md-10 col-md-offset-1 ">
            <div class="col-md-6 mid-left " >
                <h3>Building Name: ${buildingName}</h3>
                <h3>Renters  Insurance: $${userCost.rentersInsurance}</h3>
                <h3>Utilities: $${userCost.utilities}</h3>
                <h3>Base Rent: $${userCost.baseRent}</h3>

            </div>
            <div class="col-md-6 mid-right" >
                <h3>Internet: $${userCost.internet}</h3>
                <h3>Water: $${userCost.water}</h3>
                <h3>Trash: $${userCost.trash}</h3>
                <h3>Electric: $${userCost.electric}</h3>
                <h3>Gas: $${userCost.gas}</h3>

            </div>

        </div> <!-- /container -->



        <!нн jQuery (necessary for Bootstrap's JavaScript plugins) нн>
        <script src="../js/jquery.js" ></script>
        <!нн Include all compiled plugins, or include individual files as needed нн>
        <script src="../js/bootstrap.js" ></script>
        <script>
            $("#addBuildingButton").click(function() {
                $('#newBuilding').modal('hide')
                $('#addBuilding').modal('show')
            });
        </script>

    </body>



</html>