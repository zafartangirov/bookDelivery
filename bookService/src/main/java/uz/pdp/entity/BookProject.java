package uz.pdp.entity;

import java.util.*;
import java.util.stream.Collectors;

public class BookProject {

    public static List<String> getAllBookTitles(List<Book> books) {
        return books.stream()
                .map(Book::getName)
                .collect(Collectors.toList());
    }

    public static List<Book> getAvailableBooks(List<Book> books) {
        return books.stream()
                .filter(book -> book.getPrice() > 0)
                .collect(Collectors.toList());
    }

    public static List<Genre> getDistinctGenres(List<Book> books) {
        return books.stream()
                .map(Book::getGenre)
                .distinct()
                .collect(Collectors.toList());
    }

    public static List<Book> getFictionBooks(List<Book> books) {
        return books.stream()
                .filter(book -> book.getGenre() == Genre.FICTION)
                .collect(Collectors.toList());
    }

    public static List<Book> sortBooksByPrice(List<Book> books) {
        return books.stream()
                .sorted(Comparator.comparingDouble(Book::getPrice))
                .collect(Collectors.toList());
    }

    public static List<String> getUniqueAuthorNames(List<Book> books) {
        return books.stream()
                .map(book -> book.getAuthor().getName())
                .distinct()
                .collect(Collectors.toList());
    }

    public static List<Book> getBooksAfter2000(List<Book> books) {
        return books.stream()
                .filter(book -> book.getPublicationYear() > 2000)
                .collect(Collectors.toList());
    }

    public static List<Book> getBooksByAuthor(List<Book> books, String authorName) {
        return books.stream()
                .filter(book -> book.getAuthor().getName().equals(authorName))
                .collect(Collectors.toList());
    }

    public static Optional<Book> getMostExpensiveBook(List<Book> books) {
        return books.stream()
                .max(Comparator.comparingDouble(Book::getPrice));
    }

    public static OptionalDouble getAveragePriceOfBooks(List<Book> books) {
        return books.stream()
                .mapToDouble(Book::getPrice)
                .average();
    }

    public static long countTotalBooks(List<Book> books) {
        return books.stream()
                .count();
    }

    public static List<Book> getTop5CheapestBooks(List<Book> books) {
        return books.stream()
                .sorted(Comparator.comparingDouble(Book::getPrice))
                .limit(5)
                .collect(Collectors.toList());
    }

    public static boolean isAnyBookSoldOut(List<Book> books) {
        return books.stream()
                .anyMatch(book -> book.getPrice() == 0.0);
    }

    public static List<Customer> getCustomersByGenre(List<Customer> customers, Genre genre) {
        return customers.stream()
                .filter(customer -> customer.getPurchasedBooks().stream()
                        .anyMatch(book -> book.getGenre() == genre))
                .collect(Collectors.toList());
    }

    public static Map<String, Long> getCustomerBookCounts(List<Customer> customers) {
        return customers.stream()
                .collect(Collectors.toMap(
                        Customer::getName,
                        customer -> customer.getPurchasedBooks().stream().count()
                ));
    }

    public static Optional<Book> findOldestBook(List<Book> books) {
        return books.stream()
                .min(Comparator.comparingInt(Book::getPublicationYear));
    }

    public static double calculateTotalRevenue(List<Order> orders) {
        return orders.stream()
                .mapToDouble(Order::getTotalPrice)
                .sum();
    }

    public static List<Order> findUndeliveredOrders(List<Order> orders) {
        return orders.stream()
                .filter(order -> !order.getIsDelivered())
                .collect(Collectors.toList());
    }

    public static Map<Genre, List<Book>> groupBooksByGenre(List<Book> books) {
        return books.stream()
                .collect(Collectors.groupingBy(Book::getGenre));
    }

    public static List<Book> sortBooksByYearAndPrice(List<Book> books) {
        return books.stream()
                .sorted((b1, b2) -> {
                    int yearComparison = Integer.compare(b1.getPublicationYear(), b2.getPublicationYear());
                    if (yearComparison == 0) {
                        return Double.compare(b1.getPrice(), b2.getPrice());
                    }
                    return yearComparison;
                })
                .collect(Collectors.toList());
    }

    public static List<Author> findTop3Authors(List<Author> authors) {
        return authors.stream()
                .sorted((a1, a2) -> Integer.compare(a2.getBooksWritten().size(), a1.getBooksWritten().size()))
                .limit(3)
                .collect(Collectors.toList());
    }

    public static long countBooksByCustomer(Customer customer, List<Order> orders) {
        return orders.stream()
                .filter(order -> order.getCustomer().equals(customer))
                .flatMap(order -> order.getOrderedBooks().stream())
                .count();
    }

    public static Optional<Map.Entry<Genre, Long>> findMostCommonGenre(List<Book> books) {
        return books.stream()
                .collect(Collectors.groupingBy(Book::getGenre, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue());
    }
    public static Set<Author> findAuthorsWithBooksAfter2015(List<Book> books) {
        return books.stream()
                .filter(book -> book.getPublicationYear() > 2015)
                .map(Book::getAuthor)
                .collect(Collectors.toSet());
    }

    public static Optional<Order> findMostExpensiveOrder(List<Order> orders) {
        return orders.stream()
                .max(Comparator.comparingDouble(Order::getTotalPrice));
    }

    public static Map<String, Integer> getBookTitleWordCount(List<Book> books) {
        return books.stream()
                .collect(Collectors.toMap(Book::getName, book -> book.getName().split(" ").length));
    }
    public static Map<String, List<Customer>> groupCustomersByAge(List<Customer> customers) {
        return customers.stream()
                .collect(Collectors.groupingBy(customer -> {
                    if (customer.getAge() < 18) return "kichik 18 dan";
                    else if (customer.getAge() <= 35) return "18 - 35";
                    else if (customer.getAge() <= 60) return "35 - 60";
                    else return "60 dan katta";
                }));
    }
    public static Map<Genre, Long> countBooksPerGenre(List<Book> books) {
        return books.stream()
                .collect(Collectors.groupingBy(Book::getGenre, Collectors.counting()));
    }
}
