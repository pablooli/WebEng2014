package rest.tasklist;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

/**
 * A service that manipulates contacts in an address book.
 *
 */
@Path("/listTask")
public class TaskListService {

	/**
	 * The (shared) address book object. 
	 */
	@Inject
	MenuTareas taskList;

	/**
	 * A GET /listTask request should return the address book in JSON.
	 * @return a JSON representation of the address book.
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public MenuTareas getlistTask() {
		taskList = TaskOperationsFile.listaTareas();
		return taskList;
	}

	/**
	 * A POST /listTask request should add a new entry to the list tasks.
	 * @param info the URI information of the request
	 * @param task the posted entity
	 * @return a JSON representation of the new entry that should be available at /listTasks/task/{id}.
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addTask(@Context UriInfo info, Tarea task) {
		//task.setId(taskList.getListaTarea().get(taskList.getListaTarea().size()-1).getId()+1);
		//task.setHref(info.getAbsolutePathBuilder().path("task/{id}").build(task.getId()));
		task.setId(taskList.nextId());
		task.setHref(info.getAbsolutePathBuilder().path("task/{id}").build(task.getId()));
		taskList.getListaTarea().add(task);
		TaskOperationsFile.addTask(task);
		return Response.created(task.getHref()).entity(task).build();
	}

	/**
	 * A GET /listTask/task/{id} request should return a entry from the list task
	 * @param id the unique identifier of a task
	 * @return a JSON representation of the new entry or 404
	 */
	@GET
	@Path("/task/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTask(@PathParam("id") int id) {
		taskList = TaskOperationsFile.listaTareas();
		for (Tarea p : taskList.getListaTarea()) {
			if (p.getId() == id) {
				return Response.ok(p).build();
			}
		}
		return Response.status(Status.NOT_FOUND).build();
	}

	/**
	 * A PUT /listTask/task/{id} should update a entry if exists
	 * @param info the URI information of the request
	 * @param person the posted entity
	 * @param id the unique identifier of a task
	 * @return a JSON representation of the new updated entry or 400 if the id is not a key
	 */
	@PUT
	@Path("/task/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateTask(@Context UriInfo info,
			@PathParam("id") int id, Tarea task) {
		taskList = TaskOperationsFile.listaTareas();
		for (int i = 0; i < taskList.getListaTarea().size(); i++) {
			if (taskList.getListaTarea().get(i).getId() == id) {
				task.setId(id);
				task.setHref(info.getAbsolutePath());
				taskList.getListaTarea().set(i, task);
				return Response.ok(task).build();
			}
		}
		return Response.status(Status.BAD_REQUEST).build();
	}

	/**
	 * A DELETE /listTask/task/{id} should delete a entry if exists
	 * @param id the unique identifier of a task
	 * @return 204 if the request is successful, 404 if the id is not a key
	 */
	@DELETE
	@Path("/task/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteTask(@PathParam("id") int id) {
		taskList = TaskOperationsFile.listaTareas();
		for (int i = 0; i < taskList.getListaTarea().size(); i++) {
			if (taskList.getListaTarea().get(i).getId() == id) {
				TaskOperationsFile.deleteTarea(i);
				taskList.getListaTarea().remove(i);
				return Response.noContent().build();
			}
		}
		return Response.status(Status.NOT_FOUND).build();
	}

}
