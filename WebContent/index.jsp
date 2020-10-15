<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>Connexion</title>
</head>
<body>


<div class="container">
  <div class="row">
    <div class="col-sm">
    </div>
    <div class="col-sm">
<form action="Authservlet" method="post">
<table>
<tr><td colspan="2" align="center"><h1>Connexion</h1></td></tr>
<tr><td>Login</td><td><input required type="text" class="form-control" name="login"></td></tr>
<tr><td>Mot de passe</td><td><input required type="password" class="form-control"  name="mdp"></td></tr>
<tr><td colspan="2" align="center"><input class="btn btn-info" type="submit" value="envoyer"></td></tr>

</table>
<%
if(session.getAttribute("erreur")!=null)
{
%>
<span class="badge badge-danger">Compte non reconnu</span>

<% } %>

</form>    </div>
    <div class="col-sm">
    </div>
  </div>
</div>
</body>
</html>