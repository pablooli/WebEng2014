package bigws.taskws;

import java.util.ArrayList;
//import java.util.Scanner;

public class MenuTareas {
	private  ArrayList<Tarea> listaTareas = new ArrayList<Tarea>();
//	private static Scanner linea;
	
	public int size(){
		return listaTareas.size();
	}	
	public  void addTarea(Tarea task){
		listaTareas.add(task);
	}
	
	public ArrayList<Tarea> getListaTarea(){
		return listaTareas;
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
