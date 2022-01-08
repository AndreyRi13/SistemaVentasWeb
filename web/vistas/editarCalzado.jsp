<%-- 
    Document   : editarProducto
    Created on : 5/07/2021, 11:55:16 p. m.
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
                        <form class="form-horizontal" action="calzadocontroller?menu=editarCalzado" method="POST">
                            <div class="row" style="align-items: center;">
                                <legend class="text-center header" id="title_ventana">AGREGAR CALZADO</legend>

                                <div class="form-group col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">

                                    <input id="fname" name="txtReferencia" type="number" placeholder="Referencia" pattern="[0-9]+" class="form-control"/>

                                </div>
                                <br><br><br>

                                <div class="form-group col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">

                                    <input id="fname" name="txtNombres" type="text" placeholder="Nombre" class="form-control"/>

                                </div>
                                <br><br><br>

                                <div class="form-group col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">

                                    <input id="fname" name="txtModelo" type="text" placeholder="Modelo" class="form-control"/>

                                </div>
                                <br><br><br>

                                <div class="form-group col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">



                                    <input id="fname" name="txtPrecio" type="text" placeholder="Precio" class="form-control"/>



                                </div>
                                <br><br><br>
                                <div class="form-group col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                                    <input id="fname" name="txtStock" type="number" placeholder="Stock"  pattern="[0-9]+"  class="form-control"/>
                                </div>
                                <br><br><br>
                                <div class="form-group col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                                    <input id="fname" name="txtTalla" type="number" placeholder="Talla"  pattern="[0-9]+"  class="form-control"/>
                                </div>                                 
                                <br><br><br>                     
                                <div class="form-group col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                                    <div class="row">
                                        <div class="form-group col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6"> 
                                            <p>Color del calzado</p>
                                        </div> 
                                        <div class="form-group col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6"> 
                                            <input type="color" name="txtColor" class="form-control form-control-color"  id="fname" value="#FFFFFF" title="Color del zapato"/>                                                                             
                                        </div> 
                                    </div> 
                                </div>
                                <br><br><br>
                                <div class="form-group col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                                    <div class="row"">
                                        <div class="form-group col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6"> 
                                            <p>Color de la suela</p> 
                                        </div>
                                        <div class="form-group col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6"> 
                                            <input type="color" name="txtColorS" class="form-control form-control-color" id="fname" value="#FFFFFF" title="Color de la suela"/>
                                        </div>    
                                    </div>    
                                </div>
                                <br><br><br>

                                <div class="form-group col-lg-4 col-sm-4 col-xl-4 col-4 col-md-4">
                                    <textarea id="fname" name="txtDescripcion" type="text" placeholder="Descripción" class="form-control"></textarea>
                                </div>
                                <br><br><br>
                                <div class="form-group col-lg-4 col-sm-4 col-xl-4 col-4 col-md-4">                                
                                    <select class="form-select" name="txtEstado" id="fname">
                                        <option selected disabled>Estado del calzado</option>
                                        <option value="Disponible">Disponible</option>
                                        <option value="NoDisponible">No disponible</option>                                    
                                    </select>
                                </div>                         
                                <br><br><br>
                                <div class="form-group col-lg-4 col-sm-4 col-xl-4 col-4 col-md-4">                               
                                    <label>Selecciona una foto en formato PNG de tamaño inferior a 1MB.<br/></label>
                                    <input id="fname" type="file" name="txtFoto" accept="image/gif, image/jpeg, image/png image/svg image/jpg image/webp image/jfif" class="form-control"/>                           
                                </div>
                                <br><br><br> <br><br><br><br><br>
                                <div class="form-group col-lg-12 col-sm-12 col-xl-12 col-12 col-md-12">
                                    <div class="col-md-12 text-center">
                                        <button type="submit" class="btn btn-primary btn-lg">Guardar</button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>



        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script> 
    </body>
</html>
