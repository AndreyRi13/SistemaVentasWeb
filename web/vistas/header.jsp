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
        <!-- Site Metas -->
        <link rel="icon" href="./images/fevicon.png" type="image/gif" />
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <meta name="author" content="" />

        <title>CAYSAM</title>


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
                            <a class="navbar-brand" href="index.html">
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

