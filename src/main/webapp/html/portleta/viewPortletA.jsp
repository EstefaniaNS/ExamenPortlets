<%@page import="com.examen.portlets.Persona"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />



<portlet:actionURL name="enviarDatosB" var="enviarEventoBURL" />
<portlet:actionURL name="enviarDatosC" var="enviarEventoCURL" />
<h1>Portlet A</h1>



<%
Persona persona = (Persona)request.getAttribute("envioDatos");
if(persona!=null){
%>
<form action="" method="post">
	<div>Nombre: <input type="text" name="nombre" value="<%=persona.getNombre()%>"/></div>
	<div>Direccion: <input type="text" name="direccion" value="<%=persona.getDireccion()%>"/></div>
	<div>Telefono: <input type="text" name="telefono" value="<%=persona.getTelefono()%>"/></div>
	<input type="submit" value="Portlet B" formaction="<%=enviarEventoBURL%>"/>
	<input type="submit" value="Portlet C" formaction="<%=enviarEventoCURL%>"/>
	
	
</form>
<%	
}else{
%>
<form action="" method="post">
	<div>Nombre<input type="text" name="nombre"/></div>
	<div>Direccion<input type="text" name="direccion"/></div>
	<div>Telefono<input type="text" name="telefono"/></div>
	<input type="submit" value="Portlet B" formaction="<%=enviarEventoBURL%>"/>
	<input type="submit" value="Portlet C" formaction="<%=enviarEventoCURL%>"/>
</form>


<%	
}
%>
