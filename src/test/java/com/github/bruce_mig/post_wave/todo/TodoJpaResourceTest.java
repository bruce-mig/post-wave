package com.github.bruce_mig.post_wave.todo;

import com.github.bruce_mig.post_wave.jwt.JwtTokenRequest;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import  com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(TodoJpaResource.class)
class TodoJpaResourceTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    TodoRepository todoRepository;


    @Test
    void shouldAuthorizeUser() throws Exception {

        JwtTokenRequest jwtTokenRequest = new JwtTokenRequest("name", "secret");

        MvcResult mvcResult = mockMvc.perform(post("/authenticate")
                .content(objectMapper.writeValueAsString(jwtTokenRequest))
                .accept(MediaType.APPLICATION_JSON)).andReturn();
        assertEquals(200,mvcResult.getResponse().getStatus());
    }

    @Test
    void shouldFindAllTodos() throws Exception {
        var todos = List.of(new Todo(10001,"name","Get AWS SA certified", LocalDate.now(),false),
                new Todo(10002,"name","Learn Ansible", LocalDate.now(),false),
                new Todo(10003,"name","Learn C", LocalDate.now(),false));

        String username = todos.getFirst().getUsername();
        Mockito.when(todoRepository.findByUsername(username)).thenReturn(todos);

        mockMvc.perform(get("/users/username/todos"))
                .andExpect(status().isUnauthorized())
                .andExpect(content().json(objectMapper.writeValueAsString(todos)));
    }
}