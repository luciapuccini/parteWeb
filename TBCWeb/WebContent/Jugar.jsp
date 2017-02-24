<!DOCTYPE html>
<%@page import="entidades.Personaje"%>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Cover Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="Style/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="Style/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="Style/cover.css" rel="stylesheet">

    
    <script src="Style/ie-emulation-modes-warning.js"></script>

  </head>

  <body>
 <% Personaje p1= (Personaje) session.getAttribute("Jugador1") ;
	 Personaje p2= (Personaje) session.getAttribute("Jugador2") ;%>
    <div class="inner">

     
            <div class="inner cover">
              <h3 class="masthead-brand">Juego</h3>            
            </div>
           
	 		  
	 		  
    </div>
<!-- ---------------------ATAQUE DEL PERSONAJE Nº 1---------------------------------------- -->
      <div class="container">
       	<div class="row">
       	 <div class="col-md-4">   
         
          <form class="form-cover" name="cover" action="Ataque" method="POST">
           
     	<h3> 
     	<label for="inputPersonaje1" class=" label label-primary"> Jugador 1: <%=p1.getNombre() %></label><br>
     	<label for="inputPersonaje1" class=" label label-primary" >Vida disponible:<%=p1.getVida() %></label><br/>
	    <label for="inputPersonaje1" class=" label label-primary" >Energia Disponible:<%=p1.getEnergia() %></label><br/>
      	</h3>
            
        
         <input type="text" id="puntos1" name="puntos1" size="4px" class="form-control" placeholder="ingrese energia del turno" required autofocus>
      <p>  </p>
	       <input id="personajeActivo" name="personajeActivo" type="hidden" value="1">
	       <button class="btn btn-sm btn-danger"  type="submit"  style="Position:Absolute;right:10px" >Atacar</button>
	     
           
          </form>  
          
 <!-- ---------------------DEFENSA DEL PERSONAJE Nº 1---------------------------------------- --> 
 		<form class="form-cover" name="cover" action="Defensa" method="POST">
 		<input name="personajeActivo" id="personajeActivo" type="hidden" value="1">
        <button class="btn btn-sm btn-primary"  type="submit" style="Position:Absolute;left:10px">Defender</button>
         </form> 
          </div>
          
<!-- -------------------------------------PERSONAJE Nº 2---------------------------------------- -->
<!-- -------------------------------ATAQUE DEL PERSONAJE Nº 2---------------------------------------- -->
         <div class="col-md-4">
          <form class="form-cover" name="cover" action="Ataque" method="POST">
           
     	<h3> 
     	<label for="inputPersonaje2" class=" label label-danger"> Jugador 2: <%=p2.getNombre() %></label><br>
     	<label for="inputPersonaje2" class=" label label-danger" >Vida disponible:<%=p2.getVida() %></label><br/>
	    <label for="inputPersonaje2" class="label label-danger" >Energia Disponible:<%=p2.getEnergia() %></label><br/>
      	</h3>
            
         
         <input type="text" id="puntos2" name="puntos2" size="4px" class="form-control" placeholder="ingrese energia del turno" required autofocus>
      <p>  </p>
	       <input id="personajeActivo" name="personajeActivo" type="hidden" value="2">
	       <button class="btn btn-sm btn-danger"  type="submit"  style="Position:Absolute;right:10px" >Atacar</button>
      </form>  
<!-- ---------------------DEFENSA DEL PERSONAJE Nº 2---------------------------------------- --> 
 	<form class="form-cover" name="cover" action="Defensa" method="POST">
 	<input name="personajeActivo" id="personajeActivo" type="hidden" value="1">
      <button class="btn btn-sm btn-primary"  type="submit" style="Position:Absolute;left:10px">Defender</button>
     </form> 
     
     
         </div>
          </div>
       
         
         
         
   <!-- HASTA ACA -->
<!-- HASTA ACA -->
<!-- HASTA ACA -->
<!-- HASTA ACA -->

   
   
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="../../dist/js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
