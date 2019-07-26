<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/pages/transparentHeader.jsp"%>
<%-- 
    Document   : home
    Author     : Asus
--%>

<style>
    .overlay{
       position: relative;
    }
    .overlay h4{
        position: absolute;
        top: 70%;
        left: 50%;
        transform: translate(-50%, -50%);
        padding-top: 20px;
        padding-bottom: 10px;
        border-radius: 8px;
        margin: 0;
        font-family: fantasy;
        font-size: 2em;
        mix-blend-mode: multiply;
        box-shadow: 0 0 16px #000, 0 0 32px #000;
        opacity: 0.9;
    }
    
</style>
<header>
    <div class="header-content">
        <div class="header-content-inner">
            <h1 id="homeHeading"><font face="fantasy">DOBRODOSLI</font></h1>
            <hr>
                <br>
                <div class="overlay">
                <h4><font color="white">
                Ovo je sajt za prodaju namestaja i pratece opreme, mozete gledati artikle iz nase ponude, a da biste porucili potrebno je samo da se registrujete!
                </font></h4>
            
                </div>
            </div>
   </div>     
    
</header>

<section class="bg-primary" id="about">
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2 text-center">
                <h2 class="section-heading">Vise o nama!</h2>
                <hr class="light">
                
                <p class="text-faded">
                    Ovaj sajt se bavi prodajom namestaja i pratece opreme. Potrebno je da se registrujete kako biste mogli da napravite narudzbenicu!
                    
                </p>
                
                <a href="<c:url value="/artikal/all/"/>" class="page-scroll btn btn-default btn-xl sr-button"> Pogledajte asortiman </a>
        </div>
    </div>
</section>
