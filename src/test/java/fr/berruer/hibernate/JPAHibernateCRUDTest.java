package fr.berruer.hibernate;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class JPAHibernateCRUDTest extends JPAHibernateTest {

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

	author.addBook(book1);
	author.addBook(book2);

	em.getTransaction().begin();
	em.persist(author);
	em.getTransaction().commit();

	Author authorDB = em.find(Author.class, author.getId());

	assertNotNull(author);
	assertNotNull(author.getId());
	assertNotNull(book1.getId());
	assertNotNull(book2.getId());
    }

}
