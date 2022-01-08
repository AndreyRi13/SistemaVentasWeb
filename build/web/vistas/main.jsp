<%-- 
    Document   : main
    Created on : 26/06/2021, 10:17:56 p. m.
    Author     : Andrey R
--%>



<%@page import="DTO.Empleado"%>
<%
    /* HttpSession sesion;
 sesion = request.getSession(false);
 Empleado emplead = (Empleado) sesion.getAttribute("empleado");
 if(emplead==null) {

     response.sendRedirect("/SistemasVentasWeb/inicio");

 } else {*/

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Main</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link href="../css/styles_main.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="icon" href="../images/fevicon.png" type="image/gif" />


    </head>
    <body class="sb-nav-fixed" style="background-color:#E4E8F5;">


        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <!-- Navbar Brand-->
            <a class="navbar-brand ps-3" href="#">CAYSAM</a>
            <!-- Sidebar Toggle-->
            <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i class="fas fa-bars"></i></button>

            <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
                <div class="input-group">
                    <h5 class="mt-2 text-white">${empleado.nombres}  ${empleado.apellidos}</h5>
                </div>
            </form>

            <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#!">${empleado.username}</a></li>                                              
                        <li> <a class="dropdown-item" href="validar?a=PageditarPerfil" target="myFrame">Editar perfil</a></li>

                        <li><hr class="dropdown-divider"/></li>
                        <form action="logout" method="POST">
                            <li><button class="dropdown-item" name="a" value="Salir">Salir</button></li>
                        </form>
                    </ul>
                </li>
            </ul>
        </nav>

        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">

                            <a class="nav-link" href="#">
                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                Home
                            </a>
                            <!--<div class="sb-sidenav-menu-heading">Administración de Calzados</div>-->
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseProductos" aria-expanded="false" aria-controls="collapseProductos">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                Calzado
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseProductos" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="calzadocontroller?menu=agregarCalzado" target="myFrame">Agregar Calzado</a>
                                    <a class="nav-link" href="calzadocontroller?menu=listaCalzado" target="myFrame">Lista de Calzado</a>
                                </nav>
                            </div>



                            <!--<div class="sb-sidenav-menu-heading">Administración de Empleados</div>-->
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseEmpleados" aria-expanded="false" aria-controls="collapseEmpleados">
                                <div class="sb-nav-link-icon"><i class="fas fa-book-open"></i></div>
                                Empleado
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseEmpleados" aria-labelledby="headingTwo">
                                <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
                                    <a class="nav-link" href="empleadocontroller?menu=agregarEmpleado" target="myFrame">Agregar Empleado</a>
                                    <a class="nav-link" href="empleadocontroller?menu=listaEmpleado" target="myFrame">Lista de Empleado</a>                                 
                                </nav>
                            </div>

                            <!--<div class="sb-sidenav-menu-heading">Administración de Compradores</div>-->
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseClientes" aria-expanded="false" aria-controls="collapseClientes">
                                <div class="sb-nav-link-icon"><i class="fas fa-book-open"></i></div>
                                Compradores
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseClientes" aria-labelledby="headingThree" >
                                <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
                                    <a class="nav-link" href="compradorcontroller?menu=agregarComprador" target="myFrame">Agregar Comprador</a>
                                    <a class="nav-link" href="compradorcontroller?menu=listaCompradores" target="myFrame">Lista de Comprador</a>                                 
                                </nav>
                            </div>
                            <!--<div class="sb-sidenav-menu-heading">Administración de Ventas</div>-->
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseVentas" aria-expanded="false" aria-controls="collapseVentas">
                                <div class="sb-nav-link-icon"><i class="fas fa-book-open"></i></div>
                                Ventas
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseVentas" aria-labelledby="headingFour">
                                <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">                            
                                    <a class="nav-link" href="ventacontroller?menu=listarVenta" target="myFrame">Lista de Venta</a>      
                                    <a class="nav-link" href="ventacontroller?menu=informeVenta" target="myFrame">Informe de Ventas</a>   
                                </nav>
                            </div>

                        </div>
                    </div>
                    <div class="sb-sidenav-footer">
                        <div class="small">Desarrollado por:</div>
                        DigiTech
                    </div>
                </nav>
            </div>

            <div id="layoutSidenav_content">            
                <main>
                    <div class="container-fluid px-4">
                        <div class="m-2" style="height:606px;">
                            <iframe name="myFrame" style=" height:100%; width:100%"></iframe>
                        </div>
                    </div>
                </main>             
            </div>

        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="../js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="../assets/demo/chart-area-demo.js"></script>
        <script src="../assets/demo/chart-bar-demo.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
        <script src="../js/datatables-simple-demo.js"></script>
    </body>
</html>
<%   // }
%>