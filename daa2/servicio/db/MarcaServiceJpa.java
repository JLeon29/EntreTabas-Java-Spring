package idat.edu.pe.daa2.servicio.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.edu.pe.daa2.entidades.Categoria;
import idat.edu.pe.daa2.entidades.Marca;
import idat.edu.pe.daa2.repository.MarcaRepository;
import idat.edu.pe.daa2.servicio.IMarcaService;

@Service
public class MarcaServiceJpa implements IMarcaService {

	@Autowired
	private MarcaRepository marcasRepo;
	
	@Override
	public List<Marca> mostrar() {
		return marcasRepo.findAll();
		
	}

	@Override
	public Marca buscarPorId(Integer idMarca) {
		Optional<Marca> optional = marcasRepo.findById(idMarca);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void guardar(Marca marca) {
		marcasRepo.save(marca);

	}

	@Override
	public boolean borrarPorId(Integer idMarca) {
		// TODO Auto-generated method stub
		return false;
	}

	

	@Override
	public void eliminar(Integer idMarca) {
		marcasRepo.deleteById(idMarca);
		
	}

	@Override
	public Marca actualizarMarca(Marca marca) {
		Marca marcaActual = marcasRepo.findById(marca.getId()).get();
		Marca marcaModificada = null;
		if(marca != null)
		{
			marcaActual.setNombre(marca.getNombre());
			
			marcaModificada = marcasRepo.save(marcaActual);
		}
		return marcaModificada;
	}

}
