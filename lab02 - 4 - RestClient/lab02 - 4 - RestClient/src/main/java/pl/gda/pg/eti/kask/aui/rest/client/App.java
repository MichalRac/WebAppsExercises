package pl.gda.pg.eti.kask.aui.rest.client;

import pl.gda.pg.eti.kask.aui.rest.entities.Book;

import java.util.Scanner;

/**
 *
 * @author psysiu
 */
public class App {

    public static void main(String[] args) {
        BookResource bookResource = new BookResource("http://localhost:8080/Rest-1.0-SNAPSHOT", "psysiu", "psysiu");

        System.out.println(bookResource.saveBook(20, "Gra121232321", "Card"));

        bookResource.listBooks().forEach((book) -> {
            System.out.println(book.getTitle());
        });

        System.out.println(bookResource.saveBook(new Book("Card", "Cień Hegemona")));

        System.out.println(bookResource.findBook(1).getTitle());

        System.out.println("BookId to remove: ");
        String idString = new Scanner(System.in).next();

        try{
            int id = Integer.parseInt(idString);
            bookResource.deleteBook(id);
        }
        catch (NumberFormatException ex)
        {
            ex.printStackTrace();
        }

    }

}
