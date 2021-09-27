package idat.edu.pe.daa2.entidades;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="producto")
public class Zapatilla {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nombre;
	
	private String descripcion;
	
	private Double precio;
	
	private String imagen = "no-imagen.jpg";
	
	@ManyToOne
	@JoinColumn(name="idCategoria", referencedColumnName = "id")
	private Categoria categoria;
	
	@ManyToOne
	@JoinColumn(name="idMarca", referencedColumnName = "id")
	private Marca marca;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "zapatilla")
	private List<Solicitud> solicitudList;

	



	

	
	


	public Zapatilla(Integer id, String nombre, String descripcion, Double precio, String imagen, Categoria categoria,
			Marca marca, List<Solicitud> solicitudList) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.imagen = imagen;
		this.categoria = categoria;
		this.marca = marca;
		this.solicitudList = solicitudList;
	}


	public Zapatilla() {
		super();
	}


	public Integer getId() { 
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Double getPrecio() {
		return precio;
	}


	public void setPrecio(Double precio) {
		this.precio = precio;
	}


	public String getImagen() {
		return imagen;
	}


	public void setImagen(String imagen) {
		this.imagen = imagen;
	}


	
	
	
	


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	public Marca getMarca() {
		return marca;
	}


	public void setMarca(Marca marca) {
		this.marca = marca;
	}


	public List<Solicitud> getSolicitudList() {
		return solicitudList;
	}


	public void setSolicitudList(List<Solicitud> solicitudList) {
		this.solicitudList = solicitudList;
	}
	
	public void reset() {
		this.imagen= null;
	}


	@Override
	public String toString() {
		return "Zapatilla [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio
				+ ", imagen=" + imagen + ", categoria=" + categoria + ", marca=" + marca + ", solicitudList="
				+ solicitudList + "]";
	}


	
	
	


	
	
	
	

	


	


	
	
	
	
	

}
