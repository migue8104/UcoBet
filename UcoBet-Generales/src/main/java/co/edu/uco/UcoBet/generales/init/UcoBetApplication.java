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
public class UcoBetApplication implements CommandLineRunner  {
	
	private SecretClient secretClient;

	public UcoBetApplication(SecretClient secretClient) {
		this.secretClient = secretClient;
	}

	public static void main(String[] args) {
		SpringApplication.run(UcoBetApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
        // Recuperar y establecer los secretos para URL, usuario y contraseña
        String dbUrl = secretClient.getSecret("urlbd").getValue();
        String dbUser = secretClient.getSecret("usernamebd").getValue();
        String dbPassword = secretClient.getSecret("passwordbd").getValue();

        // Establecer los secretos como propiedades del sistema
        System.setProperty("urlbd", dbUrl);
        System.setProperty("usernamebd", dbUser);
        System.setProperty("passwordbd", dbPassword);

        // Opcional: imprimir para verificar
        System.out.println("URL de BD: " + dbUrl);
        System.out.println("Usuario de BD: " + dbUser);
        System.out.println("Contraseña de BD: " + dbPassword);

		
	}

	
}
