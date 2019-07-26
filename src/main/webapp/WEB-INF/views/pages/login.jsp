 <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%-- 
    Document   : login
    Author     : Asus
--%>
<%@include file="/WEB-INF/views/pages/header.jsp"%>
<section id="portfolio">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12 text-center">
                <h2 class="section-heading">${pageHeading}</h2>
                <p>Unesite parametre koje ste uneli prilikom registracije.</p>
                <hr class="primary"><br>
            </div>
            <div class="container col-md-6 col-md-offset-3">
                
                <c:if test="${not empty userRegistered}">
                    <div class="msg alert-success">
                        <font size="5">${userRegistered}</font></div>
                </c:if>
                <c:if test="${not empty logoutSuccessMessage}">
                    <div class="msg alert-success">
                        <font size="5">${logoutSuccessMessage}</font></div>
                </c:if>

                <form name="loginForm" action="<c:url value="/j_spring_security_check" />" method="post">

                    <c:if test="${not empty error}">
                        <div class="error alert-danger">${error}</div>
                    </c:if>

                    <div class="form-group">
                        <label for="username">Korisnicko ime: </label>
                        <input type="text" id="username" name="username" class="form-control" />
                    </div>
                    <div class="form-group">
                        <label for="password">Lozinka: </label>
                        <input type="password" id="password" name="password" class="form-control" />
                    </div>

                        <input type="submit" value="Login" class="btn btn-success"
                                                 style="background-color:blue;margin:auto;display:block"/>

                    <input type="hidden" name="${_csrf_parameterName}" value="${_csrf.token}" />
                </form>
                <p align="right">
                    Nisam registrovan. <a href="<c:url value="${rootContext.request.contextPath}/register" />"><u>Registracija</u></a>
                </p>
            </div>
                    
        </div>
    </div>
</section>
