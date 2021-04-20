package br.com.task.utilitarios;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Menssage {

	public static void info(String text ) {
		FacesMessage message = new FacesMessage
				(FacesMessage.SEVERITY_INFO,"", null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public static void Erro(String text ) {
		FacesMessage message = new FacesMessage
				(FacesMessage.SEVERITY_ERROR,"", null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	public static void warn(String text ) {
		FacesMessage message = new FacesMessage
				(FacesMessage.SEVERITY_WARN,"", null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
}
