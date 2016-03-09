<%@page import="com.examen.portlets.Persona"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

<h1>Portlet B</h1>

<% 

	Persona persona = (Persona)request.getAttribute("envioDatosb");
	if(persona !=null){
%>
<form  method="post">
	<div>Nombre: <input type="text" name="nombre" value="<%=persona.getNombre()%>"/></div>
	<div>Direccion: <input type="text" name="direccion" value="<%=persona.getDireccion()%>"/></div>
	<div>Teléfono: <input type="text" name="telefono" value="<%=persona.getTelefono()%>"/></div>
	
</form>
<%
} else {
%>
	<div>Nombre: <input type="text" name="nombre"/></div>
	<div>Direccion: <input type="text" name="direccion" /></div>
	<div>Teléfono: <input type="text" name="telefono"/></div>
<%
}
%>