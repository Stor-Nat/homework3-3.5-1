package ru.netology.manager;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    private ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    // добавляем продукты в репозиторий
    public void add(Product item) {
        repository.save(item);
    }

    public boolean matches(int product, String search) {
        if (product instanceof Book) {
            Book book = (Book) product;
            if (book.getName().equalsIgnoreCase(search)) {
                return true;
            }
            if (book.getAuthor().equalsIgnoreCase(search)) {
                return true;
            }
            return false;
        }

        if (product instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) product;
            if (smartphone.getName().equalsIgnoreCase(search)) {
                return true;
            }
            if (smartphone.getManufacturer().equalsIgnoreCase(search)) {
                return true;
            }
            return false;
        }
    }

    // возвращает массив найденных товаров
    public Product[] searchBy(String text) {
        Product[] resultFind = new Product[0];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                Product[] array = new Product[1];
                System.arraycopy(resultFind, 0, array, 0, 1);
                resultFind = array;
            }
        }
        return resultFind;
    }

}
