<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%-- 
    Document   : narudzbanica
    Created on : Jul 23, 2019, 10:17:28 PM
    Author     : Asus
--%>

<%@include file="header.jsp" %>

<section id="services">
   
    
    <div class="container col-md-6 col-md-offset-3">
        <h3 class="section-heading">Adresa isporuke</h3>
        <form:form modelAttribute="adresaFORM" id="formAdresaNarudzbenice" action="${pageContext.request.contextPath}/narudzbenica/kreiraj/${narudzbenica.korpa.korpaId}" method="post">
            <div class="form-group">
                <label for="adresaFORM.adresa">Adresa</label><form:errors path="adresa" cssStyle="color: red" />
                <form:input path="adresa" id="adresaFORM.adresa" cssClass="form-control" />
            </div>

            <div class="form-group">
                <label for="adresaFORM.grad">Grad</label><form:errors path="grad" cssStyle="color: red" />
                <form:input path="grad" id="adresaFORM.grad" cssClass="form-control" />
            </div>

            <div class="form-group">
                <label for="adresaFORM.postanskiKod">Postanski kod</label><form:errors path="postanskiKod" cssStyle="color: red" />
                <form:input path="postanskiKod" id="adresaFORM.postanskiKod" cssClass="form-control" />
            </div><br>
            <input type="submit" class="btn btn-success" value="Sacuvaj adresu" />
            </form:form>
        
    </div>
            
    
    <div class="container col-md-6 col-md-offset-3">
        <h3 class="section-heading">Osnovne informacije o kupcu </h3>
           
        <div class="form-group">
                <label for="narudzbanica.profil.ime">Ime</label>
                <form:input path="narudzbenica.profil.ime" id="ime" cssClass="form-control" disabled="true"/>
            </div>
            
            <div class="form-group">
                <label for="prezime">Prezime</label>
                <form:input path="narudzbenica.profil.prezime" id="prezime" cssClass="form-control" disabled="true"/>
            </div>

            <div class="form-group">
                <label for="kontakt">Kontakt telefon</label>
                <form:input path="narudzbenica.profil.kontakt" id="kontakt" cssClass="form-control" disabled="true"/>
            </div>
    </div>
    
    <div class="container col-md-6 col-md-offset-3">
        <h3 class="section-heading">Datum kreiranja<br></h3>
        <h4>${datum}</h4>
        <br><br>
    </div>        
            
    <div class="container col-md-6 col-md-offset-3">
        <h3 class="section-heading">Stanje artikala u korpi</h3>
    </div>
            <div class="container">
                <table id="cart" class="table table-hover table-condensed">
    				<thead>
						<tr>
							<th style="width:40%">Artikal</th>
							<th style="width:20%">Cena sa PDV</th>
                                                        <th style="width:20%">Porucena kolicina</th>
                                                        <th style="width:20%"><b>Cena stavke</b></th>

						</tr>
					</thead>
					<tbody>
                                            <c:forEach items="${narudzbenica.korpa.stavke}" var="s">
                                                <tr> 
                                                
                                                
                                                <td data-th="Artikal">
								<div class="row">
                                                                    <div class="jumbotron"><img src="<c:url value="/resources/img/${s.artikal.artikalId}.png" />" height="400"  width="400" alt="" class="img-responsive"/></div>
									<div class="col-sm-10">
										<h4 class="nomargin">${s.artikal.naziv}</h4>
										<p>${s.artikal.opis}</p>
									</div>
								</div>
							</td>
                                                        <td data-th="CenaSaPDV"><b>${s.artikal.cenaSaPDV} din.</b></td>
                                                        <td data-th="TrenutnoUKorpi"><b>${s.kolicina} kom.</b></td>
                                                        <td data-th="CenaStavke" class="text-center"><b>${s.ukupnaCenaStavke} din.</b></td>
							
						</tr>
                                            </c:forEach>
						
							
					</tbody>
					<tfoot>
						<tr class="visible-xs">
							<td class="text-center"><strong>Ukupno: ${narudzbenica.korpa.ukupnaCenaKorpe} din</strong></td>
						</tr>
						<tr>
							<td></td>
							<td colspan="2" class="hidden-xs"></td>
							<td class="hidden-xs text-center"><strong>Ukupno: ${narudzbenica.korpa.ukupnaCenaKorpe} din</strong></td>
                                                        <td/>
                                                </tr>
                                                <tr>
                                                    <c:url var="nazad_url" value="${rootContext.request.contextPath}/korpa/" />
                                                    <td><a href="${nazad_url}" class="btn btn-warning"><span class="glyphicon glyphicon-chevron-left"></span> Nazad na korpu</a></td>
                                                    <td/><td/>
                                                        <c:url var="narudzbenica_url" value="${rootContext.request.contextPath}/narudzbenica/new/${narudzbenica.korpa.korpaId}/potvrdi" />
							<td><a href="${narudzbenica_url}" class="btn btn-success btn-block">Napravi narudzbinu<span class="glyphicon glyphicon-chevron-right"></span></a></td>
                                                        <td/>
                                                </tr>
					</tfoot>
				</table>
                    </div> 
        
</section>
