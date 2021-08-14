<%-- 
    Document   : carrito
    Created on : 28/07/2021, 11:02:05 p. m.
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
        <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>

        <!-- responsive style -->
        <link href="./css/inicio/responsive.css" rel="stylesheet" />

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
                                    <i class="fa fa-cart-plus" aria-hidden="true">(<label style="color:orange;">${contador}</label>)</i>
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
                                        <a class="nav-link" href="/SistemasVentasWeb/inicio#nosotros">Nosotros</a>
                                    </li>                                   

                                    <li class="nav-item">
                                        <a class="nav-link" href="/SistemasVentasWeb/inicio#porquenosotros">Por qué elegirnos</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="/SistemasVentasWeb/inicio#testimonios">Nuestros clientes</a>
                                    </li>
                                </ul>
                            </div>
                        </nav>
                    </div>
                </div>
            </header>
            <!-- product section -->
            <section class="product_section layout_padding">
                <div class="container">
                    <div class="heading_container heading_center">
                        <h2>
                            Carrito
                        </h2>
                    </div>




                    <div class="container mt-4">
                        <div class="row">

                            <div class="col-sm-8">
                                <table class="table table-hover" border="1">
                                    <thead>
                                        <tr>
                                            <th>ITEM</th>
                                            <th>NOMBRES</th>
                                            <th>DESCRIPCION</th>
                                            <th>PRECIO</th>
                                            <th>CANT</th>
                                            <th>SUBTOTAL</th>
                                            <th>ACCION</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="car" items="${carrito}">
                                        <tr>
                                            <td>${car.getItem()}</td>
                                            <td>${car.getItem()}</td>
                                            <td>${car.getItem()}</td>
                                            <td>${car.getItem()}</td>
                                            <td>${car.getItem()}</td>
                                            <td>${car.getItem()}</td>
                                            <td>${car.getItem()}</td>
                                        </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div> 
                            <div class="col-sm-4">
                                <div class="card">
                                    <div class="card-header">
                                        <h3>Generar Compra</h3>
                                        
                                    </div>
                                    <div class="card-body">
                                        <label>SubTotal:</label>
                                        <input type="text" readonly="" class="form-control">
                                        <label>Descuento:</label>
                                        <input type="text" readonly="" class="form-control">
                                        <label>Total Pagar:</label>
                                        <input type="text" readonly="" class="form-control">
                                    </div>
                                    <div class="card-footer">
                                        <a href="" class="btn btn-info btn-block">Realizar Pago</a>
                                        <a href="" class="btn btn-danger btn-block">Generar Pago</a>
                                    </div>
                                </div>  
                                
                            </div>



                        </div>

                    </div>




                    <c:forEach var="producto" items="${calzados}">

                        <img src="images/${producto.foto}" alt="" style="width:365px; height:265px;">

                        <a href="inicio?a=agregarCarrito&id=${producto.idCalzado}" class="add_cart_btn" style="width:155px;">
                            <span>
                                Agregar al Carrito
                            </span>
                        </a>

                        <div class="col-6">
                            <a href="" class="add_cart_btn" style="width:80px;">
                                <span>
                                    Comprar
                                </span>
                            </a>
                        </div>
                    </div>
                    <br>
                    <br>
                    <a href="/SistemasVentasWeb/inicio?a=verMas&id=${producto.idCalzado}" class="add_cart_btn">
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
</section>
</div>
<!-- end product section -->


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
                    <br>Desarrollador:
                    <a href="https://github.com/AndreyRi13/">Andrey Rivera</a>
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