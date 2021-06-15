function validar(e) { // 1
tecla = (document.all) ? e.keyCode : e.which; // 2
if (tecla==8) return true; // 3
patron =/[A-Za-z\s]/; // 4
te = String.fromCharCode(tecla); // 5
return patron.test(te); // 6
}




$(document).on("click", "#btnagregarcargo", function() {
	$("#txtnomcargo").val("");
	$("#hddidcargo").val("0");
	$("#modalcargo").modal("show");
});

$(document).on("click", ".btnactualizarcargo", function() {
	$("#txtnomcargo").val($(this).attr("data-nomcargo"));
	$("#hddidcargo").val($(this).attr("data-codcargo"));
	$("#modalcargo").modal("show");
});

$(document).on("click", "#btnregistrarcargo", function() {
	if ($("#txtnomcargo").val() === "") {
		$("#errornomcargo").text("Es obligatorio el nombre del cargo.");
	} else {
		$("#errornomcargo").text("");
	}
	if ($("#txtnomcargo").val() !== "") {
		if ($("#hddidcargo").val() === "0") {
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: "/Cargo/registrarCargo",
				data: JSON.stringify({
					nombre: $("#txtnomcargo").val(),
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
					ListarCargos();
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
				$("#modalcargo").modal("hide");
			}
			});
		} else {
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: "/Cargo/registrarCargo",
				data: JSON.stringify({
					idcargo: $("#hddidcargo").val(),
					nombre: $("#txtnomcargo").val(),
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
					ListarCargos();
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
				$("#modalcargo").modal("hide");
			}
			});
		}
		$("#modalcargo").modal("hide");
	}


});

$(document).on("click", ".btneliminarcargo", function() {
	//alert($(this).attr("data-codcurso"));
	$("#mensajeeliminar").text("¿Está seguro de eliminar el cargo: " +
		$(this).attr("data-nomcargo") + "?");
	$("#hddidcargoeliminar").val($(this).attr("data-codcargo"));
	$("#modaleliminarcargo").modal("show");
});

$(document).on("click", "#btneliminarcargo", function() {
	$.ajax({
		type: "DELETE",
		contentType: "application/json",
		url: "/Cargo/eliminarCargo",
		data: JSON.stringify({
			idcargo: $("#hddidcargoeliminar").val()
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
					ListarCargos();
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
				$("#modaleliminarcargo").modal("hide");
			}
	});
});
/*
$(document).on("input", "#txtcredcurso", function() {
	this.value = this.value.replace(/[^0-9]/g, '');
});*/

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



function ListarCargos() {
	$.ajax({
		type: "GET",
		url: "/Cargo/listarCargos",
		dataType: "json",
		success: function(resultado) {
			$("#tblcargo > tbody").html("");
			$.each(resultado, function(index, value) {
				$("#tblcargo > tbody").append("<tr>" +
					"<td>" + value.idcargo + "</td>" +
					"<td>" + value.nombre + "</td>" +
					"<td>" + value.estado + "</td>" +
					"<td><button type='button' class='btn btn-info btnactualizarcargo' " +
					" data-codcargo='" + value.idcargo + "'" +
					" data-nomcargo='" + value.nombre + "'" +
					" data-estado='" + value.estado + "'>Actualizar</button>" +
					"</td>" +
					"<td><button type='button' class='btn btn-danger btneliminarcargo' " +
					" data-codcargo='" + value.idcargo + "'" +
					" data-nomcargo='" + value.nombre + "'>Eliminar</button>" +
					"</td></tr>")
			})

		}
	})
}
