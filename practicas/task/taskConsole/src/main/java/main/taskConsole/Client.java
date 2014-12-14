package main.taskConsole;

import java.util.List;
import java.util.Scanner;



public class Client {

		 	
			public static void main(String[] args) {								
				menu();
				System.out.print("Put opcion: ");
				Scanner opcion = new Scanner(System.in);
				int op = opcion.nextInt();
				while (op<5){
					if (op == 0){
						System.exit(0);
					}
					else if(op==1){
						String task,context, proyect,priority;
						System.out.print("Put tarea: ");
						Scanner get = new Scanner(System.in);
						task = get.nextLine();
						System.out.print("Put context:");
						 get = new Scanner(System.in);
						 context = get.nextLine();
						System.out.print("Put proyect: ");
						 get = new Scanner(System.in);
						 proyect = get.nextLine();
						System.out.print("Put priority: ");
						 get = new Scanner(System.in);
						 priority = get.nextLine();
						TaskOperationsFile.addTask(task, context, proyect, priority);
					}
					else if(op==2){
						String task;
						System.out.print("Put tarea to delete: ");
						Scanner get = new Scanner(System.in);
						task = get.nextLine();
						TaskOperationsFile.deleteTarea(task);
					}
					else if (op==3){
						List<Tarea> tareas = TaskOperationsFile.listaTareas().getListaTarea();
						for(int i=0;i<tareas.size();i++){
							Tarea tarea = tareas.get(i);
							System.out.println("-----------------------------------");
							System.out.println("Task: " +tarea.getTask());
							System.out.println("Context: " +tarea.getContext());
							System.out.println("Proyect: " +tarea.getProyect());
							System.out.println("Priority: " +tarea.getPriority());
						}
					}
					else if(op==4){
						String task;
						System.out.print("Put tarea to show: ");
						Scanner get = new Scanner(System.in);
						task = get.nextLine();
						List<Tarea> tareas = TaskOperationsFile.listaPorTarea(task).getListaTarea();
						for(int i=0;i<tareas.size();i++){
							Tarea tarea = tareas.get(i);
							if (tarea.getTask().contains(task));
								System.out.println("Task: " +tarea.getTask());
								System.out.println("Context: " +tarea.getContext());
								System.out.println("Proyect: " +tarea.getProyect());
								System.out.println("Priority: " +tarea.getPriority());						
						}
					}
					menu();
					System.out.print("Put opcion: ");
					opcion = new Scanner(System.in);
					op = opcion.nextInt();
				}

			}
			
			public static void menu(){
				System.out.println("-----------------------------------");
				System.out.println("1 - Add task");
				System.out.println("2 - Delete task");
				System.out.println("3 - View all task");
				System.out.println("4 - View an task");
				System.out.println("0 - Close client");
				System.out.println("-----------------------------------");
			}

}
