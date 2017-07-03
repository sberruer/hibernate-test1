package fr.berruer.hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
@NamedQueries(value = {
	@NamedQuery(name = "Book.getAll", query = "SELECT b FROM Book b") })
public class Book {

    @Id
    @GenericGenerator(name = "kaugen", strategy = "increment")
    @GeneratedValue(generator = "kaugen")
    private Long id;
    private String title;

    @OneToOne(mappedBy = "book", orphanRemoval = true)
    private Edition edition;

    public Long getId() {
	return id;
    }

    public String getTitle() {
	return title;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    @Override
    public String toString() {
	return "Book{" + "id=" + id + ", title='" + title + '\'' + '}';
    }

    // public Edition getEdition() {
    // return edition;
    // }

    public void setEdition(Edition edition) {
	this.edition = edition;
    }
}