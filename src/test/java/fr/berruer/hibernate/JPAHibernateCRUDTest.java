package fr.berruer.hibernate;

import java.time.LocalDate;

import org.apache.log4j.Logger;
import org.junit.Test;

public class JPAHibernateCRUDTest extends JPAHibernateTest {

    private static final Logger LOGGER = Logger
	    .getLogger(JPAHibernateCRUDTest.class);

    // @Test
    // public void testPersist_success() {
    // Author author = new Author();
    // author.setFirstname("BERRUER");
    // author.setName("Sébastien");
    //
    // em.getTransaction().begin();
    // em.persist(author);
    // em.getTransaction().commit();
    //
    // assertNotNull(author);
    // assertNotNull(author.getId());
    // }

    @Test
    public void testPersist_book() {
	Author author = new Author();
	author.setFirstname("BERRUER");
	author.setName("Sébastien");

	Book book1 = new Book();
	book1.setTitle("Mon 1er livre");

	Book book2 = new Book();
	book2.setTitle("Best seller");

	// author.addEdition(book1);
	// author.addEdition(book2);

	Edition editionB1 = new Edition();
	editionB1.setAuthor(author);
	editionB1.setBook(book1);
	editionB1.setDate(LocalDate.now());
	author.getEditions().add(editionB1);
	book1.setEdition(editionB1);

	Edition editionB2 = new Edition();
	editionB2.setAuthor(author);
	editionB2.setBook(book2);
	editionB2.setDate(LocalDate.now());
	author.getEditions().add(editionB2);
	book1.setEdition(editionB2);

	em.getTransaction().begin();
	em.persist(book1);
	em.persist(book2);
	em.persist(author);
	em.getTransaction().commit();

	LOGGER.info("fin de l'enregistrement");
	// }
	//
	// @Test
	// public void testRemove_book() {
	em.getTransaction().begin();
	Author authorDB = em.find(Author.class, 1L);
	Edition edition = author.getEditions().get(0);
	author.getEditions().remove(edition);
	edition.getBook().setEdition(null);
	// authorDB.getEditions().remove(0);
	em.getTransaction().commit();

	// assertNotNull(author);
	// assertNotNull(author.getId());
	// assertNotNull(book1.getId());
	// assertNotNull(book2.getId());
    }

}
