package com.andrewxa.a4retrofitcrud.bd;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class Book {

    @Id
    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("published")
    @Expose
    private long published;


    @Generated(hash = 1942379464)
    public Book(long id, String title, String author, String description,
            long published) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.description = description;
        this.published = published;
    }

    @Generated(hash = 1839243756)
    public Book() {
    }


    public long getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getPublished() {
        return published;
    }

    public void setPublished(Integer published) {
        this.published = published;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPublished(long published) {
        this.published = published;
    }

}