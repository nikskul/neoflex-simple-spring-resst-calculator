package com.nikskul.calculatorservice.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {CalculatorController.class})
@ExtendWith(SpringExtension.class)
class CalculatorControllerTest {
    @Autowired
    private CalculatorController calculatorController;

    @Test
    void testGetDivisionResult() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/calculator/division")
                .param("firstValue", "foo")
                .param("secondValue", "foo");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.calculatorController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    void testGetDivisionResult2() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/calculator/division", "Uri Vars")
                .param("firstValue", "foo")
                .param("secondValue", "foo");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.calculatorController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    void testGetDivisionResult3() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/calculator/division")
                .param("firstValue", "42")
                .param("secondValue", "foo");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.calculatorController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    void testGetDivisionResult4() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/calculator/division")
                .param("firstValue", "9.9")
                .param("secondValue", "foo");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.calculatorController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    void testGetDivisionResult5() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/calculator/division")
                .param("firstValue", "")
                .param("secondValue", "foo");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.calculatorController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    void testGetDivisionResult6() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/calculator/division")
                .param("firstValue", "42")
                .param("secondValue", "42");
        MockMvcBuilders.standaloneSetup(this.calculatorController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"result\":\"1.0\"}"));
    }

    @Test
    void testGetMultiplicationResult() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/calculator/multiply")
                .param("firstValue", "foo")
                .param("secondValue", "foo");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.calculatorController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    void testGetMultiplicationResult2() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/calculator/multiply")
                .param("firstValue", "42")
                .param("secondValue", "foo");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.calculatorController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    void testGetMultiplicationResult3() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/calculator/multiply")
                .param("firstValue", "9.9")
                .param("secondValue", "foo");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.calculatorController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    void testGetMultiplicationResult4() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/calculator/multiply")
                .param("firstValue", "")
                .param("secondValue", "foo");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.calculatorController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    void testGetMultiplicationResult5() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/v1/calculator/multiply");
        getResult.contentType("https://example.org/example");
        MockHttpServletRequestBuilder requestBuilder = getResult.param("firstValue", "foo").param("secondValue", "foo");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.calculatorController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    void testGetMultiplicationResult6() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/calculator/multiply")
                .param("firstValue", "42")
                .param("secondValue", "42");
        MockMvcBuilders.standaloneSetup(this.calculatorController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"result\":\"1764.0\"}"));
    }

    @Test
    void testGetSubtraction() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/calculator/subtraction")
                .param("firstValue", "foo")
                .param("secondValue", "foo");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.calculatorController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    void testGetSubtraction2() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/calculator/subtraction")
                .param("firstValue", "42")
                .param("secondValue", "foo");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.calculatorController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    void testGetSubtraction3() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/calculator/subtraction")
                .param("firstValue", "9.9")
                .param("secondValue", "foo");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.calculatorController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    void testGetSubtraction4() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/calculator/subtraction")
                .param("firstValue", "")
                .param("secondValue", "foo");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.calculatorController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    void testGetSubtraction5() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/v1/calculator/subtraction");
        getResult.contentType("https://example.org/example");
        MockHttpServletRequestBuilder requestBuilder = getResult.param("firstValue", "foo").param("secondValue", "foo");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.calculatorController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    void testGetSubtraction6() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/calculator/subtraction")
                .param("firstValue", "42")
                .param("secondValue", "42");
        MockMvcBuilders.standaloneSetup(this.calculatorController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"result\":\"0.0\"}"));
    }

    @Test
    void testGetSum() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/calculator/addition")
                .param("firstValue", "foo")
                .param("secondValue", "foo");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.calculatorController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    void testGetSum2() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/calculator/addition")
                .param("firstValue", "42")
                .param("secondValue", "foo");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.calculatorController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    void testGetSum3() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/calculator/addition")
                .param("firstValue", "9.9")
                .param("secondValue", "foo");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.calculatorController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    void testGetSum4() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/calculator/addition")
                .param("firstValue", "")
                .param("secondValue", "foo");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.calculatorController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    void testGetSum5() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/v1/calculator/addition");
        getResult.contentType("https://example.org/example");
        MockHttpServletRequestBuilder requestBuilder = getResult.param("firstValue", "foo").param("secondValue", "foo");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.calculatorController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    void testGetSum6() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/calculator/addition")
                .param("firstValue", "42")
                .param("secondValue", "42");
        MockMvcBuilders.standaloneSetup(this.calculatorController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"result\":\"84.0\"}"));
    }
}

