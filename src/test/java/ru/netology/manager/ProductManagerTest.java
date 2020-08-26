package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ProductManagerTest {
    @Mock
    private ProductRepository repository;
    @InjectMocks
    private ProductManager manager;
    private Product first = new Product(1, "book1", 100);
    private Product second = new Product (2, "LG", 10);
    private Product third = new Product(3,"third", 1);

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
    }

//class ProductManagerTest {
//    private Product[] items = new Product[0];

    @Test
    public void shouldFindBook() {
        repository.findAll();

        manager.matches(1, "book1");

        manager.searchBy("book1");

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("book1");
        assertEquals(expected, actual);

    }

    @Test
    public void shouldFindSmartphone() {
        repository.findAll();

        manager.matches(2, "LG");

        manager.searchBy("LG");

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("LG");
        assertEquals(expected, actual);

    }

}