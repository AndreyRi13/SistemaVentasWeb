<%-- 
    Document   : login
    Created on : 26/06/2021, 9:15:35 p. m.
    Author     : Andrey R
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>


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
        <!-- bootstrap core css -->
        <link rel="stylesheet" type="text/css" href="../css/inicio/bootstrap.css" />

        <!-- fonts style -->
        <link href="https://fonts.googleapis.com/css?family=Poppins:400,700&display=swap" rel="stylesheet"> <!-- range slider -->

        <!-- font awesome style -->
        <link href="../css/inicio/font-awesome.min.css" rel="stylesheet" />
        <link href="../css/inicio/ion.rangeSlider.min.css" rel="stylesheet" />
        <link href="../css/inicio/style.css.map" rel="stylesheet" />
        <!-- Custom styles for this template -->
        <link href="../css/inicio/style.css" rel="stylesheet" />
        <link rel="stylesheet" href="../path/to/font-awesome/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>

        <!-- responsive style -->
        <link href="../css/inicio/responsive.css" rel="stylesheet" />
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link href="../css/styles_main.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

        <title>Login</title>
    </head>
    <body>
        <div class="hero_area">
            <!-- header section strats -->

            <header class="header_section">
                <div class="header_top">
                    <div class="container-fluid">
                        <div class="top_nav_container">
                            <div class="contact_nav">
                                <a href="">
                                    <i class="fa fa-phone" aria-hidden="true"></i>
                                    <span>
                                        Call : +57 3105666554
                                    </span>
                                </a>
                                <a href="">
                                    <i class="fa fa-envelope" aria-hidden="true"></i>
                                    <span>
                                        Email : demo@gmail.com
                                    </span>
                                </a>
                            </div>
                            <from class="search_form">
                                <input type="text" class="form-control" placeholder="Buscar calzado...">
                                <button class="" type="submit">
                                    <i class="fa fa-search" aria-hidden="true"></i>
                                </button>
                            </from>
                            <div class="user_option_box">
                                <a href="vistas/validar?a=Login" class="account-link">
                                    <i class="fa fa-user" aria-hidden="true"></i>
                                    <span>
                                        Mi Cuenta
                                    </span>
                                </a>
                                <a href="" class="cart-link">
                                    <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                                    <span>
                                        Carrito
                                    </span>
                                </a>
                            </div>
                        </div>

                    </div>
                </div>
                <div class="header_bottom">
                    <div class="container-fluid">
                        <nav class="navbar navbar-expand-lg custom_nav-container ">
                            <a class="navbar-brand" href="/SistemasVentasWeb/inicio">
                                <span>
                                    CAYSAM
                                </span>
                            </a>

                            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                                <span class=""> </span>
                            </button>

                            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                                <ul class="navbar-nav ">
                                    <li class="nav-item active">
                                        <a class="nav-link" href="/SistemasVentasWeb/inicio">Inicio <span class="sr-only">(current)</span></a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="/SistemasVentasWeb/inicio#productos">Productos</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="/SistemasVentasWeb/inicio#nosotros"> Nosotros</a>
                                    </li>

                                    <li class="nav-item">
                                        <a class="nav-link" href="/SistemasVentasWeb/inicio#porquenosotros">Por qué nosotros</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="/SistemasVentasWeb/inicio#testimonios">Testimonio</a>
                                    </li>
                                </ul>
                            </div>
                        </nav>
                    </div>
                </div>
            </header>

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
                                            <label class="control control--checkbox mb-0"><span class="caption">Recordarme</span>
                                                <input type="checkbox" checked="checked"/>
                                                <div class="control__indicator"></div>
                                            </label>
                                            <span class="ml-auto"><a style="color: black;" href="compradorcontroller?menu=registrarComprador" class="forgot-pass">Registrate</a></span> 
                                            <br>
                                            <span class="ml-auto"><a style="color: black;" href="#" class="forgot-pass">Olvide mi contraseña</a></span> 
                                        </div>                            
                                        <button type="submit"  class="btn btn-success">
                                            Ingresar
                                        </button>

                                        <span class="d-block text-left my-4 text-muted">&mdash; Iniciar Sesion Con &mdash;</span>

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

            <!-- info section -->
            <section class="info_section ">
                <div class="container">
                    <div class="row">
                        <div class="col-md-3">
                            <div class="info_contact">
                                <h5>
                                    <a href="" class="navbar-brand">
                                        <span>
                                            Minics
                                        </span>
                                    </a>
                                </h5>
                                <p>
                                    <i class="fa fa-map-marker" aria-hidden="true"></i>
                                    Address
                                </p>
                                <p>
                                    <i class="fa fa-phone" aria-hidden="true"></i>
                                    +01 1234567890
                                </p>
                                <p>
                                    <i class="fa fa-envelope" aria-hidden="true"></i>
                                    demo@gmail.com
                                </p>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="info_info">
                                <h5>
                                    Information
                                </h5>
                                <p>
                                    Eligendi sunt, provident, debitis nemo, facilis cupiditate velit libero dolorum aperiam enim nulla iste maxime corrupti ad illo libero minus.
                                </p>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="info_links">
                                <h5>
                                    Useful Link
                                </h5>
                                <ul>
                                    <li>
                                        <a href="index.html">
                                            Home
                                        </a>
                                    </li>
                                    <li>
                                        <a href="about.html">
                                            About
                                        </a>
                                    </li>
                                    <li>
                                        <a href="product.html">
                                            Products
                                        </a>
                                    </li>
                                    <li>
                                        <a href="why.html">
                                            Why Us
                                        </a>
                                    </li>
                                    <li>
                                        <a href="testimonial.html">
                                            Testimonial
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="info_form ">
                                <h5>
                                    Newsletter
                                </h5>
                                <form action="">
                                    <input type="email" placeholder="Enter your email">
                                    <button>
                                        Subscribe
                                    </button>
                                </form>
                                <div class="social_box">
                                    <a href="">
                                        <i class="fa fa-facebook" aria-hidden="true"></i>
                                    </a>
                                    <a href="">
                                        <i class="fa fa-twitter" aria-hidden="true"></i>
                                    </a>
                                    <a href="">
                                        <i class="fa fa-instagram" aria-hidden="true"></i>
                                    </a>
                                    <a href="">
                                        <i class="fa fa-youtube" aria-hidden="true"></i>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>

            <!-- end info_section -->


            <!-- footer section -->
            <footer class="footer_section">
                <div class="container">
                    <p>
                        &copy; <span id="displayYear"></span> All Rights Reserved By
                        <a href="https://html.design/">Free Html Templates</a>
                    </p>
                </div>
            </footer>
            <!-- footer section -->

            <!-- jQery -->
            <script src="../js/jquery-3.4.1.min.js"></script>
            <!-- bootstrap js -->
            <script src="../js/bootstrap.js"></script>
            <!-- custom js -->
            <script src="../js/custom.js"></script>


    </body>

</html>