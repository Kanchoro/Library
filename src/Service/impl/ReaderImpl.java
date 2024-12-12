package Service.impl;

import Service.ReaderService;
import dao.GeneralDao;
import models.Book;
import models.Library;
import models.Reader;

import java.util.List;

public class ReaderImpl implements ReaderService {
    GeneralDao generalDao = new GeneralDao() {
        @Override
        public List<Library> saveLibrary(List<Library> libraries) {
            return List.of();
        }

        @Override
        public List<Library> getAllLibraries() {
            return List.of();
        }

        @Override
        public Library getLibraryById(Long id) {
            return null;
        }

        @Override
        public Library updateLibrary(Long id, Library library) {
            return null;
        }

        @Override
        public String deleteLibrary(Long id) {
            return "";
        }

        @Override
        public Book saveBook(Long libraryId, Book book) {
            return null;
        }

        @Override
        public List<Book> getAllBooks(Long libraryId) {
            return List.of();
        }

        @Override
        public Book getBookById(Long libraryId, Long bookId) {
            return null;
        }

        @Override
        public String deleteBook(Long libraryId, Long bookId) {
            return "";
        }

        @Override
        public void clearBooksByLibraryId(Long libraryId) {

        }

        @Override
        public void saveReader(Reader reader) {

        }

        @Override
        public List<Reader> getAllReaders() {
            return List.of();
        }

        @Override
        public Reader getReaderById(Long id) {
            return null;
        }

        @Override
        public Reader updateReader(Long id, Reader reader) {
            return null;
        }

        @Override
        public void assignReaderToLibrary(Long readerId, Long libraryId) {

        }
    };
    @Override
    public void saveReader(Reader reader) {
        generalDao.saveReader(reader);
    }

    @Override
    public List<Reader> getAllReaders() {
        return generalDao.getAllReaders();
    }

    @Override
    public Reader getReaderById(Long id) {
        return generalDao.getReaderById(id);
    }

    @Override
    public Reader updateReader(Long id, Reader reader) {
        return generalDao.updateReader(id, reader);
    }

    @Override
    public void assignReaderToLibrary(Long readerId, Long libraryId) {
        generalDao.assignReaderToLibrary(readerId, libraryId);
    }

}
