package com.ceiba.gestionparqueadero.infraestuctura;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.ceiba.gestionparqueadero.aplicacion.comando.ComandoRegistroParqueo;
import com.ceiba.gestionparqueadero.testdatabuilder.ActividadTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

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
    public void crearActividad() throws Exception{
    	ComandoRegistroParqueo ComandoRegistroParqueo=new ActividadTestDataBuilder().creaActividad();
    	mvc.perform( MockMvcRequestBuilders
                .post("/registros/actividades")
                .content(objectMapper.writeValueAsString(ComandoRegistroParqueo))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    
    @Test
    public void crearActividadFail() throws Exception{
    	ComandoRegistroParqueo ComandoRegistroParqueo=new ActividadTestDataBuilder().creaActividadFail();
    	mvc.perform( MockMvcRequestBuilders
                .post("/registros/actividades")
                .content(objectMapper.writeValueAsString(ComandoRegistroParqueo))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
    
    @Test
    public void crearActividadPlacaTamanoFail() throws Exception{
    	ComandoRegistroParqueo ComandoRegistroParqueo=new ActividadTestDataBuilder().creaActividadFailPlacaTamano();
    	mvc.perform( MockMvcRequestBuilders
                .post("/registros/actividades")
                .content(objectMapper.writeValueAsString(ComandoRegistroParqueo))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
    
    @Test
    public void getListActividades() throws Exception{
    	mvc.perform( MockMvcRequestBuilders
                .get("/registros/historicos")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    
    @Test
    public void crearActividadTipoAutFail() throws Exception{
    	ComandoRegistroParqueo ComandoRegistroParqueo=new ActividadTestDataBuilder().creaActividadTipoAutFail();
    	mvc.perform( MockMvcRequestBuilders
                .post("/registros/actividades")
                .content(objectMapper.writeValueAsString(ComandoRegistroParqueo))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
    @Test
    public void crearActividadRespBonoFail() throws Exception{
    	ComandoRegistroParqueo ComandoRegistroParqueo=new ActividadTestDataBuilder().creaActividadRespBonoFail();
    	mvc.perform( MockMvcRequestBuilders
                .post("/registros/actividades")
                .content(objectMapper.writeValueAsString(ComandoRegistroParqueo))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}
