package servlets.hello;

public class Tarea {
	private String task;
	private String context;
	private String proyect;
	private int priority;
	
	public void mostrar(){
		System.out.println("Tarea: "+ task);
		System.out.println("Contexto: "+ context);
		System.out.println("Proyecto: "+ proyect);
		System.out.println("Prioridad: "+ priority);
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
}
