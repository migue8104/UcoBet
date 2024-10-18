package co.edu.uco.UcoBet.generales;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import co.edu.uco.UcoBet.generales.infraestructure.primaryadapters.services.SanitizerService;

@SpringBootTest(classes = SanitizerService.class)
public class SanitizerServiceTest {

    @Autowired
    private SanitizerService sanitizerService;

    @Test
    public void testSanitize() {
        String input = "<script>alert('XSS')</script><b>Texto en Negrita</b>";
        String expected = "<b>Texto en Negrita</b>"; // Ajusta según tu política
        String actual = sanitizerService.sanitize(input);
        assertEquals(expected, actual);
    }
}

