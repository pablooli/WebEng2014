package rest.tasklist;

import java.net.URI;

public class Tarea {
	private String task;
	private String context;
	private int id;
	private String proyect;
	private int priority;
	private URI href;
	
	public void mostrar(){
		System.out.println("Tarea: "+ task);
		System.out.println("Contexto: "+ context);
		System.out.println("Proyecto: "+ proyect);
		System.out.println("Prioridad: "+ priority);
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getProyect() {
		return proyect;
	}
	public void setProyect(String proyect) {
		this.proyect = proyect;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priotity) {
		this.priority = priotity;
	}
	public void setHref(URI href) {
		this.href = href;
	}
	
	public URI getHref() {
		return href;
	}
}
