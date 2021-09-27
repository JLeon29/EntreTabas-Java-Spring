package idat.edu.pe.daa2.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	@Value("${EntreTabasMVC.ruta.imagenes}")
	private String rutaImagenes;

	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// registry.addResourceHandler("/logos/**").addResourceLocations("file:/empleos/img-vacantes/");
		// // Linux
		//registry.addResourceHandler("/logos/**").addResourceLocations("file:c:/entretabas/img-entretabas/"); // Windows
		registry.addResourceHandler("/logos/**").addResourceLocations("file:"+rutaImagenes); // Windows
	}

}
