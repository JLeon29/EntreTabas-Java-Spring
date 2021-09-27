package idat.edu.pe.daa2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import idat.edu.pe.daa2.entidades.Zapatilla;

/*public interface ZapatillaRepository extends CrudRepository<Zapatilla, Integer> {

}
*/
public interface ZapatillaRepository extends JpaRepository<Zapatilla, Integer> {
	
	List<Zapatilla> findByCategoriaDescripcion(String descripcionCategoria);

}
