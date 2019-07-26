<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%-- 
    Document   : uspesnoPoruceno
    Author     : Asus
--%>

<%@include file="/WEB-INF/views/pages/header.jsp"%>
<section id="portfolio">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12 text-center">
                <font color="green">Vasa narudzbenica je uspesno obradjena.</font>
            </div>
        </div>
    </div>
    
    <div class="container col-md-6 col-md-offset-3">
        <h3 class="section-heading">Adresa isporuke</h3>
            
            <div class="form-group">
                <label for="adresa">Adresa</label>
                <form:input path="narudzbenica.profil.adresaIsporuke.adresa" id="adresa" cssClass="form-control" disabled="true" />
            </div>

            <div class="form-group">
                <label for="grad">Grad</label>
                <form:input path="narudzbenica.profil.adresaIsporuke.grad" id="grad" cssClass="form-control" disabled="true" />
            </div>

            <div class="form-group">
                <label for="postanskiKod">Postanski kod</label>
                <form:input path="narudzbenica.profil.adresaIsporuke.postanskiKod" id="postanskiKod" cssClass="form-control" disabled="true" />
            </div><br>
        
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
        <h4>${narudzbenica.datum}</h4>
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
                                            <c:forEach items="${narudzbenica.stavke}" var="s">
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
							<td class="text-center"><strong>Ukupno: ${narudzbenica.ukupno} din</strong></td>
						</tr>
						<tr>
							<td></td>
							<td colspan="2" class="hidden-xs"></td>
							<td class="hidden-xs text-center"><strong>Ukupno: ${narudzbenica.ukupno} din</strong></td>
                                                        <td/>
                                                </tr>
                                                
					</tfoot>
				</table>
                    </div>
  
</section>
