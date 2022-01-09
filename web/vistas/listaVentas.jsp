<%-- 
    Document   : listaVentas
    Created on : 8/01/2022, 09:35:39 PM
    Author     : Andrey
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Ventas</title>
        <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
        <script src="../js/administrar.js" type="text/javascript"></script>
        <link href="https://cdn.datatables.net/1.10.25/css/jquery.dataTables.min.css" rel="stylesheet" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="icon" href="../images/fevicon.png" type="image/gif" />
    </head>
    <body>

        <div class="card">
            <div class="card-body">

                <div class="container">


                    <div class="well well-sm">

                        <table id="listEmpleados" class="table table-striped" style="width:100%">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>CODIGO</th>
                                    <th>FECHA COMPRA</th>
                                    <th>TOTAL</th>
                                    <th>ESTADO</th>                               
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="venta" items="${ventas}">
                                    <tr>
                                        <td>${venta.idCompra}</td>
                                        <td>${venta.codigo}</td>
                                        <td>${venta.fechaCompra}</td>
                                        <td>${venta.precioTotal}</td>
                                        <td>${venta.estado}</td>                                     

                                        <td>
                                            <a class="btn btn-warning" href="comprascontroller?a=editCompra&id=${venta.idCompra}">Editar</a>
                                         
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>

                    </div>

                </div>
            </div>
        </div>
        <script src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js"></script> 
        <script src="https://cdn.datatables.net/1.10.25/js/dataTables.bootstrap5.min.js"></script> 
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script> 
    </body>
</html>
