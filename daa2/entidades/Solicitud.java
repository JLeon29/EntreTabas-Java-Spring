package idat.edu.pe.daa2.entidades;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "detalle")
public class Solicitud {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	//@NotNull
	//@Positive
	//@Max(value=43)
	//@Min(value=35)
	private Integer talla;
	
	//@NotNull
	//@Positive
	//@Min(value=1)
	private Integer cantidad;
	
	private Date fecha;
	
	
	@ManyToOne(optional = false)
	@JoinColumn(name="idProducto",referencedColumnName = "id")
	private Zapatilla zapatilla;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="idUsuario",referencedColumnName = "id")
	private Usuario usuario;

	public Solicitud() {
		super();
	}

	public Solicitud(Integer id, Integer talla, Integer cantidad, Date fecha, Zapatilla zapatilla, Usuario usuario) {
		super();
		this.id = id;
		this.talla = talla;
		this.cantidad = cantidad;
		this.fecha = fecha;
		this.zapatilla = zapatilla;
		this.usuario = usuario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTalla() {
		return talla;
	}

	public void setTalla(Integer talla) {
		this.talla = talla;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Zapatilla getZapatilla() {
		return zapatilla;
	}

	public void setZapatilla(Zapatilla zapatilla) {
		this.zapatilla = zapatilla;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Solicitud [id=" + id + ", talla=" + talla + ", cantidad=" + cantidad + ", fecha=" + fecha
				+ ", zapatilla=" + zapatilla + ", usuario=" + usuario + "]";
	}
	
	
	
	
	

}
