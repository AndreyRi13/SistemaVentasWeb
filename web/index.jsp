<%-- 
    Document   : index
    Created on : 27/06/2021, 11:39:32 a. m.
    Author     : Andrey R
--%>

<%%>
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
        <link rel="stylesheet" type="text/css" href="./css/inicio/bootstrap.css" />

        <!-- fonts style -->
        <link href="https://fonts.googleapis.com/css?family=Poppins:400,700&display=swap" rel="stylesheet"> <!-- range slider -->

        <!-- font awesome style -->
        <link href="./css/inicio/font-awesome.min.css" rel="stylesheet" />
        <link href="./css/inicio/ion.rangeSlider.min.css" rel="stylesheet" />
        <link href="./css/inicio/style.css.map" rel="stylesheet" />
        <!-- Custom styles for this template -->
        <link href="./css/inicio/style.css" rel="stylesheet" />
        <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" integrity="sha512-PgQMlq+nqFLV4ylk1gwUOgm6CtIIXkKwaIHp/PAIWHzig/lKZSEGKEysh0TCVbHJXCLN7WetD8TFecIky75ZfQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <!-- responsive style -->
        <link href="./css/inicio/responsive.css" rel="stylesheet" />

    </head>

    <body>

        <div class="hero_area">
            <!-- header section strats -->
            <header class="header_section">
              
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
                                    
                                    <li class="nav-item">
                                        <div class="user_option_box">
                                            <a href="vistas/validar?a=Login" class="nav-link">
                                                <i class="fa fa-user" aria-hidden="true"></i>
                                                <span>Mi cuenta</span>
                                            </a> </div>
                                    </li>
                                </ul>
                            </div>
                        </nav>
                    </div>
                </div>
            </header>
            <!-- end header section -->
            <!-- slider section -->
            <section class="slider_section">
                <div id="customCarousel1" class="carousel slide" data-ride="carousel">
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <div class="container ">
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="detail-box">
                                            <h1>
                                                Bienvenido a tu tienda virtual
                                            </h1>
                                            <p>
                                                ${empresa.saludo}                                           
                                            </p>
                                            <a href="">
                                                Leer Más
                                            </a>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="img-box">
                                            <img src="images/slider-img.jpg" alt="">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <div class="container ">
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="detail-box">
                                            <h1>
                                                Bienvenido a tu tienda virtual
                                            </h1>
                                            <p>
                                                ${empresa.saludo}
                                            </p>
                                            <a href="">
                                                Leer Más
                                            </a>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="img-box">
                                            <img src="images/slider-img.jpg" alt="">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="carousel_btn_box" style="width:50px; height:50px;">
                        <a class="carousel-control-prev" href="#customCarousel1" role="button" data-slide="prev" style="width: 25px; height:25px;">
                            <i class="fa fa-angle-left" aria-hidden="true"></i>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="carousel-control-next" href="#customCarousel1" role="button" data-slide="next" style="width: 25px; height:25px;">
                            <i class="fa fa-angle-right" aria-hidden="true"></i>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>
                </div>
            </section>
            <!-- end slider section -->
        </div>


        <!-- product section -->

        <section class="product_section layout_padding" id="productos">
            <div class="container">
                <div class="heading_container heading_center">
                    <h2>
                        Todos los Productos
                    </h2>
                </div>
                <div class="row">
                    <c:forEach var="producto" items="${calzados}">
                        <div class="col-sm-6 col-lg-4">
                            <div class="box">
                                <div class="row img-box">
                                    <img src="images/${producto.foto}" alt="" style="width:365px; height:265px;">

                                    <a href="inicio?a=verMas" class="add_cart_btn" style="width:155px;">
                                        <span>
                                            Agregar al Carrito
                                        </span>
                                    </a>
                                </div>
                                <br>
                                <br>
                                <a href="inicio?a=verMas" class="add_cart_btn">
                                    <span>
                                        Ver más
                                    </span>
                                </a>


                                <div class="detail-box">
                                    <h5>
                                        ${producto.nombres}
                                    </h5>
                                    <div class="product_info">
                                        <h5>
                                            <span>$</span>${producto.precio}
                                        </h5>
                                        <div class="star_container">
                                            <i class="fa fa-star" aria-hidden="true"></i>
                                            <i class="fa fa-star" aria-hidden="true"></i>
                                            <i class="fa fa-star" aria-hidden="true"></i>
                                            <i class="fa fa-star" aria-hidden="true"></i>
                                            <i class="fa fa-star" aria-hidden="true"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <div class="btn_box">
                    <a href="" class="view_more-link">
                        Ver Más
                    </a>
                </div>
            </div>
        </section>

        <!-- end product section -->

        <!-- about section -->

        <section class="about_section" id="nosotros">
            <div class="container-fluid  ">
                <div class="row">
                    <div class="col-md-5 ml-auto">
                        <div class="detail-box pr-md-3">
                            <div class="heading_container">
                                <h2>

                                    Ofrecemos lo mejor para usted
                                </h2>
                            </div>
                            <p>
                                ${empresa.ofrecemos}
                            </p>
                        </div>
                    </div>
                    <div class="col-md-6 px-0">
                        <div class="img-box">
                            <img src="images/hombres-nike-air-max-270-blanco-negro.jpg" alt="" style="width: 500px;height: 400px;">
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <!-- end about section -->

        <!-- why us section -->

        <section class="why_us_section layout_padding" id="porquenosotros">
            <div class="container">
                <div class="heading_container heading_center">
                    <h2>
                        Por qué elegirnos
                    </h2>
                </div>
                <div class="row">
                    <div class="col-md-4">
                        <div class="box ">
                            <div class="img-box">
                                <img src="images/w1.png" alt="">
                            </div>
                            <div class="detail-box">
                                <h5>
                                    Entrega Confiable y Rápida
                                </h5>
                                <p>
                                    ¡No perdemos el tiempo a la hora de dar el mejor servicio es por ello que contratamos las mejores !
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="box ">
                            <div class="img-box">
                                <img src="images/w2.png" alt="">
                            </div>
                            <div class="detail-box">
                                <h5>
                                    Precios Asequibles
                                </h5>
                                <p>
                                    variations of passages of Lorem Ipsum available
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="box ">
                            <div class="img-box">
                                <img src="images/w3.png" alt="">
                            </div>
                            <div class="detail-box">
                                <h5>
                                    Mejor calidad
                                </h5>
                                <p>
                                    variations of passages of Lorem Ipsum available
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <!-- end why us section -->


        <!-- client section -->

        <section class="client_section layout_padding-bottom" id="testimonios">
            <div class="container">
                <div class="heading_container heading_center">
                    <h2>
                        Qué dicen nuestros clientes
                    </h2>
                </div>
            </div>
            <div class="client_container ">
                <div id="carouselExample2Controls" class="carousel slide" data-ride="carousel">
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <div class="container">
                                <div class="box">
                                    <div class="detail-box">
                                        <p>
                                            <i class="fa fa-quote-left" aria-hidden="true"></i>
                                        </p>
                                        <p>
                                            ${empresa.nuestrosClientes}
                                        </p>
                                    </div>
                                    <div class="client-id">
                                        <div class="img-box">
                                            <img src="images/client.jpg" alt="">
                                        </div>
                                        <div class="name">
                                            <h5>
                                                James Dew
                                            </h5>
                                            <h6>
                                                Photographer
                                            </h6>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <div class="container">
                                <div class="box">
                                    <div class="detail-box">
                                        <p>
                                            <i class="fa fa-quote-left" aria-hidden="true"></i>
                                        </p>
                                        <p>
                                            ${empresa.nuestrosClientes}
                                        </p>
                                    </div>
                                    <div class="client-id">
                                        <div class="img-box">
                                            <img src="images/client.jpg" alt="">
                                        </div>
                                        <div class="name">
                                            <h5>
                                                James Dew
                                            </h5>
                                            <h6>
                                                Photographer
                                            </h6>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                    <div class="carousel_btn-box">
                        <a class="carousel-control-prev" href="#carouselExample2Controls" role="button" data-slide="prev">
                            <span>
                                <i class="fa fa-angle-left" aria-hidden="true"></i>
                            </span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="carousel-control-next" href="#carouselExample2Controls" role="button" data-slide="next">
                            <span>
                                <i class="fa fa-angle-right" aria-hidden="true"></i>
                            </span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>
                </div>
            </div>
        </section>
        <!-- end client section -->

        <!-- info section -->
        <section class="info_section ">
            <div class="container">
                <div class="row">
                    <div class="col-md-5">
                        <div class="info_contact">
                            <h5>
                                <a href="" class="navbar-brand">
                                    <span>
                                        CAYSAM
                                    </span>
                                </a>
                            </h5>
                            <p>
                                <i class="fa fa-map-marker" aria-hidden="true"></i>
                                Direccion: ${empresa.direccion}
                            </p>
                            <p>
                                <i class="fa fa-phone" aria-hidden="true"></i>
                                Telefonos: ${empresa.telefonos}
                            </p>
                            <p>
                                <i class="fa fa-envelope" aria-hidden="true"></i>
                                Correo Electronico: ${empresa.correoElectronico}
                            </p>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="info_info">
                            <h5>
                                Informacion
                            </h5>
                            <p style="text-align: justify;">
                                ${empresa.ofrecemos}                            
                            </p>
                        </div>
                    </div>

                    <div class="col-md-4">
                        <div class="info_form ">
                            <h5>
                                Recibir Promociones e Informacion
                            </h5>
                            <form action="">
                                <input type="email" placeholder="Dejanos tu Correo Electronico">
                                <button>
                                    Suscribirme
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
                    &copy; <span id="displayYear"></span> Todos los derechos reservados por CAYSAM
                    <br>Desarrollador por:
                    <a href="https://github.com/AndreyRi13/">DigiTech</a>
                </p>
            </div>
        </footer>
        <!-- footer section -->

        <!-- jQery -->
        <script src="./js/jquery-3.4.1.min.js"></script>
        <!-- bootstrap js -->
        <script src="./js/bootstrap.js"></script>
        <!-- custom js -->
        <script src="./js/custom.js"></script>


    </body>

</html>