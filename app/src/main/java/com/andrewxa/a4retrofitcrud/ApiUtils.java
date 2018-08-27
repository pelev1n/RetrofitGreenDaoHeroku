package com.andrewxa.a4retrofitcrud;

public class ApiUtils {

    public static final String API_URL = "https://spring-boot-mysql-server-part0.herokuapp.com/";

    public ApiUtils() {
    }

    public static BookInterface getBookInterface(){
        return RetrofitClient.getBook(API_URL).create(BookInterface.class);
    }

}