package idat.edu.pe.daa2.servicio;

import java.util.List;

import idat.edu.pe.daa2.entidades.Solicitud;

public interface ISolicitudService {
	
	List<Solicitud> mostrar();
	void guardar (Solicitud solicitud);
	void eliminar (Integer idSolicitud);
	void eliminarTodas();
	

}
