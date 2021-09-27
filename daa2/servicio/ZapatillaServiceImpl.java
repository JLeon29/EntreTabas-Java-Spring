package idat.edu.pe.daa2.servicio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import idat.edu.pe.daa2.entidades.Categoria;
import idat.edu.pe.daa2.entidades.Zapatilla;

@Service
public class ZapatillaServiceImpl implements IZapatillaService {

	private List<Zapatilla> lista = null;

	private ZapatillaServiceImpl() {

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		lista = new LinkedList<Zapatilla>();

		try { 

			Zapatilla zapatilla1 = new Zapatilla();
			zapatilla1.setId(1);
			zapatilla1.setNombre("Nike Pegazo");
			zapatilla1.setDescripcion("Prueba");
			zapatilla1.setPrecio(349.99);
			
			zapatilla1.setImagen("modahombre.png");

			Zapatilla zapatilla2 = new Zapatilla();
			zapatilla2.setId(2);
			zapatilla2.setNombre("Adidas Running Extra");
			zapatilla2.setDescripcion("Prueba");
			zapatilla2.setPrecio(249.99);
			
			zapatilla2.setImagen("modahombre.png");

			Zapatilla zapatilla3 = new Zapatilla();
			zapatilla3.setId(3);
			zapatilla3.setNombre("Nike Tennis");
			zapatilla3.setDescripcion("Prueba");
			zapatilla3.setPrecio(549.99);
			 
			zapatilla3.setImagen("modahombre.png");

			Zapatilla zapatilla4 = new Zapatilla();
			zapatilla4.setId(4);
			zapatilla4.setNombre("Adidas RT56");
			zapatilla4.setDescripcion("Prueba");
			zapatilla4.setPrecio(99.99);
			
			zapatilla4.setImagen("modahombre.png");

			Zapatilla zapatilla5 = new Zapatilla();
			zapatilla5.setId(5);
			zapatilla5.setNombre("Adidas PE-8");
			zapatilla5.setDescripcion("Prueba");
			zapatilla5.setPrecio(99.99);
			
			zapatilla5.setImagen("modahombre.png");

			Zapatilla zapatilla6 = new Zapatilla();
			zapatilla6.setId(6);
			zapatilla6.setNombre("Adidas ZT56");
			zapatilla6.setDescripcion("Prueba");
			zapatilla6.setPrecio(99.99);
			
			zapatilla6.setImagen("modahombre.png");

			lista.add(zapatilla1);
			lista.add(zapatilla2);
			lista.add(zapatilla3);
			lista.add(zapatilla4);
			lista.add(zapatilla5);
			lista.add(zapatilla6);

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

	@Override
	public List<Zapatilla> mostrar() {

		return lista;
	}

	@Override
	public Zapatilla buscarPorId(Integer idZapatilla) {
		for(Zapatilla c: lista) {
			if(c.getId() == idZapatilla) {
				return c;
			}
		}
		return null;
	}

	@Override
	public void guardar(Zapatilla zapatilla) {
		lista.add(zapatilla);
		
	}

	@Override
	public boolean borrarPorId(Integer idZapatilla) {
		for(Zapatilla z : lista) {
			if(z.getId() == idZapatilla) {
				return lista.remove(z);
			}
		}
		return false;
	}

	

	@Override
	public List<Zapatilla> buscarZapatillasCateDescrip() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Integer idZapatilla) {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public Zapatilla actualizarZapatilla(Zapatilla zapatilla) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Zapatilla> buscarByExample(Example<Zapatilla> example) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
