package rest.tasklist;

import java.util.ArrayList;
import java.util.List;

public class MenuTareas {
	private  List<Tarea> listaTareas = new ArrayList<Tarea>();
	private int nextId = 1;
	
	/**
	 * The value of next unique identifier.
	 * @return the next unique identifier.
	 */
	public int getNextId() {
		return nextId;
	}

	public void setNextId(int nextId) {
		this.nextId = nextId;
	}
	
	/**
	 * Returns the old next identifier and increases the new value in one.
	 * @return an identifier.
	 */
	public int nextId() {
		int oldValue = nextId;
		nextId++;
		return oldValue;
	}
	
	public int size(){
		return listaTareas.size();
	}	
	public  void addTarea(Tarea task){
		listaTareas.add(task);
	}
	
	public List<Tarea> getListaTarea(){
		return listaTareas;
	}
	public void setListaTarea(List<Tarea> persons) {
		this.listaTareas = persons;
	}
	
	public void deleteTarea(Tarea task){
		listaTareas.remove(task);
	}
	


	public  void mostrarTareas(){
		for (int i=0; i<listaTareas.size(); i++){
			listaTareas.get(i).mostrar();
		}
	}
}
