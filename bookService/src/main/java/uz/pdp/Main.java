package uz.pdp;

import uz.pdp.entity.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Author author1 = new Author("Author One", 1975, "USA", Arrays.asList(new Book(), new Book()));
        Author author2 = new Author("Author Two", 1980, "UK", Arrays.asList(new Book()));
        Author author3 = new Author("Author Three", 1965, "Canada", Arrays.asList(new Book(), new Book(), new Book()));
        Author author4 = new Author("Author Four", 1990, "India", Arrays.asList(new Book(), new Book(), new Book(), new Book()));

        Book book1 = new Book("Book One", author1, 29.99, Genre.FICTION, 1999);
        Book book2 = new Book("Book Two", author2, 39.99, Genre.SCIENCE_FICTION, 2005);
        Book book3 = new Book("Book Three", author1, 19.99, Genre.FANTASY, 2010);

        Order order1 = new Order(new Customer(), Arrays.asList(new Book()), 99.99, true);
        Order order2 = new Order(new Customer(), Arrays.asList(new Book()), 49.99, true);
        Order order3 = new Order(new Customer(), Arrays.asList(new Book()), 19.99, true);

        Customer customer3 = new Customer("John Doe", 30, Arrays.asList(new Book(), new Book()));

        Customer customer1 = new Customer("Alice", 17, Arrays.asList(new Book()));
        Customer customer2 = new Customer("Bob", 25, Arrays.asList(new Book()));
        Customer customer33 = new Customer("Charlie", 40, Arrays.asList(new Book()));
        Customer customer4 = new Customer("Dave", 65, Arrays.asList(new Book()));

        // 1
        List<Book> books1 = Arrays.asList(book1, book2, book3);

        List<String> bookTitles = BookProject.getAllBookTitles(books1);

        bookTitles.forEach(System.out::println);


        // 2
        List<Book> books2 = Arrays.asList(book1, book2, book3);

        List<Book> availableBooks = BookProject.getAvailableBooks(books2);

        availableBooks.forEach(book -> System.out.println(book.getName()));

        //3
        List<Book> books3 = Arrays.asList(book1, book2, book3);

        List<Genre> genres = BookProject.getDistinctGenres(books3);

        genres.forEach(System.out::println);

        //4
        List<Book> books4 = Arrays.asList(book1, book2, book3);

        List<Book> fictionBooks = BookProject.getFictionBooks(books4);

        fictionBooks.forEach(book -> System.out.println(book.getName()));


        //5
        List<Book> books5 = Arrays.asList(book1, book2, book3);

        List<Book> sortedBooks = BookProject.sortBooksByPrice(books5);

        sortedBooks.forEach(book -> System.out.println(book.getName() + ": " + book.getPrice()));


        //6
        List<Book> books6 = Arrays.asList(book1, book2, book3);

        List<String> uniqueAuthors = BookProject.getUniqueAuthorNames(books6);

        uniqueAuthors.forEach(System.out::println);


        //7
        List<Book> books7 = Arrays.asList(book1, book2, book3);

        List<Book> booksAfter2000 = BookProject.getBooksAfter2000(books7);

        booksAfter2000.forEach(book -> System.out.println(book.getName()));

        //8
        List<Book> books8 = Arrays.asList(book1, book2, book3);

        List<Book> booksByAuthor = BookProject.getBooksByAuthor(books8, "Author One");

        booksByAuthor.forEach(book -> System.out.println(book.getName()));

        //9
        List<Book> books9 = Arrays.asList(book1, book2, book3);

        Optional<Book> mostExpensiveBook = BookProject.getMostExpensiveBook(books9);

        mostExpensiveBook.ifPresent(book -> System.out.println(book.getName() + ": " + book.getPrice()));

        //10
        List<Book> books10 = Arrays.asList(book1, book2, book3);

        OptionalDouble avgPrice = BookProject.getAveragePriceOfBooks(books10);

        avgPrice.ifPresent(price -> System.out.println("Average price: " + price));

        //11
        List<Book> books11 = Arrays.asList(book1, book2, book3);

        long totalBooks = BookProject.countTotalBooks(books11);

        System.out.println("Total books: " + totalBooks);

        //12
        List<Book> books12 = Arrays.asList(book1, book2, book3);

        List<Book> cheapestBooks = BookProject.getTop5CheapestBooks(books12);

        cheapestBooks.forEach(book -> System.out.println(book.getName() + ": " + book.getPrice()));

        //13
        List<Book> books13 = Arrays.asList(book1, book2, book3);

        boolean anySoldOut = BookProject.isAnyBookSoldOut(books13);

        System.out.println("Any book sold out: " + anySoldOut);

        //14
        Customer customer1 = new Customer("Customer One", 25, Arrays.asList(book1));
        Customer customer2 = new Customer("Customer Two", 30, Arrays.asList(book2));

        List<Customer> customers1 = Arrays.asList(customer1, customer2);

        List<Customer> fantasyCustomers = BookProject.getCustomersByGenre(customers1, Genre.FANTASY);

        fantasyCustomers.forEach(customer -> System.out.println(customer.getName()));

        //15
        List<Customer> customers2 = Arrays.asList(customer1, customer2);

        Map<String, Long> customerBookCounts = BookProject.getCustomerBookCounts(customers2);

        customerBookCounts.forEach((name, count) -> System.out.println(name + " purchased " + count + " books"));

        //16
        List<Book> books14 = Arrays.asList(book1, book2, book3);

        Optional<Book> oldestBook = BookProject.findOldestBook(books14);

        oldestBook.ifPresent(book -> System.out.println("Oldest book: " + book.getName() + " published in " + book.getPublicationYear()));

        //17
        List<Order> orders1 = Arrays.asList(order1, order2, order3);

        double totalRevenue = BookProject.calculateTotalRevenue(orders1);

        System.out.println("Total revenue: so'm" + totalRevenue);

        //18
        List<Order> orders2 = Arrays.asList(order1, order2, order3);

        List<Order> undeliveredOrders = BookProject.findUndeliveredOrders(orders2);

        undeliveredOrders.forEach(order -> System.out.println("Undelivered order for customer: " + order.getCustomer().getName()));

        //19
        List<Book> books15 = Arrays.asList(book1, book2, book3);

        Map<Genre, List<Book>> booksByGenre = BookProject.groupBooksByGenre(books15);

        booksByGenre.forEach((genre, genreBooks) -> {
            System.out.println(genre + ":");
            genreBooks.forEach(book -> System.out.println(" - " + book.getName()));
        });

        //20
        List<Book> books16 = Arrays.asList(book1, book2, book3);

        List<Book> sortedBooks2 = BookProject.sortBooksByYearAndPrice(books16);

        sortedBooks2.forEach(book -> System.out.println(book.getName() + " (" + book.getPublicationYear() + ") - so'm" + book.getPrice()));

        //21
        List<Author> authors = Arrays.asList(author1, author2, author3, author4);

        List<Author> top3Authors = BookProject.findTop3Authors(authors);

        top3Authors.forEach(author -> System.out.println(author.getName() + " - " + author.getBooksWritten().size() + " books"));

        //22
        List<Order> orders = Arrays.asList(order1, order2);

        long bookCount = BookProject.countBooksByCustomer(customer3, orders);

        System.out.println(customer3.getName() + " ordered " + bookCount + " books.");

        //23
        List<Book> books = Arrays.asList(book1, book2, book3);

        Optional<Map.Entry<Genre, Long>> mostCommonGenre = BookProject.findMostCommonGenre(books);

        mostCommonGenre.ifPresent(entry -> System.out.println("Most common genre: " + entry.getKey() + " with " + entry.getValue() + " books"));

        //24
        List<Book> books17 = Arrays.asList(book1, book2);

        Set<Author> authors2 = BookProject.findAuthorsWithBooksAfter2015(books);

        authors2.forEach(author -> System.out.println(author.getName()));

        //25
        List<Order> orders3 = Arrays.asList(order1, order2);

        Optional<Order> mostExpensiveOrder = BookProject.findMostExpensiveOrder(orders3);

        mostExpensiveOrder.ifPresent(order -> System.out.println("Eng qimmat order: so'm" + order.getTotalPrice()));

        //26
        List<Book> books18 = Arrays.asList(book1, book2);

        Map<String, Integer> titleWordCounts = BookProject.getBookTitleWordCount(books18);

        titleWordCounts.forEach((title, count) -> System.out.println(title + " has " + count + " ta nomdagi so'zlar"));

        //27
        List<Customer> customers = Arrays.asList(customer1, customer2, customer33, customer4);

        Map<String, List<Customer>> customersByAge = BookProject.groupCustomersByAge(customers);

        customersByAge.forEach((ageGroup, groupCustomers) -> {
            System.out.println(ageGroup + ":");
            groupCustomers.forEach(customer -> System.out.println(" - " + customer.getName()));
        });

        //28
        List<Book> books19 = Arrays.asList(book1, book2, book3);

        Map<Genre, Long> booksPerGenre = BookProject.countBooksPerGenre(books19);

        booksPerGenre.forEach((genre, count) -> System.out.println(genre + ": " + count + " kitoblar"));

        //29
        List<Book> books20 = Arrays.asList(book1, book2);
        List<Author> authors3 = Arrays.asList(author1, author2);
        Order order4 = new Order(new Customer(), Arrays.asList(book1, book2), 49.98, true);

        List<Order> orders4 = Arrays.asList(order4);
        
        BookProject.generateSummary(books20, authors3, orders4);
    }
}
