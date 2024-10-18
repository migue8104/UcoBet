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
        return policy.sanitize(input);
    }

}
