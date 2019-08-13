<%-- 
    Document   : istorijaNarucivanja
    Created on : Aug 11, 2019, 6:06:38 PM
    Author     : Asus
--%>
<%@include file="/WEB-INF/views/pages/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<section id="portfolio">
    <div class="section-heading text-center">
        <h4>Sve vase narudzbenice</h4>
    </div>
    
    <c:if test="${fn:length(sveNarudzbenice) eq 0}">
        <div class="alert-info">U bazi nema unetih narudzbenica</div>
        
    </c:if>
    
    <div class="container">
        <div class="row">
    <c:forEach items="${sveNarudzbenice}" var="n">
        <div class="bg-info text-center">
            <p>Datum: ${n.datum}</p>
            
            Stavke:
            
             
            <c:forEach items="${n.stavke}" var="sn">

                <p>Naziv artikla: ${sn.artikal.naziv} &emsp;
                Kolicina:${sn.kolicina} &emsp;
                Cena stavke: ${sn.ukupnaCenaStavke} din.</p>
                <p></p>

            </c:forEach>
            </div>
          <div class="bg-primary text-right">
                Ukupna vrednost: ${n.ukupno}
          </div>
          
          <hr class="primary">
    </c:forEach>
          
        </div>
    </div>
          
    
</section>