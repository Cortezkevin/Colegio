package golondrinas.com.interfaces;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.pdfbox.contentstream.operator.state.SetLineJoinStyle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import golondrinas.com.model.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {

	@Query(value = "{call sp_ManListarPersona()}", nativeQuery = true)
	List<Persona> listarPersona();

	@Query(value = "{call sp_MantListarPersonaXtipo1()}", nativeQuery = true)
	List<Persona> listarPersonaxtipo1();
	
	@Query(value = "{call sp_MantListarPersonaXtipo2()}", nativeQuery = true)
	List<Persona> listarPersonaxtipo2();
	
	@Query(value = "{call sp_MantListarPersonaXtipo3()}", nativeQuery = true)
	List<Persona> listarPersonaxtipo3();
	
	@Query(value = "{call sp_ManSelectPersona()}", nativeQuery = true)
	List<Persona> listarSelectPersona(); 
	
	@Transactional
	@Modifying
	@Query(value = "{call sp_MantRegistrarPersona(:tipo, :nombreper, :apellidoper, :direccionper, :telefonoper, :emailper, :dniper, :edadper, :generoper)}", nativeQuery = true)

	void registrarPersona(@Param("tipo") String tipo, @Param("nombreper") String nombre, @Param("apellidoper") String apellido,
			@Param("direccionper") String direccion, @Param("telefonoper") Integer telefono,
			@Param("emailper") String email, @Param("dniper") Integer dni, @Param("edadper") Integer edad,
			@Param("generoper") String genero);

	@Transactional
	@Modifying
	@Query(value = "{call sp_MantActualizarPersona(:idpersona,:tipo, :nombreper, :apellidoper, :direccionper, :telefonoper, :emailper, :dniper, :edadper, :generoper)}", nativeQuery = true)
	void actualizarPersona(@Param("idpersona") String idpersona,@Param("tipo") String tipo, @Param("nombreper") String nombre,
			@Param("apellidoper") String apellido, @Param("direccionper") String direccion,
			@Param("telefonoper") Integer telefono, @Param("emailper") String email, @Param("dniper") Integer dni,
			@Param("edadper") Integer edad, @Param("generoper") String genero);

	@Transactional
	@Modifying
	@Query(value = "{call sp_MantEliminarPersona(:idpersona)}", nativeQuery = true)
	void eliminarPersona(@Param("idpersona") String idpersona);

	@Query(value = "{call sp_ManListarPersonaxDNI(:dni)}", nativeQuery = true)
	List<Persona> listarPersonaxDNI(@Param("dni") Integer dni);
	
	@Query(value = "{call  sp_ManListarPersonaxTelefono(:telefono)}", nativeQuery = true)
	List<Persona> listarPersonaxTelefono(@Param("telefono") Integer telefono);
	
	@Query(value = "{call sp_ManListarPersonaxEmail(:email)}", nativeQuery = true)
	List<Persona> listarPersonaxEmail(@Param("email") String email);
	
	
	@Query(value = "{call sp_MantListarEstadoXPersona(:idpersona)}", nativeQuery = true)
	String listarEstado(@Param("idpersona") String idpersona);	
	
}