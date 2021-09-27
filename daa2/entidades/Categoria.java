package idat.edu.pe.daa2.entidades;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="categoria")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String descripcion;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "categoria")
	@JsonBackReference(value="categoria") //evitar los loops infinitos en js
	private List<Zapatilla> zapatilla;
	
	
	public Categoria() {
		super();
	}


	public Categoria(Integer id, String nombre, String descripcion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
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


	


	public List<Zapatilla> getZapatilla() {
		return zapatilla;
	}


	public void setZapatilla(List<Zapatilla> zapatilla) {
		this.zapatilla = zapatilla;
	}


	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", zapatilla="
				+ zapatilla + "]";
	}


	
	

	
	
	
	

}
