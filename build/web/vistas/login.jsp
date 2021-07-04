<%-- 
    Document   : login
    Created on : 26/06/2021, 9:15:35 p. m.
    Author     : Andrey R
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<!doctype html>
<html lang="es">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

        <link href="../fonts/icomoon/style.css" rel="stylesheet" />
        <link href="../css/owl.carousel.min.css" rel="stylesheet"/>
  

        <!-- Bootstrap CSS -->
        <link href="../css/bootstrap.min.css" rel="stylesheet"/>

        <!-- Style -->
        <link href="../css/style.css" rel="stylesheet" />

        <title>Login</title>
    </head>
    <body>



        <div class="content">
            <div class="container">
                <div class="row">
                    <div class="col-md-6">
                        <img src="../images/undraw_remotely_2j6y.svg" alt="Image" class="img-fluid">
                    </div>
                    <div class="col-md-6 contents">
                        <div class="row justify-content-center">
                            <div class="col-md-8">
                                <div class="mb-4">
                                    <h3>Iniciar Sesion</h3>
                                    <p class="mb-4">Administrador</p>
                                </div>
                                <form action="validar?a=ingresar" method="POST">
                                    <label for="username">Digita tu usuario</label>
                                    <div class="form-group first">

                                        <input class="form-control" type="text" placeholder="Usuario" name="txtuser" required />

                                    </div>
                                    <label for="password">Digita tu contraseña</label>
                                    <div class="form-group last mb-4">

                                        <input class="form-control" type="password" placeholder="Contraseña" name="txtpass" required/>

                                    </div>

                                    <div class="d-flex mb-5 align-items-center">
                                        <label class="control control--checkbox mb-0"><span class="caption">Remember me</span>
                                            <input type="checkbox" checked="checked"/>
                                            <div class="control__indicator"></div>
                                        </label>
                                        <span class="ml-auto"><a href="#" class="forgot-pass">Forgot Password</a></span> 
                                    </div>                            
                                    <button type="submit"  class="btn btn-success">
                                        Ingresar
                                    </button>

                                    <span class="d-block text-left my-4 text-muted">&mdash; or login with &mdash;</span>

                                    <div class="social-login">
                                        <a href="#" class="facebook">
                                            <span class="icon-facebook mr-3"></span> 
                                        </a>
                                        <a href="#" class="twitter">
                                            <span class="icon-twitter mr-3"></span> 
                                        </a>
                                        <a href="#" class="google">
                                            <span class="icon-google mr-3"></span> 
                                        </a>
                                    </div>
                                </form>
                            </div>

                        </div>

                    </div>

                </div>
            </div>
        </div>
        <% //si ls respuesta de mi servlet es diferente a vacio
            if (request.getAttribute("mensaje") != null) {  //tendrìa que mandar a imprimir por medio del alert de abajo el mensaje de acceso correcto o incorrecto, pero no me lo muestra
        %>          
        <script>window.onload = function () {
                                    alert("<%=request.getAttribute("mensaje")%>");
                                };</script>
        <br>

        <%
            }
        %>

        <script src="../js/jquery-3.3.1.min.js"></script>
        <script src="../js/popper.min.js"></script>
        <script src="../js/bootstrap.min.js"></script>
        <script src="../js/main.js"></script>
    </body>
</html>