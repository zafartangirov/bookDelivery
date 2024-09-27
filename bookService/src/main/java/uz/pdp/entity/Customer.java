package uz.pdp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.entity.Book;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private String name;
    private Integer age;
    private List<Book> purchasedBooks = new ArrayList<>();
}
