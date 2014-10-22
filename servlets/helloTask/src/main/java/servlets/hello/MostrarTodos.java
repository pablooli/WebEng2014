//package sistema;
package servlets.hello;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

public class MostrarTodos {
	public final static String DEFAULT_FILE_NAME = "Tareas.json";

	// Iterates though all people in the AddressBook and prints info about them.
	 public static MenuTareas listaTareas() {
		Gson gson = new Gson();
		String filename = DEFAULT_FILE_NAME;

		// Read the existing address book.
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

			// Read the existing address book.
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

	// Main function: Reads the entire address book from a file and prints all
	// the information inside.
}

