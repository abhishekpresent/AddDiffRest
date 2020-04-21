package com.calculator.demo;

import com.calculator.demo.model.Numbers;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {

    @Autowired
    private MockMvc mvc;

    @Test
    public void checAddkResultAvailable() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders
                .post("/api/add")
                .content(asJsonString(new Numbers("1","2")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value("3"));
    }
    @Test
    public void checkAddResultNegativeNumbers() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders
                .post("/api/add")
                .content(asJsonString(new Numbers("-1","2")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value("1"));
    }

    @Test
    public void checkAddResultAllZero() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders
                .post("/api/add")
                .content(asJsonString(new Numbers("0","0")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value("0"));
    }

    @Test
    public void checkAddResultBigNumbers() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders
                .post("/api/add")
                .content(asJsonString(new Numbers("100000000000000000000","999999999999999999999")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value("1.1E21"));
    }

    @Test
    public void checkAddResultDecimalNumbers() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders
                .post("/api/add")
                .content(asJsonString(new Numbers("100.05","2.67")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value("102.72"));
    }
    @Test
    public void checkAddResultNonNumericalValue() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders
                .post("/api/add")
                .content(asJsonString(new Numbers("1","test")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value("Not a number"));
    }

    @Test
    public void checkAddResultMissingValue() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders
                .post("/api/add")
                .content(asJsonString(new String("1")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(400));
    }

    @Test
    public void checDiffkResultAvailable() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders
                .post("/api/diff")
                .content(asJsonString(new Numbers("100","10")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value("90"));
    }
    @Test
    public void checkDiffResultNegativeNumbers() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders
                .post("/api/diff")
                .content(asJsonString(new Numbers("-1","2")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value("-3"));
    }

    @Test
    public void checkDiffResultAllZero() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders
                .post("/api/diff")
                .content(asJsonString(new Numbers("0","0")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value("0"));
    }

    @Test
    public void checkDiffResultBigNumbers() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders
                .post("/api/diff")
                .content(asJsonString(new Numbers("100000000000000000000","999999999999999999999")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value("-9.0E20"));
    }

    @Test
    public void checkDiffResultDecimalNumbers() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders
                .post("/api/diff")
                .content(asJsonString(new Numbers("100.05","2.67")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value("97.38"));
    }
    @Test
    public void checkDiffResultNonNumericalValue() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders
                .post("/api/diff")
                .content(asJsonString(new Numbers("1","test")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value("Not a number"));
    }

    @Test
    public void checkDiffResultMissingValue() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders
                .post("/api/diff")
                .content(asJsonString(new String("1")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(400));
    }



    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}


