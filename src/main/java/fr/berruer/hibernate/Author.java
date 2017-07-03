package fr.berruer.hibernate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Author {

    @Id
    @GenericGenerator(name = "kaugen", strategy = "increment")
    @GeneratedValue(generator = "kaugen")
    private Long id;
    private String firstname;
    private String name;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Edition> editions = new ArrayList<Edition>();

    public String getFirstname() {
	return firstname;
    }

    public void setFirstname(String firstname) {
	this.firstname = firstname;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public Long getId() {
	return id;
    }

    public boolean addEdition(Book book) {
	Edition edition = new Edition();
	edition.setDate(LocalDate.now());
	edition.setAuthor(this);
	edition.setBook(book);

	book.setEdition(edition);
	return editions.add(edition);
    }

    public List<Edition> getEditions() {
	return editions;
    }

}
