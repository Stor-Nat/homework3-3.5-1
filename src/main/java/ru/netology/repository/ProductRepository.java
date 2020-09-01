package ru.netology.repository;

import ru.netology.domain.Product;
import ru.netology.manager.ProductManager;

public class ProductRepository {
    private Product[] items = new Product[0];

    //  добавляет продукт в массив
    public void save(Product item) {
        int length = items.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    // отобразить все продукты
    public Product[] findAll() {
        return items;
    }

    // поиск по id
    public Product findById(int id) {
        for (Product item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    // удаляем по id
    public void removeById(int id) {
        int length = items.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }
}
