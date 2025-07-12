package org.jallen.tyrael.services;

import org.jallen.tyrael.entity.Application;
import org.jallen.tyrael.mapper.ApplicationMapper;
import org.jallen.tyrael.repositories.ApplicationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ApplicationServiceTest {

  @Mock
  private ApplicationRepository applicationRepository;

  @Mock
  private ApplicationMapper applicationMapper;

  @InjectMocks
  private ApplicationService applicationService;

  @Test
  void shouldFindAllApplications() {
    Application app = new Application();
    app.setId(1L);
    app.setTitle("Test App");

    when(applicationRepository.findAll(Sort.by(Sort.Direction.ASC, "priority")))
      .thenReturn(Arrays.asList(app));

    List<Application> result = applicationService.findAll();

    assertEquals(1, result.size());
    assertEquals("Test App", result.get(0).getTitle());
  }

  @Test
  void shouldFindApplicationById() {
    Application app = new Application();
    app.setId(1L);
    app.setTitle("Test App");

    when(applicationRepository.findById(1L)).thenReturn(Optional.of(app));

    Optional<Application> result = applicationService.findById(1L);

    assertTrue(result.isPresent());
    assertEquals("Test App", result.get().getTitle());
  }

  @Test
  void shouldCreateApplication() {
    Application app = new Application();
    app.setTitle("New App");

    Application savedApp = new Application();
    savedApp.setId(1L);
    savedApp.setTitle("New App");

    when(applicationRepository.save(app)).thenReturn(savedApp);

    Application result = applicationService.create(app);

    assertEquals(1L, result.getId());
    assertEquals("New App", result.getTitle());
  }

  @Test
  void shouldUpdateApplication() {
    Application existingApp = new Application();
    existingApp.setId(1L);
    existingApp.setTitle("Old Title");

    Application updateData = new Application();
    updateData.setTitle("New Title");

    Application mappedApp = new Application();
    mappedApp.setId(1L);
    mappedApp.setTitle("New Title");

    when(applicationRepository.findById(1L)).thenReturn(Optional.of(existingApp));
    when(applicationMapper.getMapping(existingApp, updateData)).thenReturn(mappedApp);
    when(applicationRepository.save(mappedApp)).thenReturn(mappedApp);

    Application result = applicationService.update(1L, updateData);

    assertEquals("New Title", result.getTitle());
  }

  @Test
  void shouldDeleteApplication() {
    when(applicationRepository.existsById(1L)).thenReturn(true);

    applicationService.delete(1L);

    verify(applicationRepository).deleteById(1L);
  }
}