<%-- 
    Document   : hello
    Author     : Asus
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="author" content="gv">

    <title>E-prodavnica</title>

    <!-- jQuery -->
    <script src="<c:url value="/resources/vendor/jquery/jquery.min.js" />"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.min.js" />"></script>

    <!--Angular JS-->

    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>

    <!-- Bootstrap Core CSS -->
    <link href="<c:url value="/resources/vendor/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="<c:url value="/resources/vendor/font-awesome/css/font-awesome.min.css" />" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>

    <!-- Plugin CSS -->
    <link href="<c:url value="/resources/vendor/magnific-popup/magnific-popup.css" />" rel="stylesheet">

    <!-- Theme CSS -->
    <link href="<c:url value="/resources/css/creative.min.css" />" rel="stylesheet">

    <!-- Table CSS -->
    <link href="<c:url value="/resources/css/tableStyle.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/custom.css" />" rel="stylesheet">


</head>

<body id="page-top">

<nav id="mainNav" class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span> Menu <i class="fa fa-bars"></i>
            </button>
            <a class="navbar-brand page-scroll" href="#page-top">E-prodavnica</a>
        </div>

        
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a class="page-scroll" href="<c:url value="/" />#about">O nama</a>
                </li>
                <li>
                    <a class="page-scroll" href="<c:url value="/artikal/all"/>">Artikli</a>
                </li>
                <c:if test="${pageContext.request.userPrincipal.name !=null}">
                    <li><a>Ulogovan: ${pageContext.request.userPrincipal.name}</a></li>
                    <li><a href="<c:url value="/j_spring_security_logout" />">Logout</a></li>
                    <li><a href="<c:url value="/korpa" />"><span class="glyphicon glyphicon-shopping-cart fa-2x"></span></a></li>
                    <li><a href="<c:url value="/narudzbenica/logged/all" />">Moje narudzbenice</a></li>
                    <li><a href="<c:url value="/admin/" />">Administracija</a></li>
                </c:if>
                <c:if test="${pageContext.request.userPrincipal.name == null}">
                    <li>
                        <a class="page-scroll" href="<c:url value="/login" />">Login</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="<c:url value="/register"/>">Registracija</a>
                    </li>
                </c:if>
            </ul>
        </div>
        
    </div>
    
</nav>