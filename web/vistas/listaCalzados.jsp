<%-- 
    Document   : listaProductos
    Created on : 5/07/2021, 5:05:52 p. m.
    Author     : Andrey R
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Productos</title>
        <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
        <script src="../js/administrar.js"></script>
        <link href="https://cdn.datatables.net/1.10.25/css/jquery.dataTables.min.css" rel="stylesheet" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
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
                                    <th>REFERENCIA</th>
                                    <th>NOMBRES</th>
                                    <th>DESCRIPCION</th>
                                    <th>MARCA</th>
                                    <th>COLOR</th>
                                    <th>PRECIO</th>
                                    <th>STOCK</th>
                                    <th>ESTADO</th>
                                    <th>FOTO</th>
                                    <th>ACCIONES</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="pro" items="${calzados}">
                                    <tr>
                                        <td>${pro.idCalzado}</td>
                                        <td>${pro.referencia}</td>
                                        <td>${pro.nombres}</td>
                                        <td>${pro.descripcion}</td>
                                        <td>${pro.marca}</td>
                                        <td>${pro.color}</td>
                                        <td>${pro.precio}</td>
                                        <td>${pro.stock}</td>
                                        <td>${pro.estado}</td>
                                        <td> <img src="../images/${pro.foto}" alt="Foto ${pro.foto}" style="width: 60px; height: 60px;" /> </td>
                                        <td>                                          
                                            <a class="btn btn-warning" href="calzadocontroller?menu=editCalzado&id=${pro.idCalzado}">Editar</a>                                           
                                            <a class="btn btn-danger"  href="calzadocontroller?menu=eliminarCalzado&id=${pro.idCalzado}">Eliminar</a>
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
