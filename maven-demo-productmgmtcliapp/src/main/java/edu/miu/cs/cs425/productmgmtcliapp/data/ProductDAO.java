package edu.miu.cs.cs425.productmgmtcliapp.data;

import edu.miu.cs.cs425.productmgmtcliapp.model.Product;

import java.time.LocalDate;
import java.util.List;

public class ProductDAO {

    private List<Product> product = null;

    public List<Product> getProducts() {
        return List.of(
                new Product(101L, "Banana", 1.55, LocalDate.of(2023, 6, 6)),
                new Product(102L, "Apple", 1.50, LocalDate.of(2023, 6, 7))
        );
    }
}
