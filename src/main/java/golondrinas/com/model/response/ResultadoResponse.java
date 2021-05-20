package golondrinas.com.model.response;

public class ResultadoResponse {
	private Boolean respuesta;
	private String mensaje;
	public Boolean getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(Boolean respuesta) {
		this.respuesta = respuesta;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public ResultadoResponse(Boolean respuesta, String mensaje) {
		super();
		this.respuesta = respuesta;
		this.mensaje = mensaje;
	}
	public ResultadoResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
