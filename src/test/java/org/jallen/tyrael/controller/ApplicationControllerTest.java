package org.jallen.tyrael.controller;

import org.jallen.tyrael.entity.Application;
import org.jallen.tyrael.mapper.ApplicationMapper;
import org.jallen.tyrael.services.ApplicationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = ApplicationController.class, excludeAutoConfiguration = {
  org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
})
class ApplicationControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockitoBean
  private ApplicationService applicationService;

  @MockitoBean
  private ApplicationMapper applicationMapper;

  @Test
  void shouldReturnAllApplications() throws Exception {
    Application app = new Application();
    app.setId(1L);
    app.setTitle("Test App");

    when(applicationService.findAll()).thenReturn(Arrays.asList(app));
    when(applicationMapper.getMapping(any())).thenReturn(Arrays.asList(app));

    mockMvc.perform(get("/application"))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$[0].id").value(1))
      .andExpect(jsonPath("$[0].title").value("Test App"));
  }

  @Test
  void shouldReturnApplicationById() throws Exception {
    Application app = new Application();
    app.setId(1L);
    app.setTitle("Test App");

    when(applicationService.findById(1L)).thenReturn(Optional.of(app));

    mockMvc.perform(get("/application/1"))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.id").value(1))
      .andExpect(jsonPath("$.title").value("Test App"));
  }

  @Test
  void shouldCreateApplication() throws Exception {
    Application app = new Application();
    app.setId(1L);
    app.setTitle("New App");

    when(applicationService.create(any(Application.class))).thenReturn(app);

    mockMvc.perform(post("/application")
      .contentType(MediaType.APPLICATION_JSON)
      .content("{\"title\":\"New App\"}"))
      .andExpect(status().isCreated())
      .andExpect(jsonPath("$.id").value(1))
      .andExpect(jsonPath("$.title").value("New App"));
  }
}