
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%-- 
    Document   : register
    Created on : Jul 12, 2019, 10:11:28 PM
    Author     : Asus
--%>



<%@include file="/WEB-INF/views/pages/header.jsp"%>
<section id="services">
    <div class="container-fluid">
        <div class="col-lg-8 col-lg-offset-2 text-center">
            <h1 class="section-heading">Registracija</h1>
            <p>Popunite sva polja.</p>
            <hr class="primary">
        </div>
    </div>
    <div class="container col-md-6 col-md-offset-3">
        <c:choose>
            <c:when test="${not empty registrationFailedMassage}">
                <div class="error-populate-fields">${registrationFailedMessage}</div>
            </c:when>
                
            <c:otherwise>
                <div class="error-populate-fields" hidden><!--Injected via js--></div>
            </c:otherwise>
        </c:choose>
        <form:form id="formRegister" action="${pageContext.request.contextPath}/register" method="post"
                   commandName="profil">

            <h3 class="section-heading">Osnovno o korisniku:</h3>

            <div class="form-group">
                <label for="ime">Ime</label><form:errors path="ime" cssStyle="color: red" />
                <form:input path="ime" id="ime" cssClass="form-control" />
                
            </div>
            
            <div class="form-group">
                <label for="prezime">Prezime</label><form:errors path="prezime" cssStyle="color: red" />
                <form:input path="prezime" id="prezime" cssClass="form-control" />
                
            </div>

            <div class="form-group">
                <label for="kontakt">Kontakt telefon</label><form:errors path="kontakt" cssStyle="color: red" />
                <form:input path="kontakt" id="kontakt" cssClass="form-control" />
                <span id="kontakt_error_msg"></span>
            </div>

            <div class="form-group">
                <label for="username">Username(mozete uneti vas email)</label><span style="color: red;">${usernameMsg}</span><form:errors path="username" cssStyle="color: red" />
                <form:input path="username" id="username" cssClass="form-control" />
                <span id="username_error_msg" ></span>
            </div>

            <div class="form-group">
                <label for="password">Password</label><form:errors path="password" cssStyle="color: red" />
                <form:password path="password" id="password" cssClass="form-control" />
                <span id="password_error_msg"></span>
            </div><br>
            
            <div class="form-group">
                <label>Ponovite password</label><br>
                
                <input id="re_password" class="form-control" type="password"/>
                <span id="re_password_error_msg"></span>
            </div><br>

            <h3 class="section-heading">Adresa (Pri kreiranju narudzbine mozete uneti neku drugu)!</h3>

            <div class="form-group">
                <label for="adresa">Adresa</label><form:errors path="adresaIsporuke.adresa" cssStyle="color: red" />
                <form:input path="adresaIsporuke.adresa" id="adresa" cssClass="form-control" />
                <span id="adresa_error_msg"></span>
            </div>

            <div class="form-group">
                <label for="grad">Grad</label><form:errors path="adresaIsporuke.adresa" cssStyle="color: red" />
                <form:input path="adresaIsporuke.grad" id="grad" cssClass="form-control" />
            </div>

            <div class="form-group">
                <label for="postanskiKod">Postanski kod</label><form:errors path="adresaIsporuke.postanskiKod" cssStyle="color: red" />
                <form:input path="adresaIsporuke.postanskiKod" id="postanskiKod" cssClass="form-control" />
                <span id="kod_error_msg"></span>
            </div><br>

            

            <br>
            <div class="col-lg-8 col-lg-offset-2 text-center">
                <input id="registerMe" type="submit" value="Registruj me" class="btn btn-success" />
                <a href="<c:url value="/" />" class="btn btn-primary">Cancel</a>
            </div>
        </form:form>
    </div>

</section>
<div style="padding-bottom: 5%" />
<div class="clearfix"/></div>

