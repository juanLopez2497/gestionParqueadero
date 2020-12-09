package com.ceiba.gestionParqueadero.infraestuctura;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.ceiba.gestionParqueadero.aplicacion.comando.ComandoGeneracionFactura;
import com.ceiba.gestionParqueadero.aplicacion.comando.ComandoRegistroParqueo;
import com.fasterxml.jackson.databind.ObjectMapper;

import om.ceiba.gestionParqueadero.testDataBuilder.ActividadTestDataBuilder;
import om.ceiba.gestionParqueadero.testDataBuilder.FacturaTestDataBuilder;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class ControladorActividadParqueaderoTest {

	@Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;
    
    @Test
    public void crearFactura() throws Exception{
    	ComandoGeneracionFactura coomandoInicializaFactura=new FacturaTestDataBuilder().inicializaFactura();
    	mvc.perform( MockMvcRequestBuilders
                .post("/actividades/generarFactura")
                .content(objectMapper.writeValueAsString(coomandoInicializaFactura))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    @Test
    public void crearFacturaFail() throws Exception{
    	ComandoGeneracionFactura comandoInicializaFacturaFail=new FacturaTestDataBuilder().inicializaFacturaFail();
    	mvc.perform( MockMvcRequestBuilders
                .post("/actividades/generarFactura")
                .content(objectMapper.writeValueAsString(comandoInicializaFacturaFail))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
    
    @Test
    public void crearActividad() throws Exception{
    	ComandoRegistroParqueo ComandoRegistroParqueo=new ActividadTestDataBuilder().creaActividad();
    	mvc.perform( MockMvcRequestBuilders
                .post("/actividades/agregar")
                .content(objectMapper.writeValueAsString(ComandoRegistroParqueo))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    
    @Test
    public void getListActividades() throws Exception{
    	mvc.perform( MockMvcRequestBuilders
                .get("/actividades/obtenerListaActividadesActivas")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
