<!--<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>-->
<!------ Include the above in your HEAD tag ---------->
<%@include file="../header.jsp" %>
<c:url var="lista_artikala" value="${rootContext.request.contextPath}/artikal/all" />


<!--<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">-->
<section id="services">
    <div class="container col-md-6 col-md-offset-3">
                <c:if test="${not empty message}">
                                <div class="msg alert-success">
                                <font size="5">${message}</font></div>
                </c:if>
              
    </div>
    <c:choose>
        <c:when test="${not empty stavke}">
            
            <div class="container">
                <table id="cart" class="table table-hover table-condensed">
    				<thead>
						<tr>
							<th style="width:25%">Artikal</th>
                                                        <th style="width:10%">Cena bez PDV</th>
							<th style="width:10%">Cena sa PDV</th>
                                                        <th style="width:10%">Trenutno u korpi</th>
							<th style="width:10%">Dodaj</th>
                                                        <th style="width:10%">Smanji</th>
							<th style="width:15%" class="text-center">Cena stavke</th>
							<th style="width:10%"></th>
						</tr>
					</thead>
					<tbody>
                                            <c:forEach items="${stavke}" var="s">
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
							<td data-th="CenaBezPDV">${s.artikal.cenaBezPDV} din.</td>
                                                        <td data-th="CenaSaPDV"><b>${s.artikal.cenaSaPDV} din.</b></td>
                                                        <td data-th="TrenutnoUKorpi"><b>${s.kolicina} kom.</b></td>
							<td data-th="Dodaj">
                                                            <c:choose>
                                                                <c:when test="${s.artikal.kolicinaZaProdaju > s.kolicina}">
                                                                    <c:url var="addKolicina_artikal" value="${rootContext.request.contextPath}/korpa/artikal/${s.artikal.artikalId}/add" />
                                                                    <a href="${addKolicina_artikal}"><button class="btn btn-info btn-sm" ><span class="glyphicon glyphicon-plus gi-2x"></span></button></a>
                                                                    
                                                                    
                                                                </c:when>
                                                                <c:otherwise>
                                                                    Svi poruceni
                                                                    
                                                                    
                                                                </c:otherwise>
                                                            </c:choose>
                                                            
							</td>
                                                        <td data-th="Smanji">
                                                            <c:choose>
                                                                <c:when test="${s.kolicina > 1}">
                                                                    <c:url var="remove_artikal" value="${rootContext.request.contextPath}/korpa/artikal/${s.artikal.artikalId}/remove" />
                                                                    <a href="${remove_artikal}"><button class="btn btn-info btn-sm" ><span class="glyphicon glyphicon-minus gi-2x"></span></button></a>

                                                                </c:when>
                                                                <c:otherwise>
                                                                    /
                                                                    
                                                                    
                                                                </c:otherwise>
                                                            </c:choose>
                                                            
                                                            
							</td>
                                                        <td data-th="CenaStavke" class="text-center"><b>${s.ukupnaCenaStavke} din.</b></td>
							<td class="actions" data-th="">
                                                                <c:url var="remove_stavka" value="${rootContext.request.contextPath}/korpa/delete/stavka/${s.stavkaKorpeId}" />
                                                                <a href="${remove_stavka}"><button class="btn btn-info btn-sm" ><span class="glyphicon glyphicon-remove-sign gi-2x"></span></button></a>
                                                                
								
							</td>
						</tr>
                                            </c:forEach>
						
							
					</tbody>
					<tfoot>
						<tr class="visible-xs">
							<td class="text-center"><strong>Ukupno: ${korpa.ukupnaCenaKorpe} din</strong></td>
						</tr>
						<tr>
							<td></td>
							<td colspan="2" class="hidden-xs"></td>
                                                        <td/><td/><td/>
							<td class="hidden-xs text-center"><strong>Ukupno: ${korpa.ukupnaCenaKorpe} din</strong></td>
                                                        <td/>
                                                </tr>
                                                <tr>
                                                    
                                                    <td><a href="${lista_artikala}" class="btn btn-warning"><span class="glyphicon glyphicon-chevron-left"></span> Nastavi razgledanje</a></td>
                                                    <td/><td/><td/><td/></td><td/>
                                                        <c:url var="narudzbenica_url" value="${rootContext.request.contextPath}/narudzbenica/kreiraj/${korpa.korpaId}" />
							<td><a href="${narudzbenica_url}" class="btn btn-success btn-block">Potvrdi<span class="glyphicon glyphicon-chevron-right"></span></a></td>
                                                        <td/>
                                                </tr>
					</tfoot>
				</table>
                    </div>
            
        </c:when>
        <c:otherwise>
            <div class="jumbotron">
                <div class="text-center">
                    <h2>Postovani ${username}, nemate dodatu nijednu stavku u korpi!</h2>
                </div>
            </div>
            
        </c:otherwise>
    </c:choose>
    

    
    
</section>