function validar(e) { // 1
tecla = (document.all) ? e.keyCode : e.which; // 2
if (tecla==8) return true; // 3
patron =/[A-Za-z\s]/; // 4
te = String.fromCharCode(tecla); // 5
return patron.test(te); // 6
}


$(document).on("click", "#btnagregarapoderado", function() {
	$("#txtnomapoderado").val("");
	$("#hddidapoderado").val("0");
	$("#cbopersona").val("0");
	$("#modalapoderado").modal("show");
});

$(document).on("click", ".btnactualizarapoderado", function() {
	$("#txtnomapoderado").val($(this).attr("data-nomapoderado"));
	$("#hddidapoderado").val($(this).attr("data-codapoderado"));
	$("#cbopersona").val($(this).attr("data-codpersona"));
	$("#modalapoderado").modal("show");
});

$(document).on("click", "#btnregistrarapoderado", function() {
	if ($("#txtnomapoderado").val() === "") {
		$("#errornomapoderado").text("Es obligatorio el nombre del apoderado.");
	} else {
		$("#errornomapoderado").text("");
	}
	if ($("#txtnomapoderado").val() !== "") {
		if ($("#hddidapoderado").val() === "0") {
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: "/Apoderado/registrarApoderado",
				data: JSON.stringify({
					idpersona: $("#cbopersona").val()
				}),
				success: function(resultado) {
					var estilo = "danger";
					if (resultado.respuesta) {
						estilo = "success";
						ListarApoderado();
					}
					mostrarMensaje(resultado.mensaje, estilo);
				}
			});
		} else {  
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: "/Apoderado/registrarApoderado",
				data: JSON.stringify({
					idapoderado: $("#hddidapoderado").val(),
					idpersona: $("#cbopersona").val()
				}),   
				success: function(resultado) {
					var estilo = "danger";
					if (resultado.respuesta) {
						estilo = "success";
						ListarApoderado();
					}
					mostrarMensaje(resultado.mensaje, estilo);
				}
			});
		}
		$("#modalapoderado").modal("hide");
	}


});

$(document).on("click", ".btneliminarapoderado", function() {
	$("#mensajeeliminar").text("¿Está seguro de eliminar al Apoderado: " +
		$(this).attr("data-nomapoderado") + "?");
	$("#hddidapoderadoeliminar").val($(this).attr("data-codapoderado"));
	$("#modaleliminarapoderado").modal("show");
});

$(document).on("click", "#btneliminarapoderado", function() {
	$.ajax({
		type: "DELETE",
		contentType: "application/json",
		url: "/Apoderado/eliminarApoderado",
		data: JSON.stringify({
			idapoderado: $("#hddidapoderadoeliminar").val()  
		}),
		success: function(resultado) {
			var estilo = "danger";
			if (resultado.respuesta) {
				estilo = "success";
				ListarApoderado();
			}
			mostrarMensaje(resultado.mensaje, estilo);
			$("#modaleliminarApoderado").modal("hide");
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



function ListarApoderado() {
	$.ajax({
		type: "GET",
		url: "/Apoderado/listarApoderado",
		dataType: "json",
		success: function(resultado) {
			$("#tblapoderado > tbody").html("");
			$.each(resultado, function(index, value) {
				$("#tblapoderado > tbody").append("<tr>" +
					"<td>" + value.idapoderado + "</td>" +
					"<td>" + value.idpersona + "</td>" +
					"<td>" + value.nombrecompleto + "</td>" +
					"<td>" + value.estado + "</td>" +
					"<td><button type='button' class='btn btn-info btnactualizarapoderado' " +
					" data-codapoderado='" + value.idapoderado + "'" +
					" data-codpersona='" + value.idapersona + "'" +
					" data-nomapoderado='" + value.nombrecompleto + "'" +
					" data-estado='" + value.estado + "'>Actualizar</button>" +
					"</td>" +
					"<td><button type='button' class='btn btn-danger btneliminarapoderado' " +
					" data-codapoderado='" + value.idapoderado + "'" +
					" data-codapersona='" + value.idpersona + "'" +
					" data-nomapoderado='" + value.nombrecompleto + "'>Eliminar</button>" +
					"</td></tr>")
			})

		}
	})
}
