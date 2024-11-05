package co.edu.uco.UcoBet.generales.infraestructure.primaryadapters.services;

import org.owasp.html.PolicyFactory;
import org.owasp.html.Sanitizers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SanitizerService {
    private static final Logger logger = LoggerFactory.getLogger(SanitizerService.class);
    private final PolicyFactory policy = Sanitizers.FORMATTING.and(Sanitizers.LINKS);

    public String sanitize(String input) {
        if (input == null) {
            logger.warn("Se intentó sanitizar una entrada nula");
            return null; // o considera retornar una cadena vacía
        }

        String sanitizedInput = policy.sanitize(input);
        logger.debug("Entrada sanitizada: {}", sanitizedInput); // Registra la salida sanitizada
        return sanitizedInput;
    }
}
