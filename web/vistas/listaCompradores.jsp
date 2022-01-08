<%-- 
    Document   : clientes
    Created on : 1/07/2021, 11:10:40 p. m.
    Author     : Andrey R
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Empleados</title>
        <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
        <script src="../js/administrar.js"></script>
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
                                    <th>CEDULA</th>
                                    <th>NOMBRES</th>
                                    <th>APELLIDOS</th>
                                    <th>DIRECCION</th>
                                    <th>CELULAR</th>
                                    <th>CORREO</th>
                                    <th>ESTADO</th>
                                    <th>ACCIONES</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="com" items="${compradores}">
                                    <tr>
                                        <td>${com.idComprador}</td>
                                        <td>${com.cedula}</td>
                                        <td>${com.nombres}</td>
                                        <td>${com.apellidos}</td>
                                        <td>${com.direccion}</td>
                                        <td>${com.numeroCelular}</td>
                                        <td>${emp.correoElectronico}</td>
                                        <td>${emp.estado}</td>
                                        <td>
                                            <a class="btn btn-warning" href="compradorcontroller?menu=editComprador&id=${com.idComprador}">Editar</a>
                                            <a class="btn btn-danger" href="compradorcontroller?menu=eliminarComprador&id=${com.idComprador}">Eliminar</a>
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
