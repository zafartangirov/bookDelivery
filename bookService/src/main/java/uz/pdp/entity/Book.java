package uz.pdp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Book {
    private String name;
    private Author author;
    private Double price;
    private Genre genre;
    private int publicationYear;
}
