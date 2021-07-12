/*$(document).on("click", "#btnagregarhorario", function() {
	$("#txthoraini").val("");
	$("#txthorafin").val("");
	$("#hddidhorario").val("0");
	$("#hddidcurso").val("0");
	$("#modalhorario").modal("show");
});*/
$(document).on("click", "#btnbuscar", function() {
	var nivel = $("#cbonivel").val();
	var grado = $("#cbogrado").val();
	var seccion = $("#cboseccion").val();
	if (nivel === "0" && grado === "0" && seccion === "0") {
		$("#tblhorario").hide();
		$("#tblhorario").html("");
		alert("Seleccione un nivel");
	} else {
		$.ajax({
			type: "GET",
			url: "/Horario/listarHorario",
			data: {
				nivel: nivel,
				grado: grado,
				seccion: seccion
			},
			success: function(resultado) {		
			$("#tblhorario > tbody").html("");
			$.each(resultado, function(index, value){
				$("#tblhorario > tbody").append("<tr>"+
				"<td>"+ value.dia + "</td>"+
				"<td class='text-center'>"+ value.curso + "</td>"+
				"<td class='text-center'>"+ value.hora_inicio + "</td>"+
				"<td class='text-center'>"+ value.hora_fin + "</td>"+
				"<td class='text-center'>"+ value.estado + "</td>"+
				"<td><button type='button' class='btn btn-info btnactualizarhorario' " +
					//" data-nivel='" + $("#cbonivel").val() + "'" +
					//" data-grado='" + $("#cbogrado").val() + "'" +
					//" data-seccion='" + $("#cboseccion").val() + "'" +
					" data-codhorario='" + value.idhorario + "'" +
					" data-dia='" + value.dia + "'" +
					" data-curso='" + value.curso + "'" +										
					" data-horaI='" + value.hora_inicio + "'" +
					" data-horaF='" + value.hora_fin + "'>Actualizar</button>" +
					"</td>" +
				"</tr>");
			});		
				$("#nivel").val(nivel);
				$("#grado").val(grado);
				$("#seccion").val(seccion);
				$("#modalhorario").modal("show");
				
				$("#txtdia").val("");
				$("#txthoraini").val("");
				$("#txthorafin").val("");
				$("#hddidhorario").val("0");
				$("#hddidcurso").val("0");
			}

		});
	}
});

$(document).on("click", "#btnlimpiarcampos", function() {
	$("#txtdia").val("");
	$("#txthoraini").val("");
	$("#txthorafin").val("");
	$("#hddidhorario").val("0");
	$("#cbocurso").val("0");
	$("#hddidhorario").val("0");
});


$(document).on("click", ".btnactualizarhorario", function() {
	$("#txtdia").val($(this).attr("data-dia"));
	$("#txthoraini").val($(this).attr("data-horaI"));
	$("#txthorafin").val($(this).attr("data-horaF"));
	$("#cbocurso").val($(this).attr("data-curso"));
	$("#hddidhorario").val($(this).attr("data-codhorario"));
});


$(document).on("click", "#btnregistrarhorario", function() {

	var idcurso = $("#cbocurso").val();
		if (idcurso === "0") {
		$("#errorcurso").text("Es obligatorio seleccionar un curso.");
	}
	if ($("#txtdia").val() === "") {
		$("#errordia").text("Es obligatorio ingresar un dia.");
	} else {
		$("#errorhorafinal").text("");
	}
	if ($("#txthorafin").val() === "") {
		$("#errorhorafin").text("Es obligatorio la hora final.");
	} else {
		$("#errorhorafinal").text("");
	}
	if ($("#txthoraini").val() === "") {
		$("#errorhoraini").text("Es obligatorio la hora Inicial.");
	} else {
		$("#errorhoraini").text("");
	}
	if ($("#txthoraini").val() !== "" && $("#txthorafin") !== "" && $("#txtdia") !== "" && idcurso !== "0") {
		if ($("#hddidhorario").val() === "0") {
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: "/Horario/registrarHorario",
				data: JSON.stringify({
					nivel: $("#nivel").val(),
					grado: $("#grado").val(),
					seccion: $("#seccion").val(),
					dia: $("#txtdia").val(),				
					curso: $("#cbocurso").val(),
					hora_inicio: $("#txthoraini").val(),					
					hora_fin: $("#txthorafin").val(),

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
					ListarHorario($("#nivel").val(),$("#grado").val(),$("#seccion").val());
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
				//$("#modalhorario").modal("hide");
			}
			});
		} else {
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: "/Horario/actualizarHorario",
				data: JSON.stringify({
					idhorario: $("#hddidhorario").val(),
					dia: $("#txtdia").val(),
					curso: $("#cbocurso").val(),	
					hora_inicio: $("#txthoraini").val(),				
					hora_fin: $("#txthorafin").val(),
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
						    toast.addEventListener('mouseleave', Swal.resumeTimer)
						  }
						})
						
						Toast.fire({
						  icon: 'success',
						  title: resultado.mensaje
						})
					ListarHorario($("#nivel").val(),$("#grado").val(),$("#seccion").val());
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
				//$("#modalhorario").modal("hide");
			}
			});
		}
	}


});

$(document).on("click", ".btneliminarhorario", function() {
	$("#mensajeeliminar").text("¿Está seguro de eliminar el horario: " +
		$(this).attr("data-horaini") + "?");
	$("#hddidhorarioeliminar").val($(this).attr("data-codhorario"));
	$("#modaleliminarhorario").modal("show");
});

$(document).on("click", "#btneliminarhorario", function() {
	$.ajax({
		type: "DELETE",
		contentType: "application/json",
		url: "/horario/eliminarHorario",
		data: JSON.stringify({
			idhorario: $("#hddidhorarioeliminar").val()
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
					ListarHorario($("#nivel").val(),$("#grado").val(),$("#seccion").val());
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
				$("#modaleliminarhorario").modal("hide");
			}
	});
});

/*
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
*/


function ListarHorario(nivel, grado, seccion) {
	$.ajax({
			type: "GET",
			url: "/Horario/listarHorario",
			data: {
				nivel: nivel,
				grado: grado,
				seccion: seccion
			},
			success: function(resultado) {		
			$("#tblhorario > tbody").html("");
			$.each(resultado, function(index, value){
				$("#tblhorario > tbody").append("<tr>"+
				"<td>"+ value.dia + "</td>"+
				"<td class='text-center'>"+ value.curso + "</td>"+
				"<td class='text-center'>"+ value.hora_inicio + "</td>"+
				"<td class='text-center'>"+ value.hora_fin + "</td>"+
				"<td class='text-center'>"+ value.estado + "</td>"+
				"<td><button type='button' class='btn btn-info btnactualizarhorario' " +
					//" data-nivel='" + $("#cbonivel").val() + "'" +
					//" data-grado='" + $("#cbogrado").val() + "'" +
					//" data-seccion='" + $("#cboseccion").val() + "'" +
					" data-codhorario='" + value.idhorario + "'" +
					" data-dia='" + value.dia + "'" +
					" data-curso='" + value.curso + "'" +										
					" data-horaI='" + value.hora_inicio + "'" +
					" data-horaF='" + value.hora_fin + "'>Actualizar</button>" +
					"</td>" +
				"</tr>");
			});		
			}

		});
}
