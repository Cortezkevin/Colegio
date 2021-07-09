
/*$(document).on(function(){
	var date = new Date();
	var hoy = date.toLocaleDateString();
	$("#txtf").val(hoy);
})*/


$(document).on("click", "#btnregistrarasistencia", function(){
	var profesor = $("#cboprofesor").val();
	if (profesor === "0") {
		$("#errorprofesor").text("Es obligatorio seleccionar un profesor");
	}
	var estado = $("#cboestado").val();
	if (estado === "0") {
		$("#errorestado").text("Es obligatorio seleccionar un estado");
	}
	
	if ($("#cboestado").val() !== "0" && $("#cboprofesor").val() !== "0") {
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: "/AsistenciaProfesor/registrarAsistencia",
				data: JSON.stringify({
					idprofesor: $("#cboprofesor").val(),
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
						ListarAsistencias();
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



function ListarAsistencias() {
	$.ajax({
		type: "GET",
		url: "/AsistenciaProfesor/frmReporteAsistencia",
		dataType: 'json',
		success: function(resultado){
			$("#tblasistencia > tbody").html("");
			$.each(resultado, function(index, value){
				$("#tblasistencia > tbody").append("<tr>"+
				"<td>"+ value.nombreprofesor + "</td>"+
				"<td class='text-center'>"+ value.asis + "</td>"+
				"<td class='text-center'>"+ value.inasis + "</td>"+
				"<td class='text-center'>"+ value.tard + "</td>"+
				"</tr>");
			});			
		}
	});
}
