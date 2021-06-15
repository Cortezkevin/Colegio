$(document).on("click", "#btnagregarprofesor", function() {
	$("#cbopersona").val("0");
	$("#cbousuario").val("0");
	
	$("#hddidprofesor").val("0");
	$("#modalprofesor").modal("show");
});

$(document).on("click", ".btnactualizarprofesor", function() {
	$("#cbopersona").val($(this).attr("data-codpersona"));
	$("#cbousuario").val($(this).attr("data-codusuario"));
	
	$("#hddidprofesor").val($(this).attr("data-codprofesor"));
	$("#modalprofesor").modal("show");
});


$(document).on("click", "#btnregistrarprofesor", function() {
	
	var idpersona = $("#cbopersona").val();
	if(idpersona === "0"){
		$("#errorpersona").text("Es obligatorio seleccionar una persona.");
	}
	
	var idusuario = $("#cbousuario").val();
	if(idusuario === "0"){
		$("#errorusuario").text("Es obligatorio seleccionar un usuario.");
	}
	
	if ($("#cbopersona").val() !== "0") {
		if ($("#hddidalumno").val() === "0") {
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: "/Profesor/registrarProfesor",
				data: JSON.stringify({
					idpersona: $("#cbopersona").val(),
					idusuario: $("#cbousuario").val(),
				}),
				success: function(resultado){
				if(resultado.respuesta){
					
					/*Swal.fire({
					//title: resultado.mensaje,
					confirmButtonText: 'Acepto',
					icon: 'info'
					});*/
					const Toast = Swal.mixin({
						  toast: true,
						  position: 'top-end',
						  showConfirmButton: false,
						  timer: 3000,
						  timerProgressBar: true,
						  didOpen: (toast) => {
						    //toast.addEventListener('mouseenter', Swal.stopTimer)
						    toast.addEventListener('mouseleave', Swal.resumeTimer)
						  }
						})
						
						Toast.fire({
						  icon: 'success',
						  title: resultado.mensaje
						})
					ListarProfesor();;
				}else{
					const Toast = Swal.mixin({
						  toast: true,
						  position: 'top-end',
						  showConfirmButton: false,
						  timer: 3000,
						  timerProgressBar: true,
						  didOpen: (toast) => {
						    //toast.addEventListener('mouseenter', Swal.stopTimer)
						    toast.addEventListener('mouseleave', Swal.resumeTimer)
						  }
						})
						
						Toast.fire({
						  icon: 'error',
						  title: resultado.mensaje
						})
				}
				$("#modalprofesor").modal("hide");
			}
			});
		} 
		else {
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: "/Profesor/registrarProfesor",
				data: JSON.stringify({
					idalumno: $("#hddidalumno").val(),
					idpersona: $("#cbopersona").val(),
					idusuario: $("#cbousuario").val()
				}),
				success: function(resultado){
				if(resultado.respuesta){
					
					/*Swal.fire({
					//title: resultado.mensaje,
					confirmButtonText: 'Acepto',
					icon: 'info'
					});*/
					const Toast = Swal.mixin({
						  toast: true,
						  position: 'top-end',
						  showConfirmButton: false,
						  timer: 3000,
						  timerProgressBar: true,
						  didOpen: (toast) => {
						    //toast.addEventListener('mouseenter', Swal.stopTimer)
						    toast.addEventListener('mouseleave', Swal.resumeTimer)
						  }
						})
						
						Toast.fire({
						  icon: 'success',
						  title: resultado.mensaje
						})
					ListarProfesor();;
				}else{
					const Toast = Swal.mixin({
						  toast: true,
						  position: 'top-end',
						  showConfirmButton: false,
						  timer: 3000,
						  timerProgressBar: true,
						  didOpen: (toast) => {
						    //toast.addEventListener('mouseenter', Swal.stopTimer)
						    toast.addEventListener('mouseleave', Swal.resumeTimer)
						  }
						})
						
						Toast.fire({
						  icon: 'error',
						  title: resultado.mensaje
						})
				}
				$("#modalprofesor").modal("hide");
			}
			});
		}
		$("#modalprofesor").modal("hide");
	}


});

$(document).on("click", ".btneliminarprofesor", function() {
	$("#mensajeeliminar").text("¿Está seguro de eliminar al Profesor: " +
		$(this).attr("data-codpersona") + "?");
	$("#hddidprofesoreliminar").val($(this).attr("data-codprofesor"));
	$("#modaleliminarprofesor").modal("show");
});

$(document).on("click", "#btneliminarprofesor", function() {
	$.ajax({
		type: "DELETE",
		contentType: "application/json",
		url: "/Profesor/eliminarProfesor",
		data: JSON.stringify({
			idprofesor: $("#hddidprofesoreliminar").val()
		}),
		success: function(resultado){
				if(resultado.respuesta){
					const Toast = Swal.mixin({
						  toast: true,
						  position: 'top-end',
						  showConfirmButton: false,
						  timer: 3000,
						  timerProgressBar: true,
						  didOpen: (toast) => {
						    //toast.addEventListener('mouseenter', Swal.stopTimer)
						    toast.addEventListener('mouseleave', Swal.resumeTimer)
						  }
						})

						Toast.fire({
						  icon: 'success',
						  title: resultado.mensaje
						})
					ListarProfesor();
				}else{
					const Toast = Swal.mixin({
						  toast: true,
						  position: 'top-end',
						  showConfirmButton: false,
						  timer: 3000,
						  timerProgressBar: true,
						  didOpen: (toast) => {
						    //toast.addEventListener('mouseenter', Swal.stopTimer)
						    toast.addEventListener('mouseleave', Swal.resumeTimer)
						  }
						})
						
						Toast.fire({
						  icon: 'error',
						  title: resultado.mensaje
						})
				}
				$("#modaleliminarprofesor").modal("hide");
			}
	});
});


function mostrarMensaje(mensaje, estilo) {
	$("#mensaje").html("");
	$("#mensaje").append("<div class='alert alert-" + estilo
		+ " alert-dismissible fade show' role='alert'>"
		+ "<strong>" + mensaje + "</strong>"
		+ "<button type='button' class='close' data-dismiss='alert'"
		+ " aria-label='Close'>"
		+ "<span aria-hidden='true'>&times;</span></button></div>"
	);
}

function ListarProfesor() {
	$.ajax({
		type: "GET",
		url: "/Profesor/listarProfesor",
		dataType: "json",
		success: function(resultado) {
			$("#tblprofesor > tbody").html("");
			$.each(resultado, function(index, value) {
				$("#tblprofesor > tbody").append("<tr>" +
					"<td>" + value.idalumno + "</td>" +
					"<td>" + value.idusuario + "</td>" +
					"<td>" + value.estado + "</td>" +
					"<td><button type='button' class='btn btn-info btnactualizarprofesor' " +
					" data-codprofesor='" + value.idprofesor + "'" +
					" data-codusuario='" + value.idusuario + "'" +
					" data-estado='" + value.estado + "'>Actualizar</button>" +
					"</td>" +
					"<td><button type='button' class='btn btn-danger btneliminarprofesor' " +
					" data-codprofesor='" + value.idprofesor + "'" +
					" data-codpersona='" + value.idpersona + "'>Eliminar</button>" +
					"</td></tr>")
			})
		}
	})
}

