<%-- 
    Document   : detail
    Created on : Jul 15, 2019, 4:59:40 PM
    Author     : Asus
--%>
<%@include file="/WEB-INF/views/pages/header.jsp"%>
<section id="services">
    <div class="container-fluid">
        <div class="col-lg-8 col-lg-offset-2 text-center">
            <h1 class="section-heading text-center">${artikal.naziv}</h1>
            <hr class="primary">
        </div>
    </div>
    <div class="container" data-ng-app = "cartApp">
        <div class="col-md-5">
            <div class="row no-gutter popup-gallery">
                <a href="<c:url value="/resources/img/${artikal.artikalId}.png" />" class="portfolio-box">
                    <img src="<c:url value="/resources/img/${artikal.artikalId}.png" />" height="300" width="300" class="img-responsive" alt="">
                    <div class="portfolio-box-caption">
                        <div class="portfolio-box-caption-content">
                            <div class="project-category text-faded">
                                ${artikal.kategorija.naziv}
                            </div>
                            <div class="project-name">
                                ${artikal.naziv}
                            </div>
                        </div>
                    </div>
                </a>
            </div>

        </div>

        <div class="col-md-5 col-md-offset-1">
            <h3>${artikal.naziv}</h3>
            <p>Opis: ${artikal.opis}</p>
            <c:if test="${artikal.kolicinaZaProdaju > 0}">
                <p>Cena bez PDV: ${artikal.cenaBezPDV} din.</p>
                <p>Poreska stopa (${artikal.poreskaStopa.naziv}): ${artikal.poreskaStopa.vrednost} % po vazecem zakonu</p>
                <h4>Dostupna kolicina: ${artikal.kolicinaZaProdaju } komada</h4>
                <h2>Cena sa PDV: <strong>${artikal.cenaSaPDV } din.</strong></h2>
            </c:if>
            <c:if test="${artikal.kolicinaZaProdaju == 0}">
                <div class="alert-info">
                    Nema na stanju.
                </div>
            </c:if>
            <br>
 
            
            <c:if test="${pageContext.request.userPrincipal.name == null}">
            <div class="alert-info" ><b>Morate se ulogovati/registrovati kako bi mogli da porucite artikal!</b></div>    
            </c:if>    
            <br>
            <br>
            <c:if test="${pageContext.request.userPrincipal.name !=null}">
                <a href="<c:url value="${rootContext.request.contextPath}/artikal/all" />" class="btn btn-info" >Nazad</a>
                
                <c:if test="${artikal.kolicinaZaProdaju > 0}">
                    <a href="<c:url value="${rootContext.request.contextPath}/korpa/artikal/add/${artikal.artikalId}" />" class="btn btn-warning btn-lg">
                        <span class="glyphicon glyphicon-shopping-cart"></span> Dodaj u korpu
                    </a>
                </c:if>

            </c:if>
                <br><br>
            
            <!--</p>-->
        </div>
            
    </div>

</section>
    <div style="padding-top: 10%" />
    <div class="clearfix"/></div>
    <div class="header-content text-center"><font size="4">
        Pogledajte i ostale artikle iz kategorije <u>${artikal.kategorija.naziv}</u>
        </font>
    </div>
    <hr class="primary">
    
    <div class="container-fluid" >
        
        <div class="row no-gutter">
            <c:forEach items="${artikal.kategorija.artikli}" var="art">
                <c:if test="${!(art.artikalId eq artikal.artikalId)}">
                <div class="col-lg-4 col-sm-6">
                    <h3> ${art.naziv}</h3>
                    
                    <a href="<c:url value="${rootContext.request.contextPath}/artikal/${art.artikalId}" />" class="portfolio-box">
                        <img src="<c:url value="/resources/img/${art.artikalId}.png" />" height="300" width="300" class="img-responsive" alt="Neuspelo ucitavanje slike">
                        <div class="portfolio-box-caption">
                            <div class="portfolio-box-caption-content">
<!--                                <div class="project-name text-center">
                                        Cena sa PDV: ${art.cenaSaPDV} din.
                                </div>-->
                            </div>
                        </div>
                               
                    </a>
                    
                        <div class="project-name text-center">
                            Cena sa PDV: ${art.cenaSaPDV} din.
                        </div>
                </div>
                  </c:if>
            </c:forEach>
        </div>
           
    </div>
<div style="padding-bottom: 5%" />