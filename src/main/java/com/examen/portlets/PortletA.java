package com.examen.portlets;

import java.io.IOException;
import java.io.Serializable;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Event;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ProcessAction;
import javax.portlet.ProcessEvent;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.xml.namespace.QName;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * Portlet implementation class PortletA
 */
public class PortletA extends GenericPortlet {

    public void init() {
        viewTemplate = getInitParameter("view-template");
    }
   
    @ProcessAction(name = "enviarDatosB")
	public void enviarDatosB(ActionRequest request, ActionResponse response) throws PortletException, IOException {

		String nombre = request.getParameter("nombre");
		String direccion = request.getParameter("direccion");
		String telefono = request.getParameter("telefono");
		
		Persona persona= new Persona(nombre, direccion,telefono);


		QName qname = new QName("http://enviar.portletb.com", "envioDatosb", "x");

		response.setEvent(qname, persona);
		
	

	}
    @ProcessAction(name = "enviarDatosC")
	public void enviarDatosC(ActionRequest request, ActionResponse response) throws PortletException, IOException {

		String nombre = request.getParameter("nombre");
		String direccion = request.getParameter("direccion");
		String telefono = request.getParameter("telefono");
		
		Persona persona= new Persona(nombre, direccion,telefono);


		QName qname = new QName("http://enviar.portletc.com", "envioDatosc", "x");

		response.setEvent(qname, persona);
	

	}
   

    public void doView(
            RenderRequest renderRequest, RenderResponse renderResponse)
        throws IOException, PortletException {

        include(viewTemplate, renderRequest, renderResponse);
    }

    protected void include(
            String path, RenderRequest renderRequest,
            RenderResponse renderResponse)
        throws IOException, PortletException {

        PortletRequestDispatcher portletRequestDispatcher =
            getPortletContext().getRequestDispatcher(path);

        if (portletRequestDispatcher == null) {
            _log.error(path + " is not a valid include");
        }
        else {
            portletRequestDispatcher.include(renderRequest, renderResponse);
        }
    }
 
    protected String viewTemplate;

    private static Log _log = LogFactoryUtil.getLog(PortletA.class);

}
