<%-- 
    Document   : editarEmpleado
    Created on : 3/07/2021, 11:31:27 p. m.
    Author     : Andrey R
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar Empleado</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body>

        <div class="card">
            <div class="card-body">

                <div class="container">


                    <div class="well well-sm">
                        <form class="form-horizontal" action="controlador?menu=editarEmpleado" method="POST">
                            <fieldset>
                                <div class="row">
                                    <legend class="text-center header">Actualizar Empleado</legend>


                                    <div class="form-group col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                                        <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-user bigicon"></i></span>                                     
                                        <div class="col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                                            <label>DNI</label>
                                            <input id="fname" name="txtDni" value="${empleado.dni}" type="text" placeholder="Digite el DNI" class="form-control">
                                        </div>
                                    </div>


                                    <div class="form-group col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                                        <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-user bigicon"></i></span>                                     
                                        <div class="col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                                            <label>Nombres</label>
                                            <input id="fname" name="txtNombres"  value="${empleado.nombres}" type="text" placeholder="Digite los Nombres" class="form-control">
                                        </div>
                                    </div>

                                    <div class="form-group col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                                        <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-user bigicon"></i></span>                                     
                                        <div class="col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                                            <label>Telefono</label>
                                            <input id="fname" name="txtTelefono" value="${empleado.telefono}" type="text" placeholder="Digite el Telefono" class="form-control">
                                        </div>
                                    </div>

                                    <div class="form-group col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                                        <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-user bigicon"></i></span>                                     
                                        <div class="col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                                            <label>Estado</label>
                                            <input id="fname" name="txtEstado" type="text" value="${empleado.estado}" placeholder="Digite el Estado" class="form-control">
                                        </div>
                                    </div>

                                    <div class="form-group col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                                        <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-user bigicon"></i></span>                                     
                                        <div class="col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                                            <label>Usuario</label>
                                            <input id="fname" name="txtUser" type="text" value="${empleado.user}" placeholder="Digite el Usuario" class="form-control">
                                        </div>
                                    </div>

                                    <div class="form-group col-lg-12 col-sm-12 col-xl-12 col-12 col-md-12">
                                        <div class="col-md-12 text-center">
                                            <button type="submit" class="btn btn-primary btn-lg">Actualizar</button>
                                        </div>
                                    </div>
                                </div>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>



        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script> 
    </body>
</html>
