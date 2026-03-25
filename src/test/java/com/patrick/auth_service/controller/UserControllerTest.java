package com.patrick.auth_service.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.http.MediaType;

import java.util.UUID;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void listarTodosOsUsuarios_deveRetornar200() throws Exception{
        mockMvc.perform(get("/auth"))
                .andExpect(status().isOk());
    }

    @Test
    void buscarPorId_deveRetornar400_quandoEInvalido() throws Exception{
        mockMvc.perform(get("/auth/abc"))  // /auth/(aqui vai o id que estou testando)
                .andExpect(status().isBadRequest());
    }

    @Test
    void register() throws Exception {

        String email = "teste" + UUID.randomUUID() + "@email.com";

        String json = """
                {
                  "firstName": "Patrick",
                  "lastName": "Rebecchi",
                  "age": 25,
                  "phone": "11948938494",
                  "email": "%s",
                  "password": "123456"
                }
                """.formatted(email);

        mockMvc.perform(post("/auth/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isCreated());

    }

    @Test
    void naoDeveCadastrarClienteComEmailDuplicado() throws Exception{

        String json = """
                {
                  "firstName": "Patrick",
                  "lastName": "Rebecchi",
                  "age": 25,
                  "phone": "11948938494",
                  "email": "patrick@email.com",
                  "password": "123456"
                }
                """;

        mockMvc.perform(post("/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest());
    }
}