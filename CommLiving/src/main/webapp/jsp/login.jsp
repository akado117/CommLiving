<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link  href="../css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link  href="../css/table.css" rel="stylesheet" media="screen">
        <title>Login</title>
    </head>
    <body>


        <div class="container col-sm-4 col-sm-offset-4">


            <form class="form-signin signin" role="form" method="post" action="../j_spring_security_check">


                <h1><center>Welcome to: Comm Living</center></h1>
                <small>Please login</small>
                <c:if test="${param.login_error == 1}">
                    <p>Wrong id or password!</p>
                </c:if>
                <p>${message}</p>

                <input type="text" class="form-control" placeholder="User Name" 
                       id="username_or_email" name="j_username"  autofocus>
                <input class="form-control" placeholder="Password" id="password" name="j_password" type="password">

                <button class="btn btn-lg btn-primary btn-block" name="commit" type="submit">Sign in</button>
                <button class="btn btn-lg btn-primary btn-block" type="button" data-toggle="modal" data-target="#addUser">New User</button>
                <!-- Modal for add user-->
            </form>
            <div class="modal fade" id="addUser" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form method="POST" action="addUser">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h4 class="modal-title" id="myModalLabel">Add a User</h4>
                            </div>
                            <div class="modal-body" >

                                <div class="form-group">
                                    <label for="aname">UserName:</label>
                                    <input name="addName" type="text" class="form-control" id="aname" placeholder="Enter Username">
                                </div>
                                <div class="form-group">
                                    <label for="apassword">Password:</label>
                                    <input name="addPassword" type="password" class="form-control" id="apassword" placeholder="Enter name">
                                </div>

                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                <button type="submit" value="Add User" class="btn btn-primary">Add User</button>

                            </div>
                        </form>
                    </div>
                </div>
            </div>


            <div style="height:50px;margin-top:10px;">
                <div style="width:150px;float:left;">
                    <input type="checkbox" value="remember-me"> Remember me
                </div>
                <button style="float:right;" class="btn btn-sm btn-primary " type="submit">Forgot Password</button>
            </div>


        </div> <!-- /container -->



        <!нн jQuery (necessary for Bootstrap's JavaScript plugins) нн>
        <script src="../js/jquery.js" ></script>
        <!нн Include all compiled plugins, or include individual files as needed нн>
        <script src="../js/bootstrap.js" ></script>

    </body>



</html>