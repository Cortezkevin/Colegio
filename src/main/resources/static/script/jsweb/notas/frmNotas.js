$(document).ready(function(){
	$("#tblalumno").hide();
});

$(document).on("change", "#cbonivel", function(){
	//alert($("#cboespecialidad").val());
	var nivel = $("#cbonivel").val();
	if(nivel === "0"){
		$("#tblalumno").hide();
		$("#tblalumno").html("");
		alert("Seleccione un nivel");
	}else{
		$.ajax({
			type: "GET",
			url: "/Notas/frmAlumnosxAula",
			data: {
				nivel: nivel
			},
			success: function(resultado){
				//console.log(resultado);
				$("#tblalumno").html("");
				$.each(resultado, function(index, value){
					procedencia = value.proce == "P" ? "Particular" : "Estatal";
					$("#tblalumno").append("<div class='col mb-4'>"+
					"<div class='card border-primary bg-primary h-100'>"+
					"<img src='/img/silueta.jpg' class='card-img-top'>"+
					"<div class='card-body'>"+
					"<h5 class='card-title text-white'>Codigo: "+value.idalumno+"</h5>"+
					"<p class='card-text text-white'>"+value.nombrecompleto+ "<br />" +
					"Procedencia: "+ procedencia + 	"<br />" +			
					"<button data-codalumno='"+value.apoderado+
					"' type='button' class='btn btn-dark btnvernotas'>Ver Notas</button>"+
					"</p></div></div></div>");
					$("#tblalumno").show();
				});
			}
		});
	}
});