package si.masef.gestioncourier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.web.client.RestTemplate;

import si.masef.gestioncourier.entity.Courrier;

@SpringBootApplication
public class GestioncourierApplication implements CommandLineRunner {
	@Autowired
	RepositoryRestConfiguration restConfig;

	public static void main(String[] args) {
		SpringApplication.run(GestioncourierApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		restConfig.exposeIdsFor(Courrier.class);

	}

	// @Bean
	// public RestTemplate getRestTemplate() {
	// 	return new RestTemplate();
	// }

}
