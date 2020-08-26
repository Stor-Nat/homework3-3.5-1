package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book coreJava = new Book();
    private Smartphone phone = new Smartphone();

    @Test
    public void shouldSaveOneItem() {
        repository.save(coreJava);
        Product[] expected = new Product[]{coreJava};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }


    // должен сохранить 1 предмет book
    @Test
    public void shouldSaveOneItemBook() {
        repository.save(coreJava);

        Product[] expected = new Product[]{coreJava};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    // должен сохранить 1 предмет Smartphone
    @Test
    public void shouldSaveOneItemSmartphone() {
        repository.save(phone);

        Product[] expected = new Product[]{phone};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

}
