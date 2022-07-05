package com.zemanta.summerschool.restclientsdemo;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class VanillaClient {
  public static void main(String[] args) {
    final ObjectMapper objectMapper = new ObjectMapper();

    try {
      final HttpRequest request = HttpRequest.newBuilder()
          .uri(new URI("http://localhost:8081/books"))
          .GET()
          .build();

      final HttpResponse<String> response = HttpClient
          .newHttpClient()
          .send(request, HttpResponse.BodyHandlers.ofString());

      final String body = response.body();

      final List<BookDto> books = Arrays.asList(objectMapper.readValue(body, BookDto[].class));

      System.out.println(books);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  @Data
  public static class BookDto {
    private long id;
    private String name;
  }
}
