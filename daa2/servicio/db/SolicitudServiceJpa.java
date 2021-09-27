package idat.edu.pe.daa2.servicio.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.edu.pe.daa2.entidades.Solicitud;
import idat.edu.pe.daa2.repository.SolicitudRepository;
import idat.edu.pe.daa2.servicio.ISolicitudService;

@Service
public class SolicitudServiceJpa implements ISolicitudService {
	
	@Autowired
	private SolicitudRepository solicitudRepo;

	@Override
	public List<Solicitud> mostrar() {
		return solicitudRepo.findAll();
	}

	@Override
	public void guardar(Solicitud solicitud) {
		solicitudRepo.save(solicitud);
		
	}

	@Override
	public void eliminar(Integer idSolicitud) {
		solicitudRepo.deleteById(idSolicitud);
		
		
	}

	@Override
	public void eliminarTodas() {
		solicitudRepo.deleteAll();
		
	}
	
	

}
