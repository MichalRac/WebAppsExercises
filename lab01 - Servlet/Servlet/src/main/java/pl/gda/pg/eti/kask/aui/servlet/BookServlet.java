/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.gda.pg.eti.kask.aui.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pl.gda.pg.eti.kask.aui.servlet.entities.Book;

/**
 *
 * @author psysiu
 */
@WebServlet(name = "BookServlet", urlPatterns = {"/books"})
public class BookServlet extends HttpServlet {

    public static final String BOOK_CONTEXT = "bookContext";
    
    public static final String COMMAND_PARAMETER = "command";
    
    public static final String SAVE_BOOK_COMMAND = "save_book";
    
    private BooksContext getBookContext() {
        BooksContext bookContext = (BooksContext) getServletContext().getAttribute(BOOK_CONTEXT);
        if (bookContext == null) {
            bookContext = new BooksContext();
            getServletContext().setAttribute(BOOK_CONTEXT, bookContext);
        }
        return bookContext;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String command = request.getParameter(COMMAND_PARAMETER);
        if (null != command) {
            switch (command) {
                case SAVE_BOOK_COMMAND: {
                    Integer id = null;
                    try {
                        id = Integer.parseInt(request.getParameter("id"));
                    } catch (NumberFormatException ex) {
                        
                    }
                    String title = request.getParameter("title");
                    String author = request.getParameter("author");
                    Book book = new Book(id, author, title);
                    getBookContext().saveBook(book);
                    response.sendRedirect("list_books.html");
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
        return "Book servlet.";
    }

}
