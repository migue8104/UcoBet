package co.edu.uco.UcoBet.generales.infraestructure.primaryadapters.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.UcoBet.generales.infraestructure.primaryadapters.services.SanitizerService;

@RestController
@RequestMapping("/api")
public class SanitizerController {
	
    private final SanitizerService sanitizerService;

    public SanitizerController (SanitizerService sanitizerService) {
        this.sanitizerService = sanitizerService;
    }

    @PostMapping("/process")
    public ResponseEntity<String> process(@RequestBody String input) {
        // Sanitiza la entrada
        String sanitizedInput = sanitizerService.sanitize(input);
        
        // Retorna la entrada sanitizada
        return ResponseEntity.ok("Sanitized input: " + sanitizedInput);
        
    }
    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("La API está funcionando");
    }

}
