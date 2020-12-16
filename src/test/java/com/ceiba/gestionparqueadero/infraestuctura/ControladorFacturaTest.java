package com.ceiba.gestionparqueadero.infraestuctura;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.ceiba.gestionparqueadero.aplicacion.comando.ComandoGeneracionFactura;
import com.ceiba.gestionparqueadero.testDataBuilder.FacturaTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class ControladorFacturaTest {
	@Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;
    
    @Test
    public void crearFactura() throws Exception{
    	ComandoGeneracionFactura coomandoInicializaFactura=new FacturaTestDataBuilder().inicializaFactura();
    	mvc.perform( MockMvcRequestBuilders
                .post("/factura/facturaPersistente")
                .content(objectMapper.writeValueAsString(coomandoInicializaFactura))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    @Test
    public void crearFacturaFail() throws Exception{
    	ComandoGeneracionFactura comandoInicializaFacturaFail=new FacturaTestDataBuilder().inicializaFacturaFail();
    	mvc.perform( MockMvcRequestBuilders
                .post("/factura/facturaPersistente")
                .content(objectMapper.writeValueAsString(comandoInicializaFacturaFail))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}
