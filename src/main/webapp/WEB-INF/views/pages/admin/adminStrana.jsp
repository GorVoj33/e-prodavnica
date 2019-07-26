<%-- 
    Document   : adminStrana
    Created on : Jul 17, 2019, 4:07:06 PM
    Author     : Asus
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="../header.jsp" %>

<section>
    <div class="page-header" align="center">
        <b>${naziv}</b>
    </div>
    <div class="section-heading">
        <h4>Upravljanje artiklima</h4>
    </div>
    <div class="table">
        <table class="table table-bordered table-dark">
          
   <thead>
    <tr>
<!--      <th scope="col">#</th>-->
      <th scope="col">Naziv</th>
      <th scope="col">Opis</th>
      <th scope="col">Kategorija</th>
      <th scope="col">Cena bez PDV</th>
      <th scope="col">Poreska stopa</th>
      <th scope="col">Cena sa PDV</th>
      <th scope="col">Dostupna kolicina</th>
      <th scope="col">Pregled</th>
      <th scope="col">Izmena</th>
      <th scope="col">Brisanje</th>
    </tr>
  </thead>
  <tbody>
      <c:forEach items="${sviArtikli}" var="art">
          <tr>
              <td>${art.naziv}</td>
              <td>${art.opis}</td>
              <td>${art.kategorija.naziv}</td>
              <td>${art.cenaBezPDV} din.</td>
              <td>${art.poreskaStopa.vrednost} %</td>
              <td>${art.cenaSaPDV} din.</td>
              <td>${art.kolicinaZaProdaju} kom.</td>
              <td>
                  <c:url var="view_art" value="${rootContext.request.contextPath}/artikal/${art.artikalId}" />
                  <a href="${view_art}" >
                     POGLEDAJ
                  </a> </td>
              <td>
                  <c:url var="edit_art" value="${rootContext.request.contextPath}/admin/artikal/edit/${art.artikalId}" />
                  <a href="${edit_art}" >
                     IZMENI
                  </a> </td>
              <td>
                  <c:url var="delete_art" value="${rootContext.request.contextPath}/admin/artikal/delete/${art.artikalId}" />
                  <a href="${delete_art}" >
                     OBRISI
                  </a> </td>
          </tr>
          
      </c:forEach>
  </tbody>
</table>
        
    </div>
    <c:url var="add_artikal" value="${rootContext.request.contextPath}/admin/artikal/add" />
    <a class="btn btn-primary btn-lg btn-block" href="${add_artikal}">Kreiraj novi artikal</a>
    <br><br>
    
    <hr class="primary"/>
    
    <div class="section-heading">
        <h4>Pregled registrovanih profila</h4>
    </div>
    <div class="table">
        <table class="table table-bordered table-dark">
          
   <thead>
    <tr>
<!--      <th scope="col">#</th>-->
      <th scope="col">Ime</th>
      <th scope="col">Prezime</th>
      <th scope="col">Username</th>
      <th scope="col">Kontakt telefon</th>
      <th scope="col">Adresa</th>
      <th scope="col">Grad</th>
    </tr>
  </thead>
  <tbody>
    <c:if test="${fn:length(sviProfili) eq 0}">
        <tr><td>U bazi nema registrovanih korisnika</td></tr>
    </c:if>
      <c:forEach items="${sviProfili}" var="p">
          <tr>
              <td>${p.ime}</td>
              <td>${p.prezime}</td>
              <td>${p.username}</td>
              <td>${p.kontakt}</td>
              <td>${p.adresaIsporuke.adresa}</td>
              <td>${p.adresaIsporuke.grad}</td>
              <!--<td><span class="glyphicon glyphicon-info-sign"></span></td>-->
          </tr>
          
      </c:forEach>
  </tbody>
</table>
        
    </div>
    
    
    <hr class="primary"/>
    
    <div class="section-heading">
        <h4>Upravljanje kategorijama</h4>
    </div>
    <div class="table">
        <table class="table table-bordered table-dark">
          
   <thead>
    <tr>
<!--      <th scope="col">#</th>-->
      <th scope="col">Naziv</th>
      <th scope="col">Opis</th>
      <th scope="col">Broj artikala</th>
      <th scope="col">Obrisi</th>
    </tr>
  </thead>
  <tbody>
    <c:if test="${fn:length(sveKategorije) eq 0}">
        <tr><td>U bazi nema unetih kategorija</td></tr>
    </c:if>
      <c:forEach items="${sveKategorije}" var="k">
          <tr>
              <td>${k.naziv}</td>
              <td>${k.opis}</td>
              <td>${fn:length(k.artikli)}</td>
              
              <td>
                  <c:if test="${fn:length(k.artikli) gt 0}">
                      Ne mozete obrisati, postoje artikli.
                  </c:if>
                  <c:if test="${fn:length(k.artikli) eq 0}">
                      <c:url var="remove_kategorija" value="${rootContext.request.contextPath}/admin/kategorija/delete/${k.kategorijaId}" />
                      <a href="${remove_kategorija}" >
                          <span class="glyphicon glyphicon-remove"></span>
                      </a>

                  </c:if>
              </td>
          </tr>
          
      </c:forEach>
  </tbody>
</table>
        
    </div>
 <c:url var="add_kategorija" value="${rootContext.request.contextPath}/admin/kategorija/add" />
    <a class="btn btn-primary btn-lg btn-block" href="${add_kategorija}">Kreiraj novu kategoriju</a>
    
    <hr class="primary"/>
    
    <div class="section-heading">
        <h4>Pristigle narudzbenice</h4>
    </div>
    <div class="table">
        <table class="table table-bordered table-dark">
          
   <thead>
    <tr>
<!--      <th scope="col">#</th>-->
      <th scope="col">Datum</th>
      <th scope="col">Ime kupca</th>
      <th scope="col">Prezime kupca</th>
      <th scope="col">Adresa</th>
      <th scope="col">Grad</th>
      <th scope="col">Postanski kod</th>
      <th scope="col">Artikal</th>
      <th scope="col">Kolicina</th>
      <th scope="col">Cena stavke</th>
      <th scope="col">Ukupno za naplatu</th>
    </tr>
  </thead>
  <tbody>
    <c:if test="${fn:length(sveNarudzbenice) eq 0}">
        <tr><td>U bazi nema unetih narudzbenica</td></tr>
    </c:if>
    <c:forEach items="${sveNarudzbenice}" var="n">
        
     <tr>
       <td>${n.datum}</td>
       <td>${n.profil.ime}</td>
       <td>${n.profil.prezime}</td>
       <td>${n.adresaIsporuke.adresa}</td>
       <td>${n.adresaIsporuke.grad}</td> 
       <td>${n.adresaIsporuke.postanskiKod}</td> 
     </tr>
      <c:forEach items="${n.stavke}" var="sn">
          <tr>
              <td/><td/><td/><td/><td/><td/>
              <td>${sn.artikal.naziv}</td>
              <td>${sn.kolicina}</td>
              <td>${sn.ukupnaCenaStavke} din.</td>
              
          </tr>
          
      </c:forEach>
          <tr>
              <td/><td/><td/><td/><td/><td/><td/><td/><td/>
              <td><strong>${n.ukupno} din</strong></td>
              
          </tr>
    </c:forEach>
  </tbody>
</table>
        
    </div>
    
    
    
</section>