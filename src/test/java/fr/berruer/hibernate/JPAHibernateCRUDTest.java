package fr.berruer.hibernate;

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

	author.addEdition(book1);
	author.addEdition(book2);

	em.getTransaction().begin();
	em.persist(book1);
	em.persist(book2);
	em.persist(author);
	em.getTransaction().commit();

	LOGGER.info("fin de l'enregistrement");
    }

    @Test
    public void testRemove_book() {
	em.getTransaction().begin();
	Author authorDB = em.find(Author.class, 1L);
	authorDB.getEditions().remove(0);
	em.getTransaction().commit();

	// assertNotNull(author);
	// assertNotNull(author.getId());
	// assertNotNull(book1.getId());
	// assertNotNull(book2.getId());
    }

}
