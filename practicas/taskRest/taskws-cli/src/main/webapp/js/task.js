// The root URL for the RESTful services
var rootURL = "http://localhost:8080/listTask";
var currentTask;

// Retrieve task list when application starts
findAll();

// Nothing to delete in initial application state
$('#btnDelete').hide();

// Register listeners
$('#btnSearch').click(function() {
	search($('#searchKey').val());
	return false;
});

// Trigger search when pressing 'Return' on search key input field
$('#searchKey').keypress(function(e){
	if(e.which == 13) {
		search($('#searchKey').val());
		e.preventDefault();
		return false;
	}
});

$('#btnSave').click(function() {
	if ($('#taskId').val() == '')
		addTask();
	else
		updateTask();
	return false;
});

$('#btnDelete').click(function() {
	deleteTask();
	return false;
});

$('#btnAdd').click(function() {
	newTask();
	return false;
});

function newTask() {
	$('#btnDelete').hide();
	currentTask = {};
	showDetailsAnTask(currentTask); // Display empty form
}

function search(searchKey) {
	if (searchKey == '')
		findAll();
	else
		findById(searchKey);
}

function findAll() {
	console.log('findAll');
	$.ajax({
		type: 'GET',
		url: rootURL,
		dataType: "json", // data type of response
		success: renderList
	});
}

function findById(id) {
	$.ajax({
		type: 'GET',
		url: rootURL + '/task/' + id,
		dataType: "json",
		success: function(data){
			$('#btnDelete').show();
			console.log('findById success: ' + data.id);
			currentTask = data;
			showDetailsAnTask(currentTask);
		}
	});
}

function addTask() {
	$.ajax({
		type: 'POST',
		contentType: 'application/json',
		url: rootURL,
		dataType: "json",
		data: formToJSON(),
		success: function(data, textStatus, jqXHR){
			alert('Task created successfully');
			$('#btnDelete').show();
			$('#taskId').val(data.id);
		},
		error: function(jqXHR, textStatus, errorThrown){
			alert('addTask error: ' + textStatus);
		}
	});
}

function updateTask() {
	$.ajax({
		type: 'PUT',
		contentType: 'application/json',
		url: rootURL + '/' + $('#taskId').val(),
		dataType: "json",
		data: formToJSON(),
		success: function(data, textStatus, jqXHR){
			alert('Task updated successfully');
		},
		error: function(jqXHR, textStatus, errorThrown){
			alert('updateTask error: ' + textStatus);
		}
	});
}
function deleteTask() {
	$.ajax({
		type: 'DELETE',
		url: rootURL + '/task/' + $('#taskId').val(),
		success: function(data, textStatus, jqXHR){
			alert('Task delete successfully');
		},
		error: function(jqXHR, textStatus, errorThrown){
			alert('deleteTask error');
		}
	});
}

function renderList(data) {
	var list = data.listaTarea;
// JAX-RS serializes an empty list as null, and a 'collection of one' as an object (not an 'array of one')
//var list = data == null ? [] : (data instanceof Array ? data : data.listaTarea);
	$('#taskList li').remove();
	for (var i in list){
		$('#taskList').append('<li>'+ list[i].id +"-->"+ list[i].task +'</li>');
	}
	//$.each(list, function(index, task) {
	//	$('#wineList').append('<li><a href="#" data-identity="' + task.id + '">'+task.name+'</a></li>');
	//});
}

function showList(data) {
// JAX-RS serializes an empty list as null, and a 'collection of one' as an object (not an 'array of one')
	//var list = data == null ? []  : (data instanceof Array ? data : [data]);
	$('#taskList li').remove();
	var tasks = data.listaTareas;
	for (var i in tasks){
		$('#taskList').append('<li>'+ task[i].task +'</li>');
	}
}

function showDetailsAnTask(task) {
	$('#taskId').val(task.id);
	$('#task').val(task.task);
	$('#context').val(task.context);
	$('#proyect').val(task.proyect);
	$('#priority').val(task.priority);
}

// Helper function to serialize all the form fields into a JSON string
function formToJSON() {
	return JSON.stringify({
		task: $('#task').val(),
		context: $('#context').val(),
		proyect: $('#proyect').val(),
		priority: $('#priority').val()
	});
}