package co.edu.uco.UcoBet.generales.infraestructure.primaryadapters.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.models.KeyVaultSecret;

@RestController
public class VaultController {
	private final SecretClient secretClient;

	public VaultController(SecretClient secretClient) {
		this.secretClient = secretClient;
	}

	@GetMapping("/getSecretValue/{key}")
	public String getSecretValue(@PathVariable("key") String key) {
		KeyVaultSecret secret = secretClient.getSecret(key);
		return secret.getValue();
	}

}
