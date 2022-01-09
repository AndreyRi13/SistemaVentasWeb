<%-- 
    Document   : editarVenta
    Created on : 9/01/2022, 01:54:06 PM
    Author     : Andrey
--%>

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
        <title>Actualizar Venta</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body>

        <div class="card">
            <div class="card-body">
                <div class="container">
                    <div class="well well-sm">
                        <form class="form-horizontal" action="comprascontroller?a=editarVenta" method="POST">
                            <fieldset>
                                <div class="row">
                                    <legend class="text-center header" id="title_ventana">ACTUALIZAR VENTA</legend>
                                    <br><br><br>
                                    <div class="form-group col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                                        <input id="fname" name="txtCodigo" value="${venta.codigo}" type="number"  class="form-control" disabled>
                                    </div>
                                    <br><br>
                                    <div class="form-group col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                                        <input id="fname"  name="txtFechaCompra" value="${venta.fechaCompra}" type="text"  class="form-control" disabled>
                                    </div>
                                    <br><br>
                                    <div class="form-group col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                                        <input id="fname" name="txtPrecioTotal" value="${venta.precioTotal}" type="number" class="form-control" disabled>
                                    </div>
                                    <br><br>
                                    <div class="form-group col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                                        <input id="fname" name="txtIdComprador" value="${venta.idComprador}" type="number" class="form-control" disabled>
                                    </div>
                                    
                                   
                                    <br><br>
                 
                                    <div class="form-group col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">

                                        <select class="form-select" name="txtEstado" id="fname">
                                            <option selected disabled>Estado de la venta</option>
                                            <option value="Pendiente">Pendiente</option>
                                            <option value="Exitosa">Exitosa</option>                                    
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
