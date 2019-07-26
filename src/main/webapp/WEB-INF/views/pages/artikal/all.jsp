<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="/WEB-INF/views/pages/header.jsp"%>
<c:url var="pretraga_url" value="${rootContext.request.contextPath}/artikal/pretrazi" />
<%-- 
    Document   : all
    Created on : Jul 15, 2019, 3:50:57 PM
    Author     : Asus
--%>


<section id="services">
    <div class="container-fluid">
        <div class="col-lg-8 col-lg-offset-2 text-center">
            <h1 class="section-heading">${nazivStrane}</h1>
            

        </div>
    </div>
    <c:if test="${not empty message}">
        <div class="alert alert-success">
            ${message}
        </div>
        
    </c:if>
    <div class="container-fluid">        
    <div class="col-lg-8 col-lg-offset-2 text-center">
        <form action="${pretraga_url}" method="get">
                <label for="deoNaziva">Unesite deo naziva artikla:</label> 
                <input type="text" name="deoNaziva" id="deoNaziva" />
                <input type="submit" value="Pretrazi"/>     
        </form>
    </div>
    </div>
    <hr class="primary"><br>
    <div class="container-fluid" >
        
        <div class="row no-gutter">
            
            <c:if test="${fn:length(artikli) eq 0}">
                Ne postoje trazeni artikli.
            </c:if>
            <c:forEach items="${artikli}" var="artikal">
                <div class="col-lg-4 col-sm-6">
                    <h3 align="center"> ${artikal.naziv}</h3>
                    <h6 align="center"><a href="<c:url value="${rootContext.request.contextPath}/artikal/all/${artikal.kategorija.kategorijaId}" />">${artikal.kategorija.naziv}</a></h6>
                    <a href="<c:url value="${rootContext.request.contextPath}/artikal/${artikal.artikalId}" />" class="portfolio-box">
                        <img src="<c:url value="/resources/img/${artikal.artikalId}.png" />" height="300" width="300" class="img-responsive" alt="Neuspelo ucitavanje slike">
                        <div class="portfolio-box-caption">
                            <div class="portfolio-box-caption-content">
<!--                                <div class="project-name text-center">
                                        Cena sa PDV: ${artikal.cenaSaPDV} din.
                                </div>-->
                            </div>
                        </div>
                               
                    </a>
                        <div class="project-name text-center">
                            Cena sa PDV: ${artikal.cenaSaPDV} din.
                        </div>
                </div>
            </c:forEach>
            
            
        </div>
           
    </div>
    <br><br><br>

</section>
    
    
