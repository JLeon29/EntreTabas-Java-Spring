package idat.edu.pe.daa2.servicio;

import java.util.List;

import idat.edu.pe.daa2.entidades.Categoria;
import idat.edu.pe.daa2.entidades.Marca;
import idat.edu.pe.daa2.entidades.Zapatilla;

public interface IMarcaService {
	
	
	List<Marca> mostrar();
	Marca buscarPorId(Integer idMarca);
	void guardar(Marca marca);
	boolean borrarPorId(Integer idMarca);
	Marca actualizarMarca(Marca marca);
	void eliminar (Integer idMarca);
}
 