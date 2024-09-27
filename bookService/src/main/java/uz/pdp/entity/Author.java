package uz.pdp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    private String name;
    private Integer birthYear;
    private String nationality;
    private List<Book> booksWritten;
}
