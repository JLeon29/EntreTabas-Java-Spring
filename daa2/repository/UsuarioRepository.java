package idat.edu.pe.daa2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import idat.edu.pe.daa2.entidades.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	
	Usuario findByUsername(String username);
	

}
