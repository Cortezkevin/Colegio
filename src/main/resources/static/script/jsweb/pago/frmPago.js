$(document).on("click", "#btnagregarpago", function() {
	$("#cbomatriculas").val("0");
	$("#txtfechapago").val("");
	$("#txtmonto").val("");
	
	
	$("#hddidpago").val("0");
	$("#modalpago").modal("show");
});

$(document).on("click", ".btnactualizarpago", function() {
	alert($(this).attr("data-codpago"));
	
	$("#cbomatriculas").val($(this).attr("data-codmatricula"));
	$("#txtfechapago").val($(this).attr("data-nomfechapago"));
	$("#txtmonto").val($(this).attr("data-monto"));
	
	$("#hddidpago").val($(this).attr("data-codpago"));
	$("#modalpago").modal("show");
});


$(document).on("click", "#btnregistrarpago", function() {
	//validar ingreso de nombre de usuario
	if ($("#txtfechapago").val() === "") {
		$("#errorfechapago").text("Es obligatorio ingresar una fecha.");
	} else {
		$("#errorfechapago").text("");
	}
	// validar ingreso contraseña
	if ($("#txtmonto").val() === "") {
		$("#errormonto").text("Es obligatorio una monto.");
	} else {
		$("#errormonto").text("");
	}
	// validar seleccion de cargo
	var idmatricula = $("#cbomatriculas").val();
	if(idmatricula === "0"){
		$("#errormatricula").text("Es obligatorio seleccionar una matricula");}
	if ($("#txtfechapago").val() !== "") {
		if ($("#hddidpago").val() === "0") {
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: "/Pago/registrarPago",
				data: JSON.stringify({
					idmatricula: $("#cbomatriculas").val(),
					fechapago: $("#txtfechapago").val(),
					monto: $("#txtmonto").val()
				}),
				success: function(resultado) {
					var estilo = "danger";
					if (resultado.respuesta) {
						estilo = "success";
						ListarPago();
					}
					mostrarMensaje(resultado.mensaje, estilo);
				}
			});
		} else {
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: "/Pago/registrarPago",
				data: JSON.stringify({
					idpago: $("hddidpago").val(),
					idmatricula: $("#cbomatriculas").val(),
					fechapago: $("#txtfechapago").val(),
					monto: $("#txtmonto").val()
				}),
				success: function(resultado) {
					var estilo = "danger";
					if (resultado.respuesta) {
						estilo = "success";
						ListarPago();
					}
					mostrarMensaje(resultado.mensaje, estilo);
				}
			});
		}
		$("#modalpago").modal("hide");
	}
});


$(document).on("click", ".btneliminarpago", function() {
	alert($(this).attr("data-codpago"));
	$("#mensajeeliminar").text("¿Está seguro de eliminar el pago de la matricula: " +
		$(this).attr("data-codmatricula") + "?");
	$("#hddidpagoeliminar").val($(this).attr("data-codpago"));
	$("#modaleliminarpago").modal("show");
});
$(document).on("click", "#btneliminarpago", function() {
	$.ajax({
		type: "DELETE",
		contentType: "application/json",
		url: "/Pago/eliminarPago",
		data: JSON.stringify({
			idpago: $("#hddidpagoeliminar").val()
		}),
		success: function(resultado) {
			var estilo = "danger";
			if (resultado.respuesta) {
				estilo = "success";
				ListarPago();
			}
			mostrarMensaje(resultado.mensaje, estilo);
			$("#modaleliminarpago").modal("hide");
		}
	});
});



function ListarPago() {
	$.ajax({
		type: "GET",
		url: "/Pago/listarPago",
		dataType: "json",
		success: function(resultado) {
			$("#tblpago > tbody").html("");
			$.each(resultado, function(index, value) {
				$("#tblpago > tbody").append("<tr>" +
					"<td>" + value.idpago + "</td>" +
					"<td>" + value.idmatricula + "</td>" +
					"<td>" + value.fechapago+ "</td>" +
					"<td>" + value.monto + "</td>" +
					"<td>" + value.estado + "</td>" +
					//"<td><button type='button' class='btn btn-success btnverdetalle' " +
					//" data-codusuario='" + value.idusuario + "'>Ver Detalle</button>" +
					//"</td>"+
					"<td><button type='button' class='btn btn-info btnactualizarpago' " +
					" data-codpago='" + value.idpago + "'" +
					" data-codmatricula='" + value.idmatricula + "'" +
					" data-fechapago='" + value.fechapago + "'" +
					" data-monto='" + value.monto + "'" +
					" data-estado='" + value.estado + "'>Actualizar</button>" +
					"</td>" +
					"<td><button type='button' class='btn btn-danger btneliminarpago' " +
					" data-codpago='" + value.idpago + "'" +
					" data-codmatricula='" + value.idmatricula + "'>Eliminar</button>" +
					"</td></tr>")
			})
		}
	})
}

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