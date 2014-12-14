package bigws.taskws;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

public class TaskOperationsFile {
	public final static String DEFAULT_FILE_NAME = "Tareas.json";
	
	public static synchronized void addTask(String task, String context, String proyect, String priority) {
			Tarea tarea = new Tarea();

			MenuTareas listTask = new MenuTareas();
			Gson gson = new Gson();
		
			tarea.setTask(task);
			tarea.setContext(context);
			tarea.setProyect(proyect);
			tarea.setPriority(Integer.parseInt(priority));
			try {
				listTask = gson.fromJson(new FileReader(DEFAULT_FILE_NAME),
					MenuTareas.class);
			} catch (FileNotFoundException e) {
				System.out.println(DEFAULT_FILE_NAME
					+ ": File not found.  Creating a new file.");
			}

		// Add an task.
		listTask.addTarea(tarea);

		// Write the new task book back to disk.
				FileWriter output;
		try {
			output = new FileWriter(DEFAULT_FILE_NAME);
			output.write(gson.toJson(listTask));
			output.close();}
			catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


    		}

	public static void deleteTarea(String task) {
		Gson gson = new Gson();
		String filename = DEFAULT_FILE_NAME;
		// Write the new task book back to disk.
		MenuTareas listTask = new MenuTareas();
		
	// Read the existing address book.
		try {
			listTask = gson.fromJson(new FileReader(filename),
				MenuTareas.class);
		} catch (FileNotFoundException e) {
			System.out.println(filename
				+ ": File not found.  Creating a new file.");
		}

	// delete an task.
		boolean encontrado = false;
		int indice = 0;
		while (!encontrado && indice<listTask.size()){
			Tarea tarea = listTask.getListaTarea().get(indice);
			if (tarea.getTask().compareTo(task)==0) {
				listTask.deleteTarea(tarea);
				encontrado = true;
		}
			indice++;

		}

	// Write the new task book back to disk.
	FileWriter output;
	try {
		output = new FileWriter(filename);
		output.write(gson.toJson(listTask));
		output.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}


	}
		
	public static MenuTareas listaTareas() {
		Gson gson = new Gson();
		String filename = DEFAULT_FILE_NAME;


		MenuTareas listTask = null;
		try {
			listTask = gson.fromJson(new FileReader(filename),
					MenuTareas.class);
		} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return listTask;
	 }
	 
	 public static MenuTareas listaPorTarea(String tarea){
		 Gson gson = new Gson();
			String filename = DEFAULT_FILE_NAME;

			MenuTareas listTask = new MenuTareas();
			MenuTareas listTaskReturn = new MenuTareas();
			try {
				listTask = gson.fromJson(new FileReader(filename),
						MenuTareas.class);
			} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		for (Tarea task : listTask.getListaTarea()) {
			if (task.getTask().compareTo(tarea)==0) {
				listTaskReturn.addTarea(task);
			}
		}
		return listTaskReturn;
	}

	
}
