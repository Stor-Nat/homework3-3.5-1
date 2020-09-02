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


    // возвращает массив найденных товаров
    public Product[] searchBy(String text) {
        Product[] resultFind = new Product[0];
        for (Product product : repository.findAll()) {
            if (product.matches(text)) {
                Product[] array = new Product[resultFind.length + 1];
                System.arraycopy(resultFind, 0, array, 0, resultFind.length);
                array[array.length - 1] = product;
                resultFind = array;
            }
        }
        return resultFind;
    }

}
