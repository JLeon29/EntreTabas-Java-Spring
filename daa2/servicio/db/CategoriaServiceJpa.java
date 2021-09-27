package idat.edu.pe.daa2.servicio.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import idat.edu.pe.daa2.entidades.Categoria;
import idat.edu.pe.daa2.repository.CategoriaRepository;
import idat.edu.pe.daa2.servicio.ICategoriaService;

@Service
public class CategoriaServiceJpa implements ICategoriaService {
	
	@Autowired
	private CategoriaRepository categoriasRepo;

	@Override
	public List<Categoria> mostrar() {
		return categoriasRepo.findAll();
		
	}

	@Override
	public Categoria buscarPorId(Integer idCategoria) {
		Optional<Categoria> optional = categoriasRepo.findById(idCategoria);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void guardar(Categoria categoria) {
		categoriasRepo.save(categoria);

	}

	@Override
	public boolean borrarPorId(Integer idCategoria) {
		categoriasRepo.findById(idCategoria);
		return false;
	}

	

	@Override
	public void eliminar(Integer idCategoria) {
		categoriasRepo.deleteById(idCategoria);
		
	}

	@Override
	public Categoria actualizarCategoria(Categoria categoria) {
		Categoria categoriaActual = categoriasRepo.findById(categoria.getId()).get();
		Categoria categoriaModificada = null;
		if(categoria != null)
		{
			categoriaActual.setNombre(categoria.getNombre());
			categoriaActual.setDescripcion(categoria.getDescripcion());
			categoriaModificada = categoriasRepo.save(categoriaActual);
		}
		return categoriaModificada;
	}

	

}
