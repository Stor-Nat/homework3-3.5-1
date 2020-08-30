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


    @Test
    public void shouldFindBookName() {
        repository.findAll();

        boolean isMatch = manager.matches(new Book(4, "book4", 100, "Ivanov"),"book4");
        assertTrue(isMatch);
    }

    @Test
    public void shouldNotFindBookName() {
        repository.findAll();

        boolean isMatch = manager.matches(new Book(4, "book4", 100, "Ivanov"),"book5");
        assertFalse(isMatch);
    }

    @Test
    public void shouldFindBookAuthor() {
        repository.findAll();

        boolean isMatch = manager.matches(new Book(4, "book4", 100, "Ivanov"),"Ivanov");
        assertTrue(isMatch);
    }

    @Test
    public void shouldNotFindBookAuthor() {
        repository.findAll();

        boolean isMatch = manager.matches(new Book(4, "book4", 100, "Ivanov"),"Petrov");
        assertFalse(isMatch);
    }

    @Test
    public void shouldFindSmartphoneName() {
        repository.findAll();

        boolean isMatch = manager.matches(new Smartphone(2, "LG", 1000, "LG Electronics Inc"), "LG");
        assertTrue(isMatch);
    }

    @Test
    public void shouldNotFindSmartphoneName() {
        repository.findAll();

        boolean isMatch = manager.matches(new Smartphone(2, "LG", 1000, "LG Electronics Inc"), "Fly");
        assertFalse(isMatch);
    }

    @Test
    public void shouldFindSmartphoneManufacturer() {
        repository.findAll();

        boolean isMatch = manager.matches(new Smartphone(2, "LG", 1000, "LG Electronics Inc"), "LG Electronics Inc");
        assertTrue(isMatch);
    }

    @Test
    public void shouldNotFindSmartphoneManufacturer() {
        repository.findAll();

        boolean isMatch = manager.matches(new Smartphone(2, "LG", 1000, "LG Electronics Inc"), "LG Inc");
        assertFalse(isMatch);
    }

    @Test
    public void shouldReturnFindBook() {
        repository.findAll();

        manager.matches(first, "book1");

        manager.searchBy("book1");
        String nameToFind = "book1";

//        manager.matches(new Book(4, "book4", 100, "Ivanov"), "book4");
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(nameToFind);
        assertArrayEquals(expected, actual);
    }
}