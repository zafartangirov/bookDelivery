package uz.pdp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.entity.Customer;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Customer customer;
    private List<Book> orderedBooks = new ArrayList<>();
    private Double totalPrice;
    private Boolean isDelivered;
}
