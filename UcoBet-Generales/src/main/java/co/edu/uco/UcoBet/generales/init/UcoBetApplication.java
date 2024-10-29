package co.edu.uco.UcoBet.generales.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.azure.security.keyvault.secrets.SecretClient;

@SpringBootApplication
@EnableJpaRepositories(basePackages={"co.edu.uco.UcoBet"})
@EntityScan(basePackages= {"co.edu.uco.UcoBet.generales.application.secondaryports.entity"})
@ComponentScan(basePackages= {" co.edu.uco.UcoBet.generales"})
public class UcoBetApplication implements CommandLineRunner {

//	private final SecretClient secretClient;
//
//	public UcoBetApplication(SecretClient secretClient) {
//		this.secretClient = secretClient;
//	}

	public static void main(String[] args) {
		SpringApplication.run(UcoBetApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		// Recupera el secreto desde Azure Key Vault y establece la URL de la base de
//		// datos
//		String h2url = secretClient.getSecret("baseDatos").getValue();
//		System.setProperty("baseDatos", h2url);
//		System.out.println(h2url);

	}

}
