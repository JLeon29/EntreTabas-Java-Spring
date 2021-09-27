package idat.edu.pe.daa2.controladores.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import idat.edu.pe.daa2.entidades.Categoria;
import idat.edu.pe.daa2.entidades.Marca;
import idat.edu.pe.daa2.servicio.db.MarcaServiceJpa;

@RestController

@RequestMapping("/rest/marca")
@CrossOrigin(origins="*", allowedHeaders = "*")
public class MarcasRestController {
	
	@Autowired
	private MarcaServiceJpa marcaService;
	
	@GetMapping
	
	public ResponseEntity<Object> buscarTodo(){
		
		List<Marca> lista = marcaService.mostrar();
		return new ResponseEntity<Object>(lista, HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}")
	
	@ResponseBody
	public ResponseEntity<Object> buscarPorId (@PathVariable("id") int idMarca){
		
		Marca marca = marcaService.buscarPorId(idMarca);
		if(marca == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Función no encontrada, id proporcionado no es correcto !!");
		
		return new ResponseEntity<>(marca,HttpStatus.OK);
		
	}
	
	@PostMapping
	
	public ResponseEntity<Object> crear(@RequestBody Marca marcaNueva){
		
		marcaService.guardar(marcaNueva);
		Map<String, String> mapRespuesta = new HashMap<>();
		mapRespuesta.put("codigo", "00" );
		mapRespuesta.put("mensaje", "Nueva marca creada correctamente");
		return new ResponseEntity<>(mapRespuesta, HttpStatus.CREATED);
		
		
		
	}
	
	@PatchMapping(value="/{id}")
	
	public ResponseEntity<Object> actualizar (@PathVariable("id") int idMarca, @RequestBody Marca marca){
		
		marcaService.actualizarMarca(marca);
		
		return new ResponseEntity<Object>("Marca actualizada correctamente", HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping(value="/{id}")
	
	
	public ResponseEntity<Object> borrar(@PathVariable("id") int idMarca){
		
		marcaService.eliminar(idMarca);
		
		return new ResponseEntity<Object>("Marca eliminada correctamente",HttpStatus.OK);
		
	}
	
	

}
