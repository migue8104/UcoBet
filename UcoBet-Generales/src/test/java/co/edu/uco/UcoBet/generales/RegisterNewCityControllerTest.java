package co.edu.uco.UcoBet.generales;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import co.edu.uco.UcoBet.generales.application.primaryports.dto.city.RegisterNewCityDto;
import co.edu.uco.UcoBet.generales.application.primaryports.interactor.city.RegisterNewCityInteractor;
import co.edu.uco.UcoBet.generales.crosscutting.exceptions.UcoBetException;
import co.edu.uco.UcoBet.generales.crosscutting.helpers.UUIDHelper;
import co.edu.uco.UcoBet.generales.infraestructure.primaryadapters.controller.city.RegisterNewCityController;
import co.edu.uco.UcoBet.generales.infraestructure.primaryadapters.controller.response.CityResponse;
import co.edu.uco.UcoBet.generales.infraestructure.primaryadapters.services.SanitizerService;

@ExtendWith(MockitoExtension.class)
public class RegisterNewCityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private RegisterNewCityInteractor registerNewCityInteractor;

    @Mock
    private SanitizerService sanitizerService;

    @InjectMocks
    private RegisterNewCityController registerNewCityController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(registerNewCityController).build();
    }

    @Test
    public void testGetDummy() throws Exception {
        // Test para obtener el "dummy"
        mockMvc.perform(get("/generales/api/v1/cities"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"name\":\"rionegro\",\"state\":\"00000000-0000-0000-0000-000000000000\"}")); // Ajusta el UUID si es necesario
    }


    @Test
    public void testCrearCityBadRequest() throws Exception {
        RegisterNewCityDto cityDto = RegisterNewCityDto.create("InvalidCity", UUID.randomUUID());

        // Simula una excepción de UcoBetException al registrar
        doThrow(UcoBetException.create("Error técnico", "Error en la creación de la ciudad", new Exception()))
                .when(registerNewCityInteractor).execute(any());

        mockMvc.perform(post("/generales/api/v1/cities")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"InvalidCity\",\"state\":\"" + cityDto.getState() + "\"}"))
                .andExpect(status().isBadRequest())
                .andExpect(content().json("{\"mensajes\":[\"Error en la creación de la ciudad\"]}"));
    }
    
    @Test
    void testCreateCityDto() {
        // Arrange
        String expectedName = "Rionegro";
        UUID expectedState = UUID.randomUUID(); // Genera un UUID aleatorio

        // Act
        RegisterNewCityDto cityDto = RegisterNewCityDto.create(expectedName, expectedState);

        // Assert
        assertNotNull(cityDto, "El objeto RegisterNewCityDto no debe ser nulo");
        assertEquals(expectedName, cityDto.getName(), "El nombre de la ciudad debe coincidir");
        assertEquals(expectedState, cityDto.getState(), "El estado debe coincidir");}

}