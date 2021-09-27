package idat.edu.pe.daa2.servicio;

import java.util.List;
import java.util.Optional;

import idat.edu.pe.daa2.entidades.Categoria;

public interface ICategoriaService {
	
	List<Categoria> mostrar();
	Categoria buscarPorId(Integer idCategoria);
	void guardar(Categoria categoria);
	boolean borrarPorId(Integer idCategoria);
	Categoria actualizarCategoria(Categoria categoria);
	void eliminar (Integer idCategoria);

	

}
 