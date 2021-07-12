$(document).on("click", "#btnbuscar", function() {
	
	$("#tblfaltas > tbody").html("");
	
	
	var nivel = $("#cbonivel").val();
	var grado = $("#cbogrado").val();
	var seccion = $("#cboseccion").val();
	if (nivel === "0" && grado === "0" && seccion === "0") {
		$("#tblalumno").hide();
		$("#tblalumno").html("");
		alert("Seleccione un nivel");
	} else {
		$.ajax({
			type: "GET",
			url: "/Justificaciones/frmAlumnosxAula",
			data: {
				nivel: nivel,
				grado: grado,
				seccion: seccion
			},
			success: function(resultado) {
				
				$("#tblalumnos > tbody").html("");
				$.each(resultado, function(index, value){
				$("#tblalumnos > tbody").append("<tr>"+
				"<td class='text-center'>"+ value.idalumno + "</td>"+
				"<td class='text-center'>"+ value.nombrecompleto + "</td>"+
				"<td class='text-center'><button type='button' class='btn btn-info btncargarjusti' " +
					" data-codalumno='" + value.idalumno + "'>Faltas</button>" +
					"</td>" +
				"</tr>");
				
				$("#modaljustificacion").modal("show");
				
					
				
					var date = new Date();
					var hoy = date.toLocaleDateString();
					$("#txtfa").val(hoy);
			})}
		});	
	}
});



$(document).on("click", ".btncargarjusti", function() {
	var alumno = $(this).attr("data-codalumno");
	
		$.ajax({
			type: "GET",
			url: "/Justificaciones/frmFaltasXAlumno",
			data: {
				idalumno: alumno,
			},
			success: function(resultado) {
				
				$("#tblfaltas > tbody").html("");
				$.each(resultado, function(index, value){
				$("#tblfaltas > tbody").append("<tr>"+
				"<td class='text-center'>"+ value.idalumno + "</td>"+
				"<td class='text-center'>"+ value.idasistencia + "</td>"+
				"<td class='text-center'>"+ value.fecha + "</td>"+
				"<td class='text-center'>"+ value.estado + "</td>"+
				//"<td class='text-center'>"+ value.comentario + "</td>"+
				"<td class='text-center'><button type='button' class='btn btn-info btnregistrarjusti' " +
					" data-alumno='" + value.idalumno + "'" +
					" data-fecha='" + value.fecha + "'" +
					" data-codasistencia='" + value.idasistencia + "'>Justificar</button>" +
					"</td>" +
				"</tr>");
				

					
					/*var date = new Date();
					var hoy = date.toLocaleDateString();
					$("#txtfa").val(hoy);*/
			})}
		});	
});


$(document).on("click", ".btnregistrarjusti", function() {
	$("#txta").val($(this).attr("data-alumno"));
	$("#txtc").val($(this).attr("data-codasistencia"));
	$("#txtf").val($(this).attr("data-fecha"));
});


$(document).on("click", "#btnregistrarjustificacion", function(){
alert($("#txtc").val())
if($("#txtdescripcion").val() === ""){
		$("#errordescripcion").text("Es obligatorio ingresar el motivo de la falta");
	}else{$("#errordescripcion").text("");}

	
	if ($("#txtdescripcion").val() !== "") {
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: "/Justificaciones/registrarJustificacion",
				data: JSON.stringify({
					idasistencia: $("#txtc").val(),
					fecha_falta: $("#txtf").val(),
					fecha_justi: $("#txtfa").val(),
					descripcion: $("#txtdescripcion").val(),
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
						ListarFaltas($("#txta").val())
				}else{
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
						  icon: 'error',
						  title: resultado.mensaje
						})
				}
			}
			});
	}
});


function ListarFaltas(codalumno) {
	$.ajax({
		type: "GET",
		url: "/Justificaciones/frmFaltasXAlumno",
		data:{
			idalumno: codalumno,
		},
		dataType: 'json',
		success: function(resultado){
			$("#tblfaltas > tbody").html("");
				$.each(resultado, function(index, value){
				$("#tblfaltas > tbody").append("<tr>"+
				"<td class='text-center'>"+ value.idalumno + "</td>"+
				"<td class='text-center'>"+ value.idasistencia + "</td>"+
				"<td class='text-center'>"+ value.fecha + "</td>"+
				"<td class='text-center'>"+ value.estado + "</td>"+
				//"<td class='text-center'>"+ value.comentario + "</td>"+
				"<td class='text-center'><button type='button' class='btn btn-info btnregistrarjusti' " +
					" data-alumno='" + value.idalumno + "'" +
					" data-fecha='" + value.fecha + "'" +
					" data-codasistencia='" + value.idasistencia + "'>Justificar</button>" +
					"</td>" +
				"</tr>");
			});			
		}
	});
}