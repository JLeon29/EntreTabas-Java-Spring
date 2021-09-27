package idat.edu.pe.daa2.servicio;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import idat.edu.pe.daa2.entidades.Categoria;
import idat.edu.pe.daa2.entidades.Zapatilla;


@Service
public class CategoriaServiceImpl implements ICategoriaService {

	private List<Categoria> listaCategoria = null;
	
	private CategoriaServiceImpl() {

		listaCategoria = new LinkedList<Categoria>();

		try {

			Categoria cateogoria1 = new Categoria();
			cateogoria1.setId(1);
			cateogoria1.setNombre("Hombre");
			cateogoria1.setDescripcion("Moda Varonil");
			
			
			Categoria cateogoria2 = new Categoria();
			cateogoria2.setId(2);
			cateogoria2.setNombre("Mujer");
			cateogoria2.setDescripcion("Moda Femenino");
 
			listaCategoria.add(cateogoria1);
			listaCategoria.add(cateogoria2);

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

	}
	

	@Override
	public Categoria buscarPorId(Integer idCategoria) {
		for(Categoria c: listaCategoria) {
			if(c.getId() == idCategoria) {
				return c;
			}
		}
		return null;
	}

	@Override
	public void guardar(Categoria categoria) {
		if(categoria.getId() == null) {
			listaCategoria.add(categoria);
		}
	
	}

	@Override
	public List<Categoria> mostrar() {
		
		return listaCategoria;
	}


	@Override
	public boolean borrarPorId(Integer idCategoria) {
		for(Categoria c: listaCategoria) {
			if( c.getId() == idCategoria) {
				return listaCategoria.remove(c);
			}
		}
		
		return false;
		
	}


	


	@Override
	public void eliminar(Integer idCategoria) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Categoria actualizarCategoria(Categoria categoria) {
		// TODO Auto-generated method stub
		return null;
	}


	
	
	

}
