package idat.edu.pe.daa2.servicio.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import idat.edu.pe.daa2.entidades.Categoria;
import idat.edu.pe.daa2.entidades.Zapatilla;
import idat.edu.pe.daa2.repository.ZapatillaRepository;
import idat.edu.pe.daa2.servicio.IZapatillaService;

@Service
public class ZapatillaServiceJpa implements IZapatillaService {
	
	@Autowired
	private ZapatillaRepository zapatillasRepo;

	@Override
	public List<Zapatilla> mostrar() {
		return zapatillasRepo.findAll();
	}

	@Override
	public Zapatilla buscarPorId(Integer idZapatilla) {
		Optional<Zapatilla> optional =zapatillasRepo.findById(idZapatilla);
		if(optional.isPresent()) {
			return optional.get();	
		}
		return null;
	}

	@Override
	public void guardar(Zapatilla zapatilla) {
		zapatillasRepo.save(zapatilla);

	}

	@Override
	public boolean borrarPorId(Integer idZapatilla) {
		// TODO Auto-generated method stub
		return false;
	}

	
	@Override
	public List<Zapatilla> buscarZapatillasCateDescrip() {
		return zapatillasRepo.findByCategoriaDescripcion("Moda Hombre");
	}

	@Override
	public void eliminar(Integer idZapatilla) {
		zapatillasRepo.deleteById(idZapatilla);
		
	}

	

	@Override
	public Zapatilla actualizarZapatilla(Zapatilla zapatilla) {
		Zapatilla zapatillaActual = zapatillasRepo.findById(zapatilla.getId()).get();
		Zapatilla zapatillaModificada = null;
		if(zapatilla != null)
		{
			zapatillaActual.setNombre(zapatilla.getNombre());
			zapatillaActual.setDescripcion(zapatilla.getDescripcion());
			zapatillaActual.setPrecio(zapatilla.getPrecio());
			zapatillaActual.setImagen(zapatilla.getImagen());
			zapatillaActual.setCategoria(zapatilla.getCategoria());
			zapatillaActual.setMarca(zapatilla.getMarca());
			zapatillaModificada = zapatillasRepo.save(zapatillaActual);
		}
		return zapatillaModificada;
	}

	@Override
	public List<Zapatilla> buscarByExample(Example<Zapatilla> example) {
		
		return zapatillasRepo.findAll(example);
	}

	
	
	

}
