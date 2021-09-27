package idat.edu.pe.daa2.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;

import idat.edu.pe.daa2.entidades.Categoria;
import idat.edu.pe.daa2.entidades.Marca;
import idat.edu.pe.daa2.entidades.Zapatilla;

public interface IZapatillaService {
	
	List<Zapatilla> mostrar();
	Zapatilla buscarPorId(Integer idZapatilla);
	void guardar(Zapatilla zapatilla);
	boolean borrarPorId(Integer idZapatilla);
	Zapatilla actualizarZapatilla(Zapatilla zapatilla);
	List<Zapatilla> buscarZapatillasCateDescrip();
	void eliminar (Integer idZapatilla);
	List<Zapatilla> buscarByExample(Example<Zapatilla> example);
}
 