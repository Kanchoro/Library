package Service.impl;

import Service.BookService;
import dao.Impl.GeneralDaoService;
import models.Book;

import java.util.List;

public class BookImpl implements BookService {
    GeneralDaoService generalDao = new GeneralDaoService();
    @Override
    public Book saveBook(Long libraryId, Book book) {
        return generalDao.saveBook(libraryId, book);
    }

    @Override
    public List<Book> getAllBooks(Long libraryId) {
        return generalDao.getAllBooks(libraryId);
    }

    @Override
    public Book getBookById(Long libraryId, Long bookId) {
        return generalDao.getBookById(libraryId, bookId);
    }

    @Override
    public String deleteBook(Long libraryId, Long bookId) {
        return generalDao.deleteBook(libraryId, bookId);
    }

    @Override
    public void clearBooksByLibraryId(Long libraryId) {
        generalDao.clearBooksByLibraryId(libraryId);
    }
}
