package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class ProductManagerTest {

    private ProductRepository repository = new ProductRepository();

    private ProductManager manager = new ProductManager(repository);

    private Product first = new Book(1, "book1", 100, "Ivanov");
    private Product second = new Smartphone (2, "LG", 10, "LG Electronics Inc");
    private Product third = new Book(3,"third", 1, "Popov");
    private Product fourth = new Book(4, "book4", 50, "Petrov");
    private Product fifth= new Smartphone (5, "Samsung", 300, "Samsung Corporation");
    private Product sixth = new Book(6,"sixth", 20, "Popov");

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
    }


    @Test
    public void shouldSearchByBookName() {
        Product[] expected = {new Book(1, "book1", 100, "Ivanov")} ;
        Product[] actual = manager.searchBy("book1");
        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldSearchByBookAuthor() {
        Product[] expected = {new Book(4, "book4", 50, "Petrov")};
        Product[] actual = manager.searchBy("Petrov");
        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldSearchBySmartphoneName() {
        Product[] expected = {new Smartphone(2, "LG", 10, "LG Electronics Inc")};
        Product[] actual = manager.searchBy("LG");
        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldSearchBySmartphoneManufacturer() {
        Product[] expected = {new Smartphone(5, "Samsung", 300, "Samsung Corporation")};
        Product[] actual = manager.searchBy("Samsung Corporation");
        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldSearchByNoData() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("Lenin");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByMoreOneData() {
        Product[] expected = {new Book(3,"third", 1, "Popov"),
                              new Book(6,"sixth", 20, "Popov")};
        Product[] actual = manager.searchBy("Popov");
        assertArrayEquals(expected, actual);
    }
}