package dao;

import models.Book;
import models.Library;
import models.Reader;

import java.util.List;

public interface GeneralDao {
    // library
    List<Library> saveLibrary(List<Library> libraries);

    List<Library> getAllLibraries();

    Library getLibraryById(Long id);

    Library updateLibrary(Long id, Library library);

    String deleteLibrary(Long id);

    // book
    Book saveBook(Long libraryId, Book book);

    List<Book> getAllBooks(Long libraryId);

    Book getBookById(Long libraryId, Long bookId);

    String deleteBook(Long libraryId, Long bookId);

    void clearBooksByLibraryId(Long libraryId);

    // reader
    void saveReader(Reader reader);

    List<Reader> getAllReaders();

    Reader getReaderById(Long id);

    Reader updateReader(Long id, Reader reader);

    void assignReaderToLibrary(Long readerId, Long libraryId);
}
