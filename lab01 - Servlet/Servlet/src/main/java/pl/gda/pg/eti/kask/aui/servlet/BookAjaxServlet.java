/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.gda.pg.eti.kask.aui.servlet;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pl.gda.pg.eti.kask.aui.servlet.entities.Book;

/**
 *
 * @author psysiu
 */
@WebServlet(name = "BookAjaxServlet", urlPatterns = {"/books/ajax"})
public class BookAjaxServlet extends HttpServlet {

    public static final String BOOK_CONTEXT = "bookContext";

    public static final String MARKED_BOOKS = "markedBooks";
    
    public static final String COMMAND_PARAMETER = "command";

    public static final String LIST_BOOKS_COMMAND = "list_books";

    public static final String MARK_BOOK_COMMAND = "mark_book";
    
    public static final String LIST_MARKED_BOOKS_COMMAND = "list_marked_books";
    
    public static final String FIND_BOOK_COMMAND = "find_book";

    public static final String MARKED_BOOK_ID_PARAMETER = "marked_book_id";

    public static final String BOOK_ID_PARAMETER = "book_id";

    private BooksContext getBookContext() {
        BooksContext bookContext = (BooksContext) getServletContext().getAttribute(BOOK_CONTEXT);
        if (bookContext == null) {
            bookContext = new BooksContext();
            getServletContext().setAttribute(BOOK_CONTEXT, bookContext);
        }
        return bookContext;
    }

    private List<Book> getMarkedBooks(HttpSession session) {
        List<Book> markedBooks = (List<Book>) session.getAttribute(MARKED_BOOKS);
        if (markedBooks == null) {
            markedBooks = new ArrayList<>();
            session.setAttribute(MARKED_BOOKS, markedBooks);
        }
        return markedBooks;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String command = request.getParameter(COMMAND_PARAMETER);
        if (null != command) {
            switch (command) {
                case LIST_BOOKS_COMMAND: {
                    List<Book> books = getBookContext().findAllBooks();
                    String jsonBooks = new Gson().toJson(books);
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().write(jsonBooks);
                    break;
                }
                case MARK_BOOK_COMMAND: {
                    Integer markedBookId = Integer.parseInt(request.getParameter(MARKED_BOOK_ID_PARAMETER));
                    Book markedBook = getBookContext().findBook(markedBookId);
                    List<Book> markedBooks = getMarkedBooks(request.getSession());
                    if (!markedBooks.contains(markedBook)) {
                        markedBooks.add(markedBook);
                    }
                    break;
                }
                case LIST_MARKED_BOOKS_COMMAND: {
                    List<Book> markedBooks = getMarkedBooks(request.getSession());
                    String jsonMarkedBooks = new Gson().toJson(markedBooks);
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().write(jsonMarkedBooks);
                    break;
                }
                case FIND_BOOK_COMMAND: {
                    Integer book_id = Integer.parseInt(request.getParameter(BOOK_ID_PARAMETER));
                    Book book = getBookContext().findBook(book_id);
                    String jsonBook = new Gson().toJson(book);
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().write(jsonBook);
                    break;
                }
            }
        }
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     *
     * @return
     */
    @Override
    public String getServletInfo() {
        return "Book ajax servlet.";
    }

}
