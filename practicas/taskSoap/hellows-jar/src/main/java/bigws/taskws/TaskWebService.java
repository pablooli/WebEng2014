package bigws.taskws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public class TaskWebService {
	
	@WebMethod()
	public void addTask(String task, String context, String proyect, String priority){
		TaskOperationsFile.addTask(task,context,proyect,priority);
	}
	@WebMethod()
	public void deleteTask(String task){
		TaskOperationsFile.deleteTarea(task);
	}
	@WebMethod()
	public List<Tarea> viewTask(String task) {
		if (task==null || task.isEmpty())
			return TaskOperationsFile.listaTareas().getListaTarea();
		else
			return TaskOperationsFile.listaPorTarea(task).getListaTarea();
	}
}
