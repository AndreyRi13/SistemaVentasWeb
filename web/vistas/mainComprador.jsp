<%-- 
    Document   : index
    Created on : 27/06/2021, 11:39:32 a. m.
    Author     : Andrey R
--%>


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <!-- Basic -->
        <meta http-equiv="Content-Type" contentType="text/html; charset=UTF-8">

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

    </head>

    <body>

        <div class="hero_area">
            <!-- header section strats -->
            <header class="header_section">

                <div class="header_bottom">
                    <div class="container-fluid">
                        <nav class="navbar navbar-expand-lg custom_nav-container ">
                            <a class="navbar-brand" href="#">
                                <span>
                                    CAYSAM
                                </span>
                            </a>

                            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                                <span class=""> </span>
                            </button>

                            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                                <ul class="navbar-nav ">

                                    <li class="nav-item">
                                        <div class="user_option_box">
                                            <a href="comprascontroller?a=carrito" class="nav-link">
                                                <i class="fa fa-cart-plus" aria-hidden="true"><label style="color:orange;">${contador}</label></i>
                                                <span>
                                                    Carrito
                                                </span>
                                            </a> </div>
                                    </li>

                                    <li class="nav-item">
                                        <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
                                            <li class="nav-item dropdown">
                                                <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="fa fa-user" aria-hidden="true"></i>
                                                    <span>${comprador.nombres} ${comprador.apellidos}</span></a>
                                                <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                                                    <li><a class="dropdown-item" href="#!">${comprador.username}</a></li>                                              
                                                    <li> <a class="dropdown-item" href="validar?a=PageditarPerfil" target="myFrame">Editar perfil</a></li>
                                                    <li><hr class="dropdown-divider"/></li>
                                                    <form action="logout" method="POST">
                                                        <li><button class="dropdown-item" name="a" value="Salir">Salir</button></li>
                                                    </form>
                                                </ul>
                                            </li>
                                        </ul>
                                    </li>
                                </ul>
                            </div>
                        </nav>
                    </div>
                </div>
            </header>

            <!-- end header section -->



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
                                        <img src="../images/${producto.foto}" alt="" style="width:365px; height:265px;">

                                        <a href="comprascontroller?a=addCart&id=${producto.idCalzado}" class="add_cart_btn" style="width:155px;">
                                            <span>
                                                Agregar al Carrito
                                            </span>
                                        </a>

                                        <div class="col-6">
                                            <a href="comprascontroller?a=comprar&id=${producto.idCalzado}" class="add_cart_btn" style="width:80px;">
                                                <span>
                                                    Comprar
                                                </span>
                                            </a>
                                        </div>
                                    </div>
                                    <br>
                                    <br>
                                    <a href="comprascontroller?a=verMas&id=${producto.idCalzado}" class="add_cart_btn">
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
                </div>
            </section>

            <!-- end product section -->
 </div>

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
                        <a href="#">DigiTech</a>
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
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
            <script src="../js/scripts.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
            <script src="../assets/demo/chart-area-demo.js"></script>
            <script src="../assets/demo/chart-bar-demo.js"></script>
            <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
            <script src="../js/datatables-simple-demo.js"></script>

    </body>

</html>