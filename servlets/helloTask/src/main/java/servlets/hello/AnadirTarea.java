package servlets.hello;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


import com.google.gson.Gson;


	public class AnadirTarea {

	public static synchronized void AddTarea(String task, String context, String proyect, String priority) throws IOException {
			Tarea tarea = new Tarea();
			String filename = "Tareas.json";

			MenuTareas listTask = new MenuTareas();
			Gson gson = new Gson();
		
			tarea.setTask(task);
			tarea.setContext(context);
			tarea.setProyect(proyect);
			tarea.setPriority(Integer.parseInt(priority));
			
		// Read the existing address book.
			try {
				listTask = gson.fromJson(new FileReader(filename),
					MenuTareas.class);
			} catch (FileNotFoundException e) {
				System.out.println(filename
					+ ": File not found.  Creating a new file.");
			}

		// Add an task.
		System.out.println(listTask.toString());
		listTask.addTarea(tarea);

		// Write the new task book back to disk.
		FileWriter output = new FileWriter(filename);
		output.write(gson.toJson(listTask));
		output.close();

    		}




	}
