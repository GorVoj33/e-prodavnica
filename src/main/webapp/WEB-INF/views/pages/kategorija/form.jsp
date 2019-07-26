<%-- 
    Document   : form
    Created on : Jul 21, 2019, 2:56:29 PM
    Author     : Asus
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="/WEB-INF/views/pages/header.jsp"%>
<c:url var="post_url"  value="${rootContext.request.contextPath}/admin/kategorija/add" />

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
                   commandName="kategorija">

            <div class="form-group">
                <label for="naziv">Naziv</label><br><form:errors path="naziv" cssStyle="color: red;" />
                <form:input path="naziv" id="naziv" type="text" cssClass="form-control" />
            </div>
            
            <div class="form-group">
                <label for="opis">Opis</label><br><form:errors path="opis" cssStyle="color: red;" />
                <form:input path="opis" id="opis" type="text" cssClass="form-control" />
            </div>
     
            <br>
            <div class="col-lg-8 col-lg-offset-2 text-center">
                <input type="submit" value="Sacuvaj" class="btn btn-success" />
                <a href="<c:url value="/" />" class="btn btn-primary">Odustani</a>
            </div>
        </form:form>
    </div>


</section>
<div style="padding-top: 10%" />
<div class="clearfix"/></div>

    <div class="table">
         <table class="table table-bordered table-dark">

    <thead>
     <tr>
 <!--      <th scope="col">#</th>-->
       <th scope="col">Naziv</th>
       <th scope="col">Opis</th>
       <th scope="col">Broj artikala</th>

     </tr>
   </thead>
   <tbody>
     <c:if test="${fn:length(ostaleKategorije) eq 0}">
         <tr><td>U bazi nema unetih kategorija</td></tr>
     </c:if>
       <c:forEach items="${ostaleKategorije}" var="k">
           <tr>
               <td>${k.naziv}</td>
               <td>${k.opis}</td>
               <td>${fn:length(k.artikli)}</td>


           </tr>

       </c:forEach>
        </tbody>
    </table>
        
    </div>


<div style="padding-bottom: 5%" />
<div class="clearfix"/></div>