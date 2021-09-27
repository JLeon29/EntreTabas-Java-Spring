package idat.edu.pe.daa2.servicio.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.edu.pe.daa2.entidades.Usuario;
import idat.edu.pe.daa2.repository.UsuarioRepository;
import idat.edu.pe.daa2.servicio.IUsuarioService;

@Service
public class UsuarioServiceJpa implements IUsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepo;
		
	@Override
	public void guardar(Usuario usuario) {
		usuarioRepo.save(usuario);
	}

	@Override
	public void eliminar(Integer idUsuario) {
		usuarioRepo.deleteById(idUsuario);

	}

	@Override
	public List<Usuario> buscarTodos() {
		
		return usuarioRepo.findAll();
	}

	@Override
	public List<Usuario> buscarRegistrados() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario buscarPorId(Integer idUsuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario buscarPorUsername(String username) {
		return usuarioRepo.findByUsername(username);
	
	}

	@Override
	public int bloquear(int idUsuario) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int activar(int idUsuario) {
		// TODO Auto-generated method stub
		return 0;
	}

}
