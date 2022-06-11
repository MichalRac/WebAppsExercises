package pl.gda.pg.eti.kask.aui.rest.servlet;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import pl.gda.pg.eti.kask.aui.rest.entities.Book;

/**
 *
 * @author psysiu
 */
public class BooksContext implements Serializable {

    private final SortedMap<Integer, Book> books;

    public List<Book> findAllBooks() {
        return new ArrayList<>(books.values());
    }

    public BooksContext() {
        books = Collections.synchronizedSortedMap(new TreeMap<Integer, Book>());
    }
    
    public void saveBook(Book book) {
        if (book.getId() == null) {
            book.setId(books.lastKey() + 1);
        }
        books.put(book.getId(), book);
    }

    public Book findBook(Integer id) {
        return books.get(id);
    }

    public void deleteBook(Integer id) {
        if (books.containsKey(id)) {
            books.remove(id);
        }
    }
}
