import Service.impl.BookImpl;
import Service.impl.LibraryImpl;
import Service.impl.ReaderImpl;
import enums.Gender;
import enums.Genre;
import models.Book;
import models.Library;
import models.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    static LibraryImpl libraryService = new LibraryImpl();
    static BookImpl bookService = new BookImpl();
    static ReaderImpl readerService = new ReaderImpl();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("""
                    1. Libraries options
                    2. Books options
                    3. Readers options
                    4. Exit
                    """);
            switch (scanner.nextLine()) {
                case "1" -> {
                    boolean isLoop = true;
                    while (isLoop) {
                        System.out.println("""
                                ----Library----
                                1. Add library
                                2. Get all library
                                3. Get library by id
                                4. Update library by id
                                5. Delete library by id
                                6. Exit
                                """);
                        switch (scanner.nextLine()) {
                            case "1" -> {
                                boolean bigLoop = true;
                                List<Library> libraries = new ArrayList<>();
                                while (bigLoop) {
                                    System.out.println("""
                                            1. Add library
                                            2. Done
                                            """);
                                    String choice = scanner.nextLine();
                                    switch (choice) {
                                        case "1" -> {
                                            Library library = new Library();
                                            System.out.print("Write the name: ");
                                            String name = scanner.nextLine();
                                            library.setName(name);
                                            System.out.print("Write the address: ");
                                            String address = scanner.nextLine();
                                            library.setAddress(address);
                                            library.setBooks(new ArrayList<>());
                                            library.setReaders(new ArrayList<>());
                                            libraries.add(library);

                                        }
                                        case "2" -> {
                                            System.out.println("Add " + libraries.size() + " libraries!");
                                            List<Library> allLibrary = libraryService.saveLibrary(libraries);
                                            System.out.println("All Library: " + allLibrary);
                                            bigLoop = false;
                                        }
                                        default -> {
                                            System.out.println("Invalid value!");
                                        }
                                    }
                                }
                            }
                            case "2" -> {
                                List<Library> allLibraries = libraryService.getAllLibraries();
                                if (!allLibraries.isEmpty()) {
                                    System.out.println("All libraries: ");
                                    for (Library allLibrary : allLibraries) {
                                        System.out.println(allLibrary);
                                    }
                                } else {
                                    System.out.println("Library is empty!");
                                }
                            }
                            case "3" -> {
                                System.out.println("Write the library id: ");
                                String id = scanner.nextLine();
                                if (id.matches("\\d+")) {
                                    System.out.println("Library by id " + id + ": " + libraryService.getLibraryById(Long.parseLong(id)));
                                } else {
                                    System.out.println("Invalid value!");
                                }
                            }
                            case "4" -> {
                                System.out.println("Write the library id: ");
                                String id = scanner.nextLine();
                                Library library = new Library();
                                System.out.print("Write the name: ");
                                String name = scanner.nextLine();
                                library.setName(name);
                                System.out.print("Write the address: ");
                                String address = scanner.nextLine();
                                library.setAddress(address);
                                if (id.matches("\\d+")) {
                                    library.setId(Long.parseLong(id));
                                    System.out.println("Old library: " + libraryService.updateLibrary(Long.parseLong(id), library));
                                    System.out.println("New library: " + library);
                                }
                            }
                            case "5" -> {
                                System.out.println("Write the library id: ");
                                String id = scanner.nextLine();
                                if (id.matches("\\d+")) {
                                    System.out.println(libraryService.deleteLibrary(Long.parseLong(id)));
                                } else {
                                    System.out.println("Invalid value!");
                                }
                            }
                            case "6" -> {
                                isLoop = false;
                            }
                            default -> {
                                System.out.println("Invalid value!");
                            }
                        }
                    }
                }
                case "2" -> {
                    boolean isLoop = true;
                    while (isLoop) {
                        System.out.println("""
                                1. Add new book
                                2. Get all books
                                3. Get book by id
                                4. Delete book by id
                                5. Clear book by library id
                                6. Exit
                                """);
                        switch (scanner.nextLine()) {
                            case "1" -> {
                                Book book = new Book();
                                System.out.print("Write the name: ");
                                String name = scanner.nextLine();
                                if (!name.isEmpty()) {
                                    book.setName(name);
                                }
                                System.out.print("Write the author: ");
                                String author = scanner.nextLine();
                                if (!author.isEmpty()) {
                                    book.setAuthor(author);
                                }
                                System.out.println("Choice the genre: ");
                                Genre[] values = Genre.values();
                                for (int i = 0; i < values.length; i++) {
                                    System.out.println((i + 1) + ". " + values[i]);
                                }
                                String value = scanner.nextLine();
                                for (int i = 0; i < values.length; i++) {
                                    if (value.matches("\\d+")) {
                                        if (Integer.parseInt(value) == (i + 1)) {
                                            book.setGenre(values[i + 1]);
                                            break;
                                        }
                                    }
                                }
                                System.out.println("Please write the library id: ");
                                List<Library> allLibraries = libraryService.getAllLibraries();
                                if (!allLibraries.isEmpty()) {
                                    System.out.println("All libraries: ");
                                    for (Library allLibrary : allLibraries) {
                                        System.out.println(allLibrary);
                                    }
                                } else {
                                    System.out.println("Library is empty!");
                                }
                                String id = scanner.nextLine();
                                if (id != null) {
                                    Book book1 = bookService.saveBook(Long.parseLong(id), book);
                                }
                            }
                            case "2" -> {
                                System.out.println("Write the library id: ");
                                List<Library> allLibraries = libraryService.getAllLibraries();
                                if (!allLibraries.isEmpty()) {
                                    System.out.println("All libraries: ");
                                    for (Library allLibrary : allLibraries) {
                                        System.out.println(allLibrary);
                                    }
                                } else {
                                    System.out.println("Library is empty!");
                                }
                                String id = scanner.nextLine();
                                if (!Objects.equals(id, "") && id != null) {
                                    List<Book> allBooks = bookService.getAllBooks(Long.parseLong(id));
                                    for (Book allBook : allBooks) {
                                        System.out.println(allBook);
                                    }
                                }
                            }
                            case "3" -> {
                                System.out.println("Write the library id: ");
                                String libId = scanner.nextLine();
                                System.out.println("Write the book id: ");
                                String id = scanner.nextLine();
                                if (libId.matches("\\d+") && id.matches("\\d+")) {
                                    Book bookById = bookService.getBookById(Long.parseLong(libId), Long.parseLong(id));
                                    System.out.println(bookById);
                                }
                            }
                            case "4" -> {
                                System.out.println("Write the library id: ");
                                String libId = scanner.nextLine();
                                System.out.println("Write the book id: ");
                                String id = scanner.nextLine();
                                if (libId.matches("\\d+") && id.matches("\\d+")) {
                                    String message = bookService.deleteBook(Long.parseLong(libId), Long.parseLong(id));
                                    System.out.println(message);
                                }
                            }
                            case "5" -> {
                                System.out.println("Write the library id: ");
                                String libId = scanner.nextLine();
                                if (libId.matches("\\d+")) {
                                    bookService.clearBooksByLibraryId(Long.parseLong(libId));
                                }
                            }
                            case "6" -> {
                                isLoop = false;
                            }
                            default -> {
                                System.out.println("Invalid value!");
                            }
                        }
                    }
                }
                case "3" -> {
                    boolean isLoop = true;
                    while (isLoop) {
                        System.out.println("""
                                1. Add new reader
                                2. Get all readers
                                3. Get reader by id
                                4. Update reader by id
                                5. Add reader to library
                                6. Exit
                                """);
                        switch (scanner.nextLine()) {
                            case "1" -> {
                                Reader reader = new Reader();
                                System.out.println("Write the full name: ");
                                String name = scanner.nextLine();
                                if (!name.isEmpty()) {
                                    reader.setFullName(name);
                                }
                                System.out.println("Write the email: ");
                                String email = scanner.nextLine();
                                if (email.contains("@")) {
                                    reader.setEmail(email);
                                }
                                System.out.println("Write the phone number: ");
                                String number = scanner.nextLine();
                                if (number.matches("\\d+")) {
                                    reader.setPhoneNumber(number);
                                }
                                System.out.println("Choice gender: ");
                                for (int i = 0; i < Gender.values().length; i++) {
                                    System.out.println((i + 1) + ". " + Gender.values()[i].toString().toLowerCase());
                                }
                                String choice = scanner.nextLine();
                                if (choice.equals("1")) {
                                    reader.setGender(Gender.values()[0]);
                                } else if (choice.equals("2")) {
                                    reader.setGender(Gender.values()[1]);
                                } else {
                                    System.out.println("Invalid value!");
                                }
                                readerService.saveReader(reader);
                            }
                            case "2" -> {
                                List<Reader> allReaders = readerService.getAllReaders();
                                if (!allReaders.isEmpty()) {
                                    System.out.println("All readers: ");
                                    for (Reader allReader : allReaders) {
                                        System.out.println(allReader);
                                    }
                                } else {
                                    System.out.println("Readers is empty!");
                                }
                            }
                            case "3" -> {
                                System.out.println("Write the reader id: ");
                                String id = scanner.nextLine();
                                if (id.matches("\\d+")) {
                                    Reader readerById = readerService.getReaderById(Long.parseLong(id));
                                    System.out.println(readerById);
                                }
                            }
                            case "4" -> {
                                System.out.println("Write the reader id: ");
                                String id = scanner.nextLine();
                                if (id.matches("\\d+")) {
                                    Reader reader = new Reader();
                                    System.out.println("Write the full name: ");
                                    String name = scanner.nextLine();
                                    if (!name.isEmpty()) {
                                        reader.setFullName(name);
                                    }
                                    System.out.println("Write the email: ");
                                    String email = scanner.nextLine();
                                    if (email.contains("@")) {
                                        reader.setEmail(email);
                                    }
                                    System.out.println("Write the phone number: ");
                                    String number = scanner.nextLine();
                                    if (number.matches("\\d+")) {
                                        reader.setPhoneNumber(number);
                                    }
                                    System.out.println("Choice gender: ");
                                    for (int i = 0; i < Gender.values().length; i++) {
                                        System.out.println((i + 1) + ". " + Gender.values()[i].toString().toLowerCase());
                                    }
                                    String choice = scanner.nextLine();
                                    if (choice.equals("1")) {
                                        reader.setGender(Gender.values()[0]);
                                    } else if (choice.equals("2")) {
                                        reader.setGender(Gender.values()[1]);
                                    } else {
                                        System.out.println("Invalid value!");
                                    }
                                    Reader reader1 = readerService.updateReader(Long.parseLong(id), reader);
                                    System.out.println("Old value: " + reader1);
                                    System.out.println("New value: " + reader);
                                }
                            }
                            case "5" -> {
                                System.out.println("Write the reader id: ");
                                String readerId = scanner.nextLine();
                                System.out.println("Write the library id: ");
                                String libId = scanner.nextLine();
                                if (readerId.matches("\\d+") && libId.matches("\\d+")) {
                                    readerService.assignReaderToLibrary(Long.parseLong(readerId), Long.parseLong(libId));
                                }
                            }
                            case "6" -> {
                                isLoop = false;
                            }
                            default -> {
                                System.out.println("Invalid value!");
                            }
                        }
                    }
                }
                case "4" -> {
                    return;
                }
                default -> {
                    System.out.println("Invalid value!");
                }
            }

        }
    }
}