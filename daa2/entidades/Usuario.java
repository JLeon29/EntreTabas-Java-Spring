package idat.edu.pe.daa2.entidades;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty
	private String nombre;
	
	@NotNull
	@Positive
	@Max(value=99999999)
	private Integer dni;
	
	@NotNull
	@Positive
	private Integer telefono;
	
	@NotEmpty
	@Email
	private String email;
	
	
	private Date fechaRegistro;
	
	@NotEmpty
	private String username;
	
	@NotEmpty
	private String password;
	

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "usuarioperfil", joinColumns = @JoinColumn(name = "idUsuario"), inverseJoinColumns = @JoinColumn(name = "idPerfil"))
	private List<Perfil> perfiles;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
	private List<Solicitud> solicitudList;

	public void agregar(Perfil tempPerfil) {

		if (perfiles == null) {
			perfiles = new LinkedList<>(); 
		}
		perfiles.add(tempPerfil); 

	}

	public Usuario() {
		super();
	}

	
	

	

	public Usuario(Integer id, String nombre, Integer dni, Integer telefono, String email, Date fechaRegistro,
			String username, String password, List<Perfil> perfiles, List<Solicitud> solicitudList) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.dni = dni;
		this.telefono = telefono;
		this.email = email;
		this.fechaRegistro = fechaRegistro;
		this.username = username;
		this.password = password;
		this.perfiles = perfiles;
		this.solicitudList = solicitudList;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public List<Perfil> getPerfiles() {
		return perfiles;
	}

	public void setPerfiles(List<Perfil> perfiles) {
		this.perfiles = perfiles;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public List<Solicitud> getSolicitudList() {
		return solicitudList;
	}

	public void setSolicitudList(List<Solicitud> solicitudList) {
		this.solicitudList = solicitudList;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", dni=" + dni + ", telefono=" + telefono + ", email="
				+ email + ", fechaRegistro=" + fechaRegistro + ", username=" + username + ", password=" + password
				+ ", perfiles=" + perfiles + ", solicitudList=" + solicitudList + "]";
	}

	

	

}
