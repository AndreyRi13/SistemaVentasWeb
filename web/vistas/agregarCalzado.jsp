<%-- 
    Document   : producto
    Created on : 2/07/2021, 2:28:11 p. m.
    Author     : Andrey R
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Calzado</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body>

        <div class="card">
            <div class="card-body">

                <div class="container">


                    <div class="well well-sm">
                        <form class="form-horizontal" action="calzadocontroller?menu=addCalzado" method="POST">
                            <fieldset>
                                <div class="row">
                                    <legend class="text-center header">Agregar Calzado</legend>


                                    <div class="form-group col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                                        <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-user bigicon"></i></span>                                     
                                        <div class="col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                                            <label>Referencia</label>
                                            <input id="fname" name="txtReferencia" type="number" placeholder="Digite la Referencia" pattern="[0-9]+" class="form-control"/>
                                        </div>
                                    </div>

                                    <div class="form-group col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                                        <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-user bigicon"></i></span>                                     
                                        <div class="col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                                            <label>Nombres</label>
                                            <input id="fname" name="txtNombres" type="text" placeholder="Digite los Nombres" class="form-control"/>
                                        </div>
                                    </div>

                                    <div class="form-group col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                                        <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-user bigicon"></i></span>                                     
                                        <div class="col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                                            <label>Descripción</label>
                                            <textarea id="fname" name="txtDescripcion" type="text" placeholder="Digite la Descripción" class="form-control"></textarea>
                                        </div>
                                    </div>

                                    <div class="form-group col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                                        <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-user bigicon"></i></span>                                     
                                        <div class="col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                                            <label>Marca</label>
                                            <input id="fname" name="txtMarca" type="text" placeholder="Digite la Marca" class="form-control"/>
                                        </div>
                                    </div>

                                    <div class="form-group col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                                        <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-user bigicon"></i></span>                                     
                                        <div class="col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                                            <label>Color del Zapato</label>
                                            <input type="color" name="txtColor" class="form-control form-control-color"  id="fname" value="#ff0000" title="Choose your color"/>                                      
                                        </div>
                                    </div>
                                    <div class="form-group col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                                        <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-user bigicon"></i></span>                                     
                                        <div class="col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                                            <label>Color de la suela</label>
                                            <input type="color" name="txtColorS" class="form-control form-control-color" id="fname" value="#ff0000" title="Choose your color"/>
                                        </div>
                                    </div>
                                    <div class="form-group col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                                        <span class="col-md-1 col-md-offset-3 text-center"><i class="fa fa-user bigicon"></i></span>                                     
                                        <div class="col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                                            <label>Precio</label>
                                            <input id="fname" name="txtPrecio" type="text" placeholder="Digite el Precio" class="form-control"/>
                                       
                                        </div>
                                        
                                    </div>

                                    <div class="form-group col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                                        <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-user bigicon"></i></span>                                     
                                        <div class="col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                                            <label>Stock</label>
                                            <input id="fname" name="txtStock" type="number" placeholder="Digite el Stock"  pattern="[0-9]+"  class="form-control"/>
                                        </div>
                                    </div>

                                    <div class="form-group col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                                        <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-user bigicon"></i></span>                                     
                                        <div class="col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                                            <label>Talla</label>
                                            <input id="fname" name="txtTalla" type="number" placeholder="Digite la Talla"  pattern="[0-9]+"  class="form-control"/>
                                        </div>
                                    </div>                                 <div class="form-group col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                                        <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-user bigicon"></i></span>                                     
                                        <div class="col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                                            <label>Estado</label>
                                            <input id="fname" name="txtEstado" type="text" placeholder="Digite el Estado" class="form-control"/>
                                        </div>
                                    </div>
                                    <br><br><br>
                                    <div class="form-group col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                                        <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-user bigicon"></i></span>                                     
                                        <div class="col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                                            <label>Selecciona una foto en formato PNG de tamaño inferior a 1MB.<br/></label>
                                            <input id="fname" type="file" name="txtFoto" accept="image/gif, image/jpeg, image/png image/svg image/jpg image/webp image/jfif" class="form-control"/>
                                        </div>
                                    </div>




                                    <div class="form-group col-lg-12 col-sm-12 col-xl-12 col-12 col-md-12">
                                        <div class="col-md-12 text-center">
                                            <button type="submit" class="btn btn-primary btn-lg">Agregar</button>
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
