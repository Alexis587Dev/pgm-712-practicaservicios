package com.estilista_silvia.backend.infrastructure.web.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estilista_silvia.backend.infrastructure.web.dto.BookRequestDTO;
import com.estilista_silvia.backend.infrastructure.web.dto.auth.LoginDTO;
import com.estilista_silvia.backend.infrastructure.web.dto.auth.LoginResponseDTO;
import com.estilista_silvia.backend.infrastructure.web.dto.other.ApiResponseDTO;
import org.springframework.web.client.RestClient;

@RestController
@RequestMapping("/api")
public class ExternalServiceController {
  private final RestClient restClient;

  public ExternalServiceController(RestClient.Builder restClient) {
    this.restClient = restClient.baseUrl("https://stephen-king-api.onrender.com/api/books").build();
  }

  @GetMapping("/books/{id}")
  public String getBooks(@RequestBody BookRequestDTO bookRequestDTO) {

    return restClient.get()
        .uri("/{id}", bookRequestDTO.getId())
        .retrieve()
        .body(String.class);
  }
}
