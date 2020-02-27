package com.nouks.unitconversion.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class UnitConversionControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void givenInputCase1_returnCorrectOutput() throws Exception {

        String sampleRequest = "{\n" +
                "\t\"inputValue\": 84.2,\n" +
                "\t\"inputUnit\": \"Fahrenheit\",\n" +
                "\t\"targetUnit\": \"Rankine\",\n" +
                "\t\"response\": 543.94\n" +
                "}";
        RequestBuilder requestBuilder = post("/api/verify/response")
                .contentType(MediaType.APPLICATION_JSON)
                .content(sampleRequest)
                .accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder)
                .andExpect(content().string("correct"))
                .andReturn();
    }

    @Test
    public void givenInputCase2_returnCorrectOutput() throws Exception {

        String sampleRequest = "{\n" +
                "\t\"inputValue\": 317.33,\n" +
                "\t\"inputUnit\": \"Kelvin\",\n" +
                "\t\"targetUnit\": \"Fahrenheit\",\n" +
                "\t\"response\": 111.554\n" +
                "}";
        RequestBuilder requestBuilder = post("/api/verify/response")
                .contentType(MediaType.APPLICATION_JSON)
                .content(sampleRequest)
                .accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder)
                .andExpect(content().string("incorrect"))
                .andReturn();
    }

    @Test
    public void givenInputCase3_returnCorrectOutput() throws Exception {

        String sampleRequest = "{\n" +
                "\t\"inputValue\": 25.6,\n" +
                "\t\"inputUnit\": \"cups\",\n" +
                "\t\"targetUnit\": \"liters\",\n" +
                "\t\"response\": 6.1\n" +
                "}";
        RequestBuilder requestBuilder = post("/api/verify/response")
                .contentType(MediaType.APPLICATION_JSON)
                .content(sampleRequest)
                .accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder)
                .andExpect(content().string("correct"))
                .andReturn();
    }

    @Test
    public void givenInputCase4_returnCorrectOutput() throws Exception {

        String sampleRequest = "{\n" +
                "\t\"inputValue\": 73.12,\n" +
                "\t\"inputUnit\": \"gallons\",\n" +
                "\t\"targetUnit\": \"Kelvin\",\n" +
                "\t\"response\": 19.4\n" +
                "}";
        RequestBuilder requestBuilder = post("/api/verify/response")
                .contentType(MediaType.APPLICATION_JSON)
                .content(sampleRequest)
                .accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder)
                .andExpect(content().string("invalid"))
                .andReturn();
    }

    @Test
    public void givenInputCase5_returnCorrectOutput() throws Exception {

        String sampleRequest = "{\n" +
                "\t\"inputValue\": 6.5,\n" +
                "\t\"inputUnit\": \"Fahrenheit\",\n" +
                "\t\"targetUnit\": \"Rankine\",\n" +
                "\t\"response\": \"dog\"\n" +
                "}";
        RequestBuilder requestBuilder = post("/api/verify/response")
                .contentType(MediaType.APPLICATION_JSON)
                .content(sampleRequest)
                .accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder)
                .andExpect(content().string("incorrect"))
                .andReturn();
    }

    @Test
    public void givenInputCase6_returnCorrectOutput() throws Exception {

        String sampleRequest = "{\n" +
                "\t\"inputValue\": 136.1,\n" +
                "\t\"inputUnit\": \"dog\",\n" +
                "\t\"targetUnit\": \"Celsius\",\n" +
                "\t\"response\": 45.32\n" +
                "}";
        RequestBuilder requestBuilder = post("/api/verify/response")
                .contentType(MediaType.APPLICATION_JSON)
                .content(sampleRequest)
                .accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder)
                .andExpect(content().string("invalid"))
                .andReturn();
    }
}
