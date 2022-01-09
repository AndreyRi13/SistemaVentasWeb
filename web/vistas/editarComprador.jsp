<%-- 
    Document   : editarComprador
    Created on : 15/07/2021, 2:54:45 p. m.
    Author     : Andrey R
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar comprador</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body>

        <div class="card">
            <div class="card-body">

                <div class="container">


                    <div class="well well-sm">
                        <form class="form-horizontal" action="compradorcontroller?menu=editarComprador" method="POST">

                            <fieldset>
                                <div class="row">
                                    <legend class="text-center header">Actualizar comprador</legend>
                                    <br><br><br>
                                    <div class="form-group col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">                                          
                                        <input id="fname" name="txtCedula" value="${comprador.cedula}" type="text" placeholder="Cedula" class="form-control">
                                    </div>                                  
                                    <br><br>
                                    <div class="form-group col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                                        <input id="fname" name="txtNombres" value="${comprador.nombres}" type="text" placeholder="Nombres" class="form-control">
                                    </div>                                        
                                    <br><br>
                                    <div class="form-group col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                                        <input id="fname" name="txtApellidos" value="${comprador.apellidos}" type="text" placeholder="Apellidos" class="form-control">
                                    </div>                                      
                                    <br><br>
                                    <div class="form-group col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                                        <input id="fname" name="txtUsername" value="${comprador.username}" type="text" placeholder="Username" class="form-control">
                                    </div>                                
                                    <br><br>
                                    <div class="form-group col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                                        <input id="fname" name="txtPassword" type="text" value="${comprador.password}" placeholder="Password" class="form-control">
                                    </div>                                      
                                    <br><br>
                                    <div class="form-group col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                                        <input id="fname" name="txtDireccion" type="text" value="${comprador.direccion}" placeholder="Direccion" class="form-control">
                                    </div>                                      
                                    <br><br>
                                    <div class="form-group col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                                        <input id="fname" name="txtNumeroCelular" value="${comprador.numeroCelular}" type="text" placeholder="Numero de Celular" class="form-control">
                                    </div>
                                    <br><br>
                                    <div class="form-group col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                                        <input id="fname" name="txtCorreoElectronico" value="${comprador.correoElectronico}" type="text" placeholder="Correo Electronico" class="form-control">
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
