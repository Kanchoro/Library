package dao.Impl;

import dao.GeneralDao;
import db.DataBase;
import models.Book;
import models.Library;
import models.Reader;

import java.util.ArrayList;
import java.util.List;

public class GeneralDaoService implements GeneralDao {
    @Override
    public List<Library> saveLibrary(List<Library> libraries) {
        for (Library library : libraries) {
            boolean add = DataBase.libraries.add(library);
        }
        return DataBase.libraries;
    }

    @Override
    public List<Library> getAllLibraries() {
        return DataBase.libraries;
    }

    @Override
    public Library getLibraryById(Long id) {
        int index = -1;
        for (int i = 0; i < DataBase.libraries.size(); i++) {
            if (DataBase.libraries.get(i).getId() == id) {
                index = i;
                break;
            }
        }
        return DataBase.libraries.get(index);
    }

    @Override
    public Library updateLibrary(Long id, Library library) {
        Library old = null;
        for (int i = 0; i < DataBase.libraries.size(); i++) {
            if (DataBase.libraries.get(i).getId() == id) {
                old = DataBase.libraries.set(i, library);
                break;
            }
        }
        return old;
    }

    @Override
    public String deleteLibrary(Long id) {
        String message = "";
        if (!DataBase.libraries.isEmpty()) {
            int index = -1;
            for (int i = 0; i < DataBase.libraries.size(); i++) {
                if (DataBase.libraries.get(i).getId() == id) {
                    index = i;
                    break;
                }
            }
            if (index >= 0) {
                Library remove = DataBase.libraries.remove(index);
                if (remove.getId() != 0) {
                    message = "Successfully deleted!";
                } else {
                    message = "Error on deleted!";
                }
            }
        }
        return message;
    }

    @Override
    public Book saveBook(Long libraryId, Book book) {
        for (Library library : DataBase.libraries) {
            if (library.getId() == libraryId) {
                library.getBooks().add(book);
                System.out.println("Successfully added!");
                break;
            }
        }
        return book;
    }

    @Override
    public List<Book> getAllBooks(Long libraryId) {
        List<Book> books = new ArrayList<>();
        for (Library library : DataBase.libraries) {
            if (library.getId() == libraryId) {
                for (Book book : library.getBooks()) {
                    books.add(book);
                }
            }
        }
        return books;
    }

    @Override
    public Book getBookById(Long libraryId, Long bookId) {
        Book book = null;
        for (Library library : DataBase.libraries) {
            if (library.getId() == libraryId) {
                for (Book b : library.getBooks()) {
                    if (b.getId() == bookId) {
                        book = b;
                    }
                }
            }
        }
        if (book != null) {
            System.out.println("Book by id " + bookId + " found!");
        } else {
            System.out.println("Book by id " + bookId + " not found!");
        }
        return book;
    }

    @Override
    public String deleteBook(Long libraryId, Long bookId) {
        int index = -1;
        for (Library library : DataBase.libraries) {
            if (library.getId() == libraryId) {
                for (int i = 0; i < library.getBooks().size(); i++) {
                    if (library.getBooks().get(i).getId() == bookId) {
                        index = i;
                    }
                }
                if (index >= 0) {
                    library.getBooks().remove(index);
                }
            }
        }
        return index >= 0 ? "Successfully deleted!" : "Error on deleted!";
    }

    @Override
    public void clearBooksByLibraryId(Long libraryId) {
        boolean clear = false;
        for (Library library : DataBase.libraries) {
            if (library.getId() == libraryId) {
                library.getBooks().clear();
                clear = true;
                break;
            } else {
                clear = false;
            }
        }
        if (clear) {
            System.out.println("Successfully cleared!");
        } else {
            System.out.println("Error on clear option!");
        }
    }

    @Override
    public void saveReader(Reader reader) {
        boolean add = DataBase.readers.add(reader);
        if (add) {
            System.out.println("Successfully added!");
        } else {
            System.out.println("Error on added reader!");
        }
    }

    @Override
    public List<Reader> getAllReaders() {
        return DataBase.readers;
    }

    @Override
    public Reader getReaderById(Long id) {
        Reader findReader = null;
        for (Reader reader : DataBase.readers) {
            if (reader.getId() == id) {
                findReader = reader;
            }
        }
        return findReader;
    }

    @Override
    public Reader updateReader(Long id, Reader reader) {
        int index = -1;
        Reader oldReader = null;
        for (int i = 0; i < DataBase.readers.size(); i++) {
            if (DataBase.readers.get(i).getId() == id) {
                index = i;
            }
        }
        if (index >= 0) {
            Reader reader1 = DataBase.readers.get(index);
            reader.setId(reader1.getId());
            oldReader = DataBase.readers.set(index, reader);
        }
        return oldReader;
    }

    @Override
    public void assignReaderToLibrary(Long readerId, Long libraryId) {
        Reader findReader = null;
        for (Reader reader : DataBase.readers) {
            if (reader.getId() == readerId) {
                findReader = reader;
                System.out.println("Successfully find reader!");
                break;
            }
        }
        if (findReader != null) {
            for (Library library : DataBase.libraries) {
                if (library.getId() == libraryId) {
                    library.getReaders().add(findReader);
                    System.out.println("Successfully added!");
                    break;
                }
            }
        }
    }
}
