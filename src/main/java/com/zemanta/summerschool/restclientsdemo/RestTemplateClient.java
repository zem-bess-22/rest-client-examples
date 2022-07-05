package com.zemanta.summerschool.restclientsdemo;

import lombok.Data;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class RestTemplateClient {
  public static void main(String[] args) {
    final RestTemplate restTemplate = new RestTemplate();

    final var response = restTemplate
        .getForObject("http://localhost:8081/books1", BookDto[].class);

    final List<BookDto> data = Arrays.asList(response);

    System.out.println(data);
  }

  @Data
  public static class BookDto {
    private long id;
    private String name;
  }
}
