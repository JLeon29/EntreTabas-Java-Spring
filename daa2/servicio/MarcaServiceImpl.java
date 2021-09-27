package idat.edu.pe.daa2.servicio;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import idat.edu.pe.daa2.entidades.Categoria;
import idat.edu.pe.daa2.entidades.Marca;
import idat.edu.pe.daa2.entidades.Zapatilla;

@Service
public class MarcaServiceImpl implements IMarcaService{
	
	private List<Marca> listaMarca = null;
	
	private MarcaServiceImpl() {
		
		listaMarca = new LinkedList<Marca>();
		
		try {
			
			Marca marca1 = new Marca();
			marca1.setId(1);
			marca1.setNombre("Adidas");
			
			Marca marca2 = new Marca();
			marca2.setId(2);
			marca2.setNombre("Nike");
			
			Marca marca3 = new Marca();
			marca3.setId(3);
			marca3.setNombre("Puma");
			
			Marca marca4 = new Marca();
			marca4.setId(4);
			marca4.setNombre("Athetlic");
			
			Marca marca5 = new Marca();
			marca5.setId(5);
			marca5.setNombre("Olimpycus");
			
			Marca marca6 = new Marca();
			marca6.setId(6);
			marca6.setNombre("Diadora");
			
			
			 
			listaMarca.add(marca1);
			listaMarca.add(marca2);
			listaMarca.add(marca3);
			listaMarca.add(marca4);
			listaMarca.add(marca5);
			listaMarca.add(marca6);
			
			
		}catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	
	@Override
	public List<Marca> mostrar() {
		
		return listaMarca;
	}

	@Override
	public Marca buscarPorId(Integer idMarca) {
		for(Marca c: listaMarca) {
			if(c.getId() == idMarca) {
				return c;
			}
		}
		return null;
	}

	@Override
	public void guardar(Marca marca) {
		listaMarca.add(marca);
		
	}


	@Override
	public boolean borrarPorId(Integer idMarca) {
		for(Marca m : listaMarca) {
			if(m.getId() == idMarca) {
				return listaMarca.remove(m);
			}
		}
		return false;
	}


	


	@Override
	public void eliminar(Integer idMarca) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Marca actualizarMarca(Marca marca) {
		// TODO Auto-generated method stub
		return null;
	}

}
