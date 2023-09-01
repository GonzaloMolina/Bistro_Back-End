package Bistro_BackEnd;

import Bistro_BackEnd.dao.empleado.MozoDao;
import Bistro_BackEnd.dao.mesa.MesaDao;
import Bistro_BackEnd.dao.orden.OrdenDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@SpringBootApplication
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableSwagger2
@EnableWebMvc
public class BistroBackEndApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext configApp = SpringApplication.run(BistroBackEndApplication.class, args);
		MozoDao mozoDao = configApp.getBean(MozoDao.class);
		MesaDao mesaDao = configApp.getBean(MesaDao.class);
		OrdenDao ordenDao = configApp.getBean(OrdenDao.class);

		Seeder seeder = new Seeder(mozoDao, mesaDao, ordenDao);
		seeder.plant();
	}

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
		.apis(RequestHandlerSelectors.basePackage("Bistro_BackEnd.controladores")).build();
	}

	@Bean
	public InternalResourceViewResolver defaultViewResolver() {
		return new InternalResourceViewResolver();
	}
}
