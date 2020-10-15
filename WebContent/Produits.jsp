<%@page import="com.mysql.jdbc.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="classes.Produit" %>
    <%
    Produit p=new Produit();
    ResultSet rs=p.affiche();
    
    
    %>

    <<style>
td
{
text-align:center;}
</style>
<!DOCTYPE html>
<html>
<head>
<!-- CSS -->


<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
<%@include file="menu.jsp" %>

<div align="center">
</div>
      <form action="ProduitServlet" method="post">
      
      <table class="table table-borderless">
      <input type="hidden" name="methode" value="modifier">
       <input type="hidden" name="id" value="<%=request.getParameter("id") %>">
        <input type="hidden" name="t" value="<%=request.getParameter("titre") %>">
        
        
      <tr><td>Titre</td><td><%=request.getParameter("titre") %></td></tr>
        <tr><td>description</td><td><textarea name="d" required class="form-control"><%=request.getParameter("description") %></textarea></td></tr>
        <tr><td>Quantité</td><td><input type="number" value="<%=request.getParameter("quantite") %>" min="1" name="q" required class="form-control"></td></tr>
        <tr><td>Prix</td><td><input type="number" name="p" value=<%=request.getParameter("prix") %> required class="form-control"></td></tr>
      
              <tr><td colspan="2" align="center"><input type="submit" class="btn btn-success" value="Modifer"></td></tr>
      
      </table>
      
      
      </form>
<br><br>

<div align="center">
<!-- Button trigger modal -->
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
Ajouter un produit</button>
</div>
<br><br>
<!-- Modal -->


<table class="table table-bordered">
  <thead>
    <tr>
      <th scope="col">id</th>
      <th scope="col">titre</th>
      <th scope="col">description</th>
      <th scope="col">quantité</th>
      <th scope="col">Prix</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  <%
  while(rs.next())
  {
  %>
    <tr>
      <th scope="row"><%=rs.getInt("id") %></th>
      
      <td><%=rs.getString("titre") %></td>
      <td><%=rs.getString("description") %></td>
      <td><%=rs.getInt("quantite") %></td>
      <td><%=rs.getDouble("prix") %></td>
      <td><a class="btn btn-outline-dark" href="Produits.jsp?id=<%=rs.getInt("id") %>&titre=<%=rs.getString("titre") %>&description=<%=rs.getString("description") %>&prix=<%=rs.getDouble("prix") %>&quantite=<%=rs.getInt("quantite") %>">Selectionner</a> 
      
      
      <a class="btn btn-outline-danger"  href="ProduitServlet?id=<%=rs.getInt("id") %>">Supprimer</a></td>
    </tr>
  <% } %>
  </tbody>
</table>





<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Nouveau produit</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      <form action="ProduitServlet" method="post">
      
      <table class="table table-borderless">
       <input type="hidden" name="methode" value="inserer">
      <tr><td>Titre</td><td><input  type="text" name="t" required class="form-control"></td></tr>
        <tr><td>description</td><td><textarea name="d" required class="form-control"></textarea></td></tr>
        <tr><td>Quantité</td><td><input type="number" min="1" name="q" required class="form-control"></td></tr>
        <tr><td>Prix</td><td><input type="number" name="p" required class="form-control"></td></tr>
      
              <tr><td colspan="2" align="center"><input type="submit" class="btn btn-primary" value="ajouter"></td></tr>
      
      </table>
      
      
      </form>
      </div>
      <div class="modal-footer">
      </div>
    </div>
  </div>
</div>
</body>
<!-- jQuery and JS bundle w/ Popper.js -->

</html>