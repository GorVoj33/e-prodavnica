<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%-- 
    Document   : form
    Created on : Jul 20, 2019, 6:34:07 PM
    Author     : Asus
--%>

<%@include file="/WEB-INF/views/pages/header.jsp"%>
<c:url var="kategorija_form"  value="${rootContext.request.contextPath}/admin/kategorija/add" />
<c:url var="kategorija_post"  value="${rootContext.request.contextPath}/admin/kategorija/add" />
<c:if test="${create == true}">
    <c:url var="post_url"  value="${rootContext.request.contextPath}/admin/artikal/add" />
</c:if>
<c:if test="${edit == true}">
    <c:url var="post_url"  value="${rootContext.request.contextPath}/admin/artikal/edit/${artikal.artikalId}" />
</c:if>
<section id="services">
    <div class="container-fluid">
        <div class="col-lg-8 col-lg-offset-2 text-center">
            <h1 class="section-heading">${nazivStrane}</h1>
            <p>Popunite sva polja.</p>
            
            <hr class="primary">
        </div>
    </div>
    <div class="container col-md-6 col-md-offset-3">
        <form:form action="${post_url}" method="post"  
                 commandName="artikal"
                 enctype="multipart/form-data">

            <div class="form-group">
                <label for="naziv">Naziv</label><br><form:errors path="naziv" cssStyle="color: red;" />
                <form:input path="naziv" id="naziv" cssClass="form-control" />
            </div>
            
            <div class="form-group">
                <label for="kategorija">Kategorija</label><br> 
                <form:select path="kategorija.kategorijaId" multiple="false">
                
                    <form:options items="${kategorije}" itemValue="kategorijaId" itemLabel="naziv"/>
                </form:select>
<!--                <a class="btn btn-primary" href="${kategorija_form}">Dodaj novu kategoriju</a>-->
                    
            </div>
     
            <div class="form-group">
                <label for="opis">Opis</label><br>
                <form:textarea path="opis" id="opis" cssClass="form-control" />
            </div>

            <div class="form-group">
                <label for="cenaBezPDV">Cena bez PDV</label><br><form:errors path="cenaBezPDV" cssStyle="color: red;" />
                <form:input path="cenaBezPDV" id="cenaBezPDV" cssClass="form-control" />
            </div>

            <div class="form-group">
                <label for="poreskaStopa">Poreska stopa</label><br>
                <form:select path="poreskaStopa.id" multiple="false">
                    <form:options items="${poreskeStope}" itemValue="id" itemLabel="naziv"/>
                </form:select>  
                <form:errors path="poreskaStopa" cssClass="form-control"/>   
            </div>
            
            <div class="form-group">
                <label for="kolicinaZaProdaju">Raspoloziva kolicina za prodaju (u komadima)</label><br><form:errors path="kolicinaZaProdaju" cssStyle="color: red;" />
                <form:input path="kolicinaZaProdaju" id="kolicinaZaProdaju" cssClass="form-control" />
            </div>

            <div class="form-group">
                <label for="image">Slika proizvoda</label><br><form:errors path="image" cssStyle="color: red;" />
                <form:input type="file" path="image" id="image" cssClass="form-control" />
            </div>
            <br>
            <c:if test="${create == true}">
                <div class="text-right">
                    <button type="button" data-toggle="modal" data-target="#kategorijaModal" class="btn btn-success btn-xs">
                        Kreiraj novu kategoriju
                    </button>
                </div>
            </c:if>
            <div class="col-lg-8 col-lg-offset-2 text-center">
                <input type="submit" value="Sacuvaj" class="btn btn-success" />
                
                <a href="<c:url value="/" />" class="btn btn-primary">Odustani</a>
            </div>
        </form:form>
    </div>
            

            <div class="modal fade" id="kategorijaModal" role="dialog" style="padding-top: 8%">
                <div class="modal-dialog" role="document">
                    <div class="modal-context">
                        <div class="modal-header">
                            <button class="close" type="button" data-dismiss="modal">
                                <span>&times;</span>
                            </button>
                            <h3 class="modal-title">Popunite sva polja</h3>
                            <hr class="primary">
                        </div>
                        
                        <div class="modal-body">
                            
                            <form:form action="${kategorija_post}" method="post"  modelAttribute="kategorija">

                                <div class="form-group">
                                    <label for="kategorija_naziv">Naziv</label><br><form:errors path="naziv" cssStyle="color: red;" />
                                    <form:input path="naziv" id="kategorija_naziv" type="text" cssClass="form-control" />
                                </div>

                                <div class="form-group">
                                    <label for="kategorija_opis">Opis</label><br><form:errors path="opis" cssStyle="color: red;" />
                                    <form:input path="opis" id="kategorija_opis" type="text" cssClass="form-control" />
                                </div>

                                <br>
                                <div class="col-lg-8 col-lg-offset-2 text-center">
                                    <input type="submit" value="Sacuvaj" class="btn btn-success" />
                                    
                                </div>
                            </form:form>
                            
                        </div>
                    </div>
                    
                </div>
                
            </div>
</section>



<div style="padding-bottom: 5%" />
<div class="clearfix"/></div>