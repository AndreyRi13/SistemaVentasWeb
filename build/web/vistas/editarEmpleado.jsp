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
                        <form class="form-horizontal" action="empleadocontroller?menu=editarEmpleado" method="POST">
                            <fieldset>
                                <div class="row">
                                    <legend class="text-center header" id="title_ventana">ACTUALIZAR EMPLEADO</legend>
                                    <br><br><br>
                                    <div class="form-group col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                                        <input id="fname" name="txtCedula" value="${empleado.cedula}" type="text" placeholder="Cedula" class="form-control">
                                    </div>
                                    <br><br>
                                    <div class="form-group col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                                        <input id="fname" name="txtNombres" value="${empleado.nombres}" type="text" placeholder="Nombres" class="form-control">
                                    </div>
                                    <br><br>
                                    <div class="form-group col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                                        <input id="fname" name="txtApellidos" value="${empleado.apellidos}" type="text" placeholder="Apellidos" class="form-control">
                                    </div>
                                    <br><br>
                                    <div class="form-group col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                                        <input id="fname" name="txtUsername" value="${empleado.username}" type="text" placeholder="Username" class="form-control">
                                    </div>
                                    <br><br>
                                    <div class="form-group col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                                        <input id="fname" name="txtPassword" type="text" value="${empleado.password}" placeholder="Password" class="form-control">
                                    </div>
                                    <br><br>

                                    <div class="form-group col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                                        <input id="fname" name="txtDireccion" type="text" value="${empleado.direccion}" placeholder="Direccion" class="form-control">
                                    </div>

                                    <br><br>
                                    <div class="form-group col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                                        <input id="fname" name="txtNumeroCelular" value="${empleado.numeroCelular}" type="text" placeholder="Numero de Celular" class="form-control">
                                    </div>

                                    <br><br>


                                    <div class="form-group col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                                        <input id="fname" name="txtCorreoElectronico" value="${empleado.correoElectronico}" type="text" placeholder="Correo Electronico" class="form-control">
                                    </div>
                                    <br><br>


                                    <div class="form-group col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">

                                        <select class="form-select" name="txtEstado" id="fname">
                                            <option selected disabled>Estado del empleado</option>
                                            <option value="Habilitado">Habilitado</option>
                                            <option value="Deshabilitado">Deshabilitado</option>                                    
                                        </select>
                                    </div>
                                    <br><br><br><br><br>
                                    <div class="form-group col-lg-12 col-sm-12 col-xl-12 col-12 col-md-12">
                                        <div class="col-md-12 text-center">
                                            <button type="submit" class="btn btn-primary btn-lg">Guardar</button>
                                        </div>
                                    </div>
                                </div>
                            </fieldset>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>


        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script> 
    </body>
</html>
