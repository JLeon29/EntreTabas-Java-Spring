package idat.edu.pe.daa2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import idat.edu.pe.daa2.entidades.Categoria;

/*public interface CategoriaRepository extends CrudRepository<Categoria, Integer> {

}*/
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
