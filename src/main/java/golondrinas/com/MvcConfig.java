package golondrinas.com;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.addResourceHandlers(registry);
		//registry.addResourceHandler("/uploadsFotos/**").addResourceLocations("file:/C:/Users/USUARIO/uploadsFotos/");
		registry.addResourceHandler("/uploadsFotos/**").addResourceLocations("file:/C:/Users/Administrador/uploadsFotos/");
	}
	
}
