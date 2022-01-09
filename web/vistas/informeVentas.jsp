<%-- 
    Document   : informeVentas
    Created on : 8/01/2022, 10:35:12 PM
    Author     : Andrey
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import = "java.awt.*"%>
<%@ page import = "java.io.*"%>
<%@ page import = "org.jfree.chart.*"%>
<%@ page import = "org.jfree.chart.entity.*"%>
<%@ page import = ".*Org.jfree.data.general"%>
<%@ page import= "org.jfree.chart.ChartFactory" %>
<%@ page import= "org.jfree.chart.ChartUtilities" %>
<%@ page import= "org.jfree.chart.JFreeChart" %>
<%@ page import= "java.io.File" %>
<%@ page import= "org.jfree.chart.plot.*" %>
<%@ page import= "java.io.*" %>
<%@ page import= "org.jfree.data.category.DefaultCategoryDataset" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Informe de Ventas</title>
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

                        <div class="m-2" style="height:606px;">

                          <%  // Create a simple Bar chart
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(5, "Compras", "Enero");
        dataset.setValue(7, "Compras", "Febrero");
        dataset.setValue(9, "Compras", "Marzo");
        dataset.setValue(5, "Compras", "Abril");
        dataset.setValue(10, "Compras", "Mayo");
        dataset.setValue(10, "Compras", "Junio");
        dataset.setValue(10, "Compras", "Julio");
        dataset.setValue(1, "Compras", "Agosto");
        dataset.setValue(2, "Compras", "Septiembre");
        dataset.setValue(10, "Compras", "Octubre");
        dataset.setValue(10, "Compras", "Noviembre");
        dataset.setValue(1, "Compras", "Diciembre");
        JFreeChart chart = ChartFactory.createBarChart("Llamadas Mensuales","2011", "Numero de Llamadas", dataset,PlotOrientation.VERTICAL, false,true, false);
 
        try {
            response.setContentType("image/png");
            OutputStream os = response.getOutputStream();
            ChartUtilities.writeChartAsPNG(os, chart, 625, 500);
 
 
        } catch (IOException e) {
            System.err.println("Error creando grafico.");
        }
%>
                            
                            
                            
                        </div>
                    </div>
                </div>
            </div>
            <script src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js"></script> 
            <script src="https://cdn.datatables.net/1.10.25/js/dataTables.bootstrap5.min.js"></script> 
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script> 
    </body>
</html>