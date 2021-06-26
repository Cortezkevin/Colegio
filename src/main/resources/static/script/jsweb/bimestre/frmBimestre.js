$(document).on("click", "#btnagregarbimestre", function() {
	$("#txtnombimestre").val("");
	$("#hddidbimestre").val("0");
	$("#modalbimestre").modal("show");
});

$(document).on("click", ".btnactualizarbimestre", function() {
	$("#txtnombimestre").val($(this).attr("data-nombimestre"));
	$("#hddidbimestre").val($(this).attr("data-codbimestre"));
	$("#modalbimestre").modal("show");
});

$(document).on("click", "#btnregistrarbimestre", function() {
	if ($("#txtnombimestre").val() === "") {
		$("#errornombimestre").text("Es obligatorio el nombre del bimestre.");
	} else {
		$("#errornombimestre").text("");
	}
	if ($("#txtnombimestre").val() !== "") {
		if ($("#hddidbimestre").val() === "0") {
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: "/Bimestre/registrarBimestre",
				data: JSON.stringify({
					nombre: $("#txtnombimestre").val(),
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
					ListarBimestres();
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
				$("#modalbimestre").modal("hide");
			}
			});
		} else {
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: "/Bimestre/registrarBimestre",
				data: JSON.stringify({
					idbimestre: $("#hddidbimestre").val(),
					nombre: $("#txtnombimestre").val(),
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
					ListarBimestre();
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
				$("#modalbimestre").modal("hide");
			}
			});
		}
		$("#modalbimestre").modal("hide");
	}


});

$(document).on("click", ".btneliminarbimestre", function() {
	//alert($(this).attr("data-codcurso"));
	$("#mensajeeliminar").text("¿Está seguro de eliminar el bimestre: " +
		$(this).attr("data-nombimestre") + "?");
	$("#hddidbimestreeliminar").val($(this).attr("data-codbimestre"));
	$("#modaleliminarbimestre").modal("show");
});

$(document).on("click", "#btneliminarbimestre", function() {
	$.ajax({
		type: "DELETE",
		contentType: "application/json",
		url: "/Bimestre/eliminarBimestre",
		data: JSON.stringify({
			idbimestre: $("#hddidbimestreeliminar").val()
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
					ListarBimestre();
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
				$("#modaleliminarbimestre").modal("hide");
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



function ListarBimestre() {
	$.ajax({
		type: "GET",
		url: "/Bimestre/listarBimestre",
		dataType: "json",
		success: function(resultado) {
			$("#tblbimestre > tbody").html("");
			$.each(resultado, function(index, value) {
				$("#tblbimestre > tbody").append("<tr>" +
					"<td>" + value.idbimestre + "</td>" +
					"<td>" + value.nombre + "</td>" +
					"<td>" + value.estado + "</td>" +
					"<td><button type='button' class='btn btn-info btnactualizarbimestre' " +
					" data-codbimestre='" + value.idbimestre + "'" +
					" data-nombimestre='" + value.nombre + "'" +
					" data-estado='" + value.estado + "'>Actualizar</button>" +
					"</td>" +
					"<td><button type='button' class='btn btn-danger btneliminarbimestre' " +
					" data-codbimestre='" + value.idbimestre + "'" +
					" data-nombimestre='" + value.nombre + "'>Eliminar</button>" +
					"</td></tr>")
			})

		}
	})
}
