package pl.gda.pg.eti.kask.aui.servlet.entities;

import java.io.Serializable;

/**
 *
 * @author psysiu
 */
public class Book implements Serializable {

    private Integer id;

    private String author;

    private String title;

    public Book() {
    }

    public Book(Integer id, String author, String title) {
        this.id = id;
        this.author = author;
        this.title = title;
    }

    public Book(String author, String title) {
        this.author = author;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
