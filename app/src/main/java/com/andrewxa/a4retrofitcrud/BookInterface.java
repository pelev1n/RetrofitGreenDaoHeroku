package com.andrewxa.a4retrofitcrud;

import com.andrewxa.a4retrofitcrud.bd.Book;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface BookInterface {

    @GET("/api/books/")
    Call<List<Book>> getBooks();

    @GET("/api/books/{id}")
    Call<Book> getBook(@Path("id") long id);

    @POST("/api/books/create")
    Call<Book> addBook(@Body Book book);

    @PUT("/api/books/{id}")
    Call<Book> updateBook(@Path("id") long id, @Body Book book);

    @DELETE("/api/books/{id}")
    Call<Book> deleteBook(@Path("id") long id);
}
