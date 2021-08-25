<%-- 
    Document   : header
    Created on : 16/07/2021, 10:14:47 p. m.
    Author     : Andrey R
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <!-- Basic -->
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <!-- Mobile Metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />

        <title>CAYSAM</title>

        <link rel="icon" href="../images/fevicon.png" type="image/gif" />

        <!-- Login -->
        <link href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link href="https://fonts.googleapis.com/css?family=Poppins:400,700&display=swap" rel="stylesheet"> <!-- range slider -->
        <link href="../fonts/icomoon/style.css" rel="stylesheet" />
        <link href="../css/owl.carousel.min.css" rel="stylesheet"/>
        <!-- Bootstrap CSS -->
        <link href="../css/bootstrap.min.css" rel="stylesheet"/>
        <!-- Style -->
        <link href="../css/style.css" rel="stylesheet" />
        <link rel="stylesheet" type="text/css" href="../css/inicio/bootstrap.css" />

        <!-- Barra de Navegacion -->
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
        <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>

        <!-- responsive style -->
        <link href="../css/inicio/responsive.css" rel="stylesheet" />
        <!-- Iconos style -->
        <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>


        <!-- MATERIAL DESIGN ICONIC FONT -->
        <link rel="stylesheet" href="../fonts/material-design-iconic-font/css/material-design-iconic-font.css">
        <link href="../css/estilosRegistro.css" rel="stylesheet" type="text/css"/>
        <!-- STYLE CSS -->
        <link rel="stylesheet" href="../css/estilo.css">

        <link href="https://cdn.usebootstrap.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="https://cdn.usebootstrap.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <link href="../css/estilo.css" rel="stylesheet" type="text/css"/>

    </head>

    <body>

        <header class="header_section">
            <div class="header_top">
                <div class="container-fluid">
                    <div class="top_nav_container">
                        <div class="contact_nav">
                            <a href="">
                                <i class="fa fa-phone" aria-hidden="true"></i>
                                <span>
                                    Telefonos: ${empresa.telefonos}
                                </span>
                            </a>
                            <a href="">
                                <i class="fa fa-envelope" aria-hidden="true"></i>
                                <span>
                                    Correo: ${empresa.correoElectronico}
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
                            <a href="inicio?a=carrito" class="cart-link">
                                <i class="fa fa-cart-plus" aria-hidden="true"><label style="color:orange;">${contador}</label></i>
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
                                    <a class="nav-link" href="#productos">Productos</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#nosotros">Nosotros</a>
                                </li>                                   

                                <li class="nav-item">
                                    <a class="nav-link" href="#porquenosotros">Por qué elegirnos</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#testimonios">Nuestros clientes</a>
                                </li>
                            </ul>
                        </div>
                    </nav>
                </div>
            </div>
        </header>

