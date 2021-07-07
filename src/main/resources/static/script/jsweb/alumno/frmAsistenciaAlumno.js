
/*$(document).on("click", "#btnregistrarasistencia", function() {
	
	var estado = $("#cboestado").val();
	if (estado === "0") {
		$("#errorestado").text("Es obligatorio seleccionar un estado");
	}
	
});*/

$(document).on("click", "#btnbuscar", function() {
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
			url: "/AsistenciaAlumno/frmAlumnosxAula",
			data: {
				nivel: nivel,
				grado: grado,
				seccion: seccion
			},
			success: function(resultado) {
				
				$("#cboalumno").append(
					"<option value= 0 >Seleccione</option>"
				);
				$.each(resultado, function(index, value){
				$("#cboalumno").append(
					"<option value='"+value.idalumno+"'>"+value.nombrecompleto+"</option>"
				)});
				
				$("#modalasistencia").modal("show");
				
					var date = new Date();
					var hoy = date.toLocaleDateString();
					$("#txtf").val(hoy);
			}

		});
		$("#cboalumno").empty();
		/*$(document).on("change", "#cboalumno", function(){
	 		alert($("#cboalumno").val())
	 		alert($("#txtfecha").val())
			$.ajax({
				type: "GET",
				url: "/AsistenciaAlumno/frmIdAsistenciaAlumnoXFecha",
				data:{
					idalumno: $("#cboalumno").val(),
					fecha: $("#txtfecha").val()
			},
			//dataType: 'json',
			success: function(resultado){
				
				alert(resultado);
				$("#hddidasistencia").val() == resultado;
				
			}
			});
		});*/
		
		
		
		
		
		
	}
});

$(document).on("click", "#btnregistrarasistencia", function(){
	/*alert("hola");
	alert($("#txtfecha").val())
	
	alert($("#cboalumno").val())*/
	//var fecha = $("#txtfecha").val();
	var alumno = $("#cboalumno").val();
	if (alumno === "0") {
		$("#erroralumno").text("Es obligatorio seleccionar un alumno");
	}
	var estado = $("#cboestado").val();
	if (estado === "0") {
		$("#errorestado").text("Es obligatorio seleccionar un estado");
	}
	
	if ($("#cboestado").val() !== "0" && $("#cboalumno").val() !== "0") {
		if ($("#hddidasistencia").val() === "0") {
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: "/AsistenciaAlumno/registrarAsistencia",
				data: JSON.stringify({
					idalumno: $("#cboalumno").val(),
					fecha: $("#txtf").val(),
					estado: $("#cboestado").val(),
					comentario: $("#txtcomentario").val(),
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
		else {
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: "/AsistenciaAlumno/registrarAsistencia",
				data: JSON.stringify({
					idasistencia: $("#hddidasistencia").val(),
					estado:$("#cboestado").val(),
					comentario: $("#txtcomentario").val()
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
	}
});

