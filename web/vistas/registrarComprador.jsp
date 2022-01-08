<%-- 
    Document   : registrarComprador
    Created on : 16/07/2021, 5:34:02 p. m.
    Author     : Andrey R
--%>


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

        <!--Style--> 
        <link href="../fonts/icomoon/style.css" rel="stylesheet" />   
        <link href="../css/style.css" rel="stylesheet" />
        <link rel="stylesheet" type="text/css" href="../css/inicio/bootstrap.css" />      
        <!--fonts style--> 
        <link href="https://fonts.googleapis.com/css?family=Poppins:400,700&display=swap" rel="stylesheet">  
        <!--range slider -->
        <!--font awesome style--> 
        <link href="../css/inicio/font-awesome.min.css" rel="stylesheet" />
        <link href="../css/inicio/ion.rangeSlider.min.css" rel="stylesheet" />
        <link href="../css/inicio/style.css.map" rel="stylesheet" />
        <!--Custom styles for this template--> 
        <link href="../css/inicio/style.css" rel="stylesheet" />    
        <!--responsive style--> 
        <link href="../css/inicio/responsive.css" rel="stylesheet" />
        <!--Iconos style--> 
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" integrity="sha512-PgQMlq+nqFLV4ylk1gwUOgm6CtIIXkKwaIHp/PAIWHzig/lKZSEGKEysh0TCVbHJXCLN7WetD8TFecIky75ZfQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <!--MATERIAL DESIGN ICONIC FONT--> 
        <link rel="stylesheet" href="../fonts/material-design-iconic-font/css/material-design-iconic-font.css">
        <link href="../css/estilosRegistro.css" rel="stylesheet" type="text/css"/>
        <!--STYLE CSS -->
        <link rel="stylesheet" href="../css/estilo.css">

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

                                    <li class="nav-item">
                                        <div class="user_option_box">
                                            <a href="/SistemasVentasWeb/vistas/validar?a=Login" class="nav-link">
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

            <div class="container register">
                <div class="row">
                    <div class="col-md-3 register-left">
                        <img src="../images/logo_white.png" alt=""/>
                        <h3 style="color: #3a4468;">Bienvenido</h3>
                        <p style="color: #3a4468;">Si ya tienes con una cuenta, inicia sesion y disfruta de las promociones!</p>

                        <form action="validar" method="POST">
                            <!--<li><button class="dropdown-item" name="a" value="Salir">Salir</button></li>-->
                            <input  class="border" style="background-color: #3a4468; color: white;"type="submit" name="a" value="Login"/><br/>
                        </form>


                    </div>
                    <div class="col-md-9 register-right">

                        <div class="tab-content" id="myTabContent">
                            <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                                <h3 class="register-heading">REGISTRO</h3>

                                <form class="form-horizontal" action="compradorcontroller?menu=registroComprador" method="POST">
                                    <div class="row register-form">
                                        <div class="col-md-6">

                                            <!--                                            <div class="row">
                                                                                            <div class="col-6">
                                                                                                <span>Foto de perfil:</span>
                                                                                            </div>
                                                                                            <div class="col-6">
                                                                                                <div id="file-select" class="form-group" style="width: 100%; height: 60%;">
                                                                                                    <input id="fotoPerfil" encType="multipart/form-data" type="file" name="txtFoto" accept="image/png, .jpeg, .jpg, image/gif">
                                                                                                </div>
                                                                                            </div>
                                                                                        </div>-->


                                            <div class="form-group">
                                                <input id="fname" name="txtCedula" type="text" placeholder="Cedula" class="form-control"/>
                                            </div> 
                                            <div class="form-group">
                                                <input  id="fname" name="txtNombres" type="text" placeholder="Nombres" class="form-control"/>
                                            </div>

                                            <div class="form-group">
                                                <input id="fname" name="txtUsername" type="text" placeholder="Usuario" class="form-control">
                                            </div>

                                            <div class="form-group">
                                                <input  id="fname" name="txtDireccion" type="text" placeholder="Direccion" class="form-control">
                                            </div>

                                            <div class="form-group">
                                                <input id="fname" name="txtCorreoElectronico" type="text" placeholder="Correo electronico" class="form-control">
                                            </div>


                                            <div class="form-group">
                                                <label>Genero:</label>
                                                <div class="maxl">

                                                    <label class="radio inline"> 
                                                        <input type="radio" name="txtGenero" value="masculino" checked>
                                                        <span> Masculino </span> 
                                                    </label>

                                                    <label class="radio inline"> 
                                                        <input type="radio"  value="femenino">
                                                        <span>Femenino </span> 
                                                    </label>

                                                    <label class="radio inline"> 
                                                        <input type="radio" value="otro">
                                                        <span>Otro </span> 
                                                    </label>
                                                </div>
                                            </div>

                                        </div>
                                        <div class="col-md-6">

                                            <div class="form-group">
                                                <input id="fname" name="txtNumeroCelular" type="text" placeholder="Numero de celular" class="form-control">
                                            </div>




                                            <div class="form-group">
                                                <input  id="fname" name="txtApellidos" type="text" placeholder="Apellidos" class="form-control"/>
                                            </div>

                                            <div class="form-group">
                                                <input id="fname" name="txtPassword" type="text" placeholder="Contraseña" class="form-control">
                                            </div>

                                            <div class="form-group">
                                                <input id="fname"  type="text" placeholder="Confirma tu contraseña" class="form-control">
                                            </div>


                                            <div class="form-group">
                                                <div class="row">
                                                    <div class="col-8">
                                                        <label style="display: inline-block;">Fecha de nacimiento:</label>
                                                        <input id="fname" name="txtFechaNacimiento" type="date" placeholder="Fecha de nacimiento" class="form-control">  
                                                    </div>
                                                    <div class="col-4">
                                                        <label>Edad:</label>
                                                        <input id="fname" name="txtEdad" type="number" placeholder="Edad" class="form-control">
                                                    </div>    
                                                </div>
                                            </div>

                                        </div>


                                        <button style="background-color: #3a4468; color: white;" type="submit" class="btnRegister"/>Registrarme</button>
                                    </div>
                                </form>
                            </div>
                        </div>                       
                    </div>
                </div>
            </div>

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
                    <br>Desarrollador:
                    <a href="#">DigiTech</a>
                </p>
            </div>
        </footer>

        <!-- jQery -->
        <script src="../js/jquery-3.4.1.min.js"></script>
        <!-- bootstrap js -->
        <script src="../js/bootstrap.js"></script>
        <!-- custom js -->
        <script src="../js/custom.js"></script>
        <!-- JQUERY -->
        <script src="../js/jquery-3.3.1.min.js"></script>

        <!-- JQUERY STEP -->
        <script src="../js/jquery.steps.js"></script>
        <script src="../js/mainn.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://cdn.usebootstrap.com/bootstrap/4.1.1/js/bootstrap.bundle.min.js"></script>
    </body>

</html>