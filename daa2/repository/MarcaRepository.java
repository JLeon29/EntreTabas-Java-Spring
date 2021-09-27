package idat.edu.pe.daa2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import idat.edu.pe.daa2.entidades.Marca;

/*public interface MarcaRepository extends CrudRepository<Marca, Integer> {

}*/

public interface MarcaRepository extends JpaRepository<Marca, Integer> {

}
