package com.example.demo.entities;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "rentEntries")
public class RentEntryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date date;

    @ManyToOne
    private UtilizatorModel user;

    @ManyToMany
    private List<BookModel> books;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public UtilizatorModel getUser() {
        return user;
    }

    public void setUser(UtilizatorModel user) {
        this.user = user;
    }

    public List<BookModel> getBooks() {
        return books;
    }

    public void setBooks(List<BookModel> books) {
        this.books = books;
    }
}
