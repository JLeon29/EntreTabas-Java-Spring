package idat.edu.pe.daa2.controladores.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import idat.edu.pe.daa2.entidades.Categoria;
import idat.edu.pe.daa2.entidades.Marca;
import idat.edu.pe.daa2.entidades.Zapatilla;
import idat.edu.pe.daa2.servicio.db.ZapatillaServiceJpa;

@RestController

@RequestMapping("/rest/zapatilla")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ZapatillasRestController {

	@Autowired
	private ZapatillaServiceJpa zapatillaService;

	@GetMapping
	public ResponseEntity<Object> buscarTodo() {

		List<Zapatilla> lista = zapatillaService.mostrar();
		return new ResponseEntity<Object>(lista, HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}")
	@ResponseBody
	public ResponseEntity<Object> buscarPorId (@PathVariable("id") int idZapatilla){
		
		Zapatilla zapatilla = zapatillaService.buscarPorId(idZapatilla);
		if(zapatilla == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Función no encontrada, id proporcionado no es correcto !!");
		
		return new ResponseEntity<>(zapatilla,HttpStatus.OK);
		
	}
	
	@PostMapping
	public ResponseEntity<Object> crear(@RequestBody Zapatilla zapatillaNueva){
		
		zapatillaService.guardar(zapatillaNueva);
		Map<String, String> mapRespuesta = new HashMap<>();
		mapRespuesta.put("codigo", "00" );
		mapRespuesta.put("mensaje", "Nueva zapatilla creada correctamente");
		return new ResponseEntity<>(mapRespuesta, HttpStatus.CREATED);

		
	}
	
	@PatchMapping(value="/{id}")
	public ResponseEntity<Object> actualizar (@PathVariable("id") int idZapatilla, @RequestBody Zapatilla zapatilla){
		
		zapatillaService.actualizarZapatilla(zapatilla);
		
		return new ResponseEntity<Object>("Zapatilla actualizada correctamente", HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Object> borrar(@PathVariable("id") int idZapatilla){
		
		zapatillaService.eliminar(idZapatilla);
		return new ResponseEntity<Object>("Zapatilla eliminada correctamente",HttpStatus.OK);
		
	}

}
