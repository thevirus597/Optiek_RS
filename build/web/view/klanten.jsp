
<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"> 
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap.min.css" >
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" >
        <style>       
        @import url(https://fonts.googleapis.com/css?family=Open+Sans);



nav {
  max-width: auto;
  mask-image: linear-gradient(90deg, rgba(255, 255, 255, 0) 0%, #ffffff 25%, #ffffff 75%, rgba(255, 255, 255, 0) 100%);
   background-image: linear-gradient(to right top, #8e44ad 0%, #3498db 100%);
  margin: 0 auto;
  padding: 25px 0;
}

nav ul {
  text-align: center;
  background: linear-gradient(90deg, rgba(255, 255, 255, 0) 0%, rgba(255, 255, 255, 0.2) 25%, rgba(255, 255, 255, 0.2) 75%, rgba(255, 255, 255, 0) 100%);
  box-shadow: 0 0 25px rgba(0, 0, 0, 0.1), inset 0 0 1px rgba(255, 255, 255, 0.6);
}

nav ul li {
  display: inline-block;
}

nav ul li a {
  padding: 18px;
  font-family: "Open Sans";
  text-transform:uppercase;
  color: rgba(255, 255, 255, 0.5);
  font-size: 18px;
  text-decoration: none;
  display: block;
}

nav ul li a:hover {
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1), inset 0 0 1px rgba(255, 255, 255, 0.6);
  background: rgba(255, 255, 255, 0.1);
  color: rgba(0, 35, 122, 0.7);
  text-decoration: none;
}
.active { 
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1), inset 0 0 1px rgba(255, 255, 255, 0.6);
    background: rgba(255, 255, 255, 0.1);
  color: rgba(0, 35, 122, 0.7);
  text-decoration: none;
}

.footer {
   position:absolute;
   bottom:0;
   width:100%;
   height:50px;   /* Height of the footer */
   mask-image: linear-gradient(90deg, rgba(255, 255, 255, 0) 0%, #ffffff 25%, #ffffff 75%, rgba(255, 255, 255, 0) 100%);
   background-image: linear-gradient(to right , #8e44ad 0%, #3498db 100%);
}
.footer p{
    font-family: "Open Sans";
    text-transform:uppercase;
  color: rgba(255, 255, 255, 1);
  font-size: 15px;
  text-decoration: none;
  display: block;
  margin: 17.5px 0;
}
.btn-info{
    color: #fff;
    background-color: #626dc3;
    border-color: #3697db;
}
    </style>

        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Klanten Overzicht</title>
    </head>
    <body>

        <nav>
  <ul>
    <li>
      <a href="index.html">Home</a>
    </li>
    <li>
      <a href="klanten" class="active">Klanten</a>
    </li>
    <li>
      <a href="product">Product</a>
    </li>
    <li>
      <a href="oogmeting">Oogmetingen</a>
    </li>
     <li>
      <a href="verkoop">Verkoop</a>
    </li>
  </ul>
</nav>
                
        <div class="col-md-12">
            <div class="container">
                <div class="row">
         <p style="color: red;">${errorString}</p>
        <table  class="table" id="example">
            
            <thead>
       <tr>
          <th>#</th>
          <th>ID</th>
          <th>Voornaam</th>
          <th>Achternaam</th>
          <th>Geslacht</th>
          <th>Geboortedatum</th>
          <th>Functions</th>
       </tr>
       </thead>
        <tbody>
       <c:forEach items="${klanten}" var="klant">
        <tr>
            <td>${klant.id}</td>
            <td><c:out value="${klant.id_number}" /></td>
            <td><c:out value="${klant.name}" /></td>
            <td><c:out value="${klant.surname}" /></td>
             <td><c:out value="${klant.gender}" /></td>
             <td><c:out value="${klant.birthday}" /></td>
             <td>
                <a href="deleteklant?code=${klant.id}"><i class="fa fa-trash-o" aria-hidden="true"> Verwijder</i></a>&nbsp&nbsp&nbsp
                <a href="KlantVerkoop?code=${klant.id}"><i class="fa fa-eye" aria-hidden="true"> Producten</i></a>&nbsp&nbsp&nbsp
                <a href="KlantOogmetingServlet?code=${klant.id}"><i class="fa fa-history" aria-hidden="true"> Oogmetingen</i></a>
             </td>
        </tr>
         
    </c:forEach>
        </tbody>
        

    </table>
       </div>
         
          <input type="submit" value="Klant Registreren" class="btn  btn-info" data-toggle="modal" data-target="#klantenModal"/>
          <div id="klantenModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Klant Registreren</h4>
      </div>
      <div class="modal-body">
        <form method="POST" action="${pageContext.request.contextPath}/InsertKlant">
            <div class="form-group">
                
            </div>
            <div class="form-group">
                <label>ID</label>
                <input type="text" name="id"  class="form-control" value="${klant.code}" required />
            </div>
            <div class="form-group">
                <label>Voornaam</label>
                <input type="text" name="name" class="form-control" value="${klant.name}" required/>
                
            </div>
            <div class="form-group">
                <label>Achternaam</label>
                <input type="text" name="surname" class="form-control" value="${klant.surname}" required/>
            </div>
            <div class="form-group">
                <label>geslacht</label>
                <input type="text" name="gender" class="form-control" value="${klant.gender}" required/>
            </div>
            <div class="form-group">
                <label>Geboortedatum</label>
                <input type="date" name="birthday" class="form-control" value="${klant.birthday}" required/>
            </div>
            <div class="form-group">
                <input type="submit" value="Submit" class="btn  btn-success"/>
                   <a data-dismiss="modal" class="btn btn-danger pull-right">Cancel</a>
            </div>
      </form>
      </div>
    </div>

  </div>
</div>
            </div>
            </div>
            
             <div class="footer"
            <footer>
                <center><p>Copyright © 2017 | VIRESH & RHEO | All Rights Reserved | DEVELOPED BY VIRESH & RHEO</p><center>
                
                </div>
            </footer>
    </body>
            <script src="//code.jquery.com/jquery-1.12.4.js"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
            <script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
           <script src="https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap.min.js"></script>
           <script src="//cdn.datatables.net/plug-ins/1.10.16/i18n/Dutch.json"></script>
            <script>
            $(document).ready(function() {
                $('#example').DataTable({
                    "language": {
                "sProcessing": "Bezig...",
                "sLengthMenu": "_MENU_ resultaten weergeven",
                "sZeroRecords": "Geen resultaten gevonden",
                "sInfo": "_START_ tot _END_ van _TOTAL_ resultaten",
                "sInfoEmpty": "Geen resultaten om weer te geven",
                "sInfoFiltered": " (gefilterd uit _MAX_ resultaten)",
                "sInfoPostFix": "",
                "sSearch": "Zoeken:",
                "sEmptyTable": "Geen resultaten aanwezig in de tabel",
                "sInfoThousands": ".",
                "sLoadingRecords": "Een moment geduld aub - bezig met laden...",
                "oPaginate": {
                    "sFirst": "Eerste",
                    "sLast": "Laatste",
                    "sNext": "Volgende",
                    "sPrevious": "Vorige"
                },
                "oAria": {
                    "sSortAscending":  ": activeer om kolom oplopend te sorteren",
                    "sSortDescending": ": activeer om kolom aflopend te sorteren"
                }
            }
                });
            } );
</script>
</html>

