package com.zemanta.summerschool.restclientsdemo;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Feign;
import feign.RequestLine;
import feign.jackson.JacksonDecoder;
import lombok.Data;

import java.util.List;

public class OpenFeignClient {
  public static void main(String[] args) {
    BooksClient client = Feign.builder()
        .decoder(new JacksonDecoder())
        .target(BooksClient.class, "http://localhost:8081");

    final List<BookDto> books = client.getBooks();

    System.out.println(books);
  }

  public interface BooksClient {
    @RequestLine("GET /books")
    List<BookDto> getBooks();
  }

  @Data
  public static class BookDto {
    private long id;
    private String name;
  }
}
