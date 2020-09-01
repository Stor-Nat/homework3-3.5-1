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

@ExtendWith(MockitoExtension.class)
public class ProductManagerTest {
    @Mock
    private ProductRepository repository;
    @InjectMocks
    private ProductManager manager;
    private Product first = new Product(1, "book1", 100);
    private Product second = new Product (2, "LG", 10);
    private Product third = new Product(3,"third", 1);

//    @BeforeEach
//    public void setUp() {
//        manager.add(first);
//        manager.add(second);
//        manager.add(third);
//    }

    //preconditions. Могут быть вынесены из метода на уровень класса
    Book book = new Book(1, "book1", 50, "Author");
    Product productLG = new Product (2, "LG", 10);
    Product product3 = new Product(3,"third", 1);
    Product[] products = new Product[]{book, productLG, product3};


    @Test
    public void shouldFindBookName() {
        boolean isMatch = manager.matches(new Book(4, "book4", 100, "Ivanov"),"book4");
        assertTrue(isMatch);
    }

    @Test
    public void shouldNotFindBookName() {
        boolean isMatch = manager.matches(new Book(4, "book4", 100, "Ivanov"),"book5");
        assertFalse(isMatch);
    }

    @Test
    public void shouldFindBookAuthor() {
        boolean isMatch = manager.matches(new Book(4, "book4", 100, "Ivanov"),"Ivanov");
        assertTrue(isMatch);
    }

    @Test
    public void shouldNotFindBookAuthor() {
        boolean isMatch = manager.matches(new Book(4, "book4", 100, "Ivanov"),"Petrov");
        assertFalse(isMatch);
    }

    @Test
    public void shouldFindSmartphoneName() {
        boolean isMatch = manager.matches(new Smartphone(2, "LG", 1000, "LG Electronics Inc"), "LG");
        assertTrue(isMatch);
    }

    @Test
    public void shouldNotFindSmartphoneName() {
        boolean isMatch = manager.matches(new Smartphone(2, "LG", 1000, "LG Electronics Inc"), "Fly");
        assertFalse(isMatch);
    }

    @Test
    public void shouldFindSmartphoneManufacturer() {
        boolean isMatch = manager.matches(new Smartphone(2, "LG", 1000, "LG Electronics Inc"), "LG Electronics Inc");
        assertTrue(isMatch);
    }

    @Test
    public void shouldNotFindSmartphoneManufacturer() {
        boolean isMatch = manager.matches(new Smartphone(2, "LG", 1000, "LG Electronics Inc"), "LG Inc");
        assertFalse(isMatch);
    }

    @Test
    public void shouldReturnFindBook() {
        //Мокируем repository.findAll(), чтобы когда внутри метода manager.searchBy("book1") будет вызван
        //repository.findAll() он не выполнялся, а просто нам вернулся только что созданный массив products
        when(repository.findAll()).thenReturn(products);
        //Создаём ожидаемый результат
        Product[] expected = new Product[]{book};
        //вызываем тестовый метод
        Product[] actual = manager.searchBy("book1");
        //проверка
        assertArrayEquals(expected, actual);
    }
}