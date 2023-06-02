import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class ProductsImpl {
    // Список всех продуктов - сортировка по id
    TreeSet<Product> products;

    public ProductsImpl() {
        this.products = new TreeSet<>();
    }

    // Добавление нового продукта
    // Метод гарантирует уникальность id в общем списке products
    public boolean addProduct(Product product) {
        if (getProductById(product.getId()) != null || product.getName().equals("") || product.getId()<0)
            return false;
        return products.add(product);
    }

    // Удаление продукта по id
    // Метод гарантирует безопаснотсь удаления (дополнительная проверка name)
    public boolean deleteProduct(Product product) {
        if (getProductById(product.getId()) == null)
            return false;
        if (!getProductById(product.getId()).getName().equals(product.getName()))
            return false;
        return products.remove(product);
    }

    // Получение name по id продукта
    public String getName(int id) {
        Product product = getProductById(id);
        if (product != null)
            return product.getName();
        return "";
    }

    // Получение списка id по полю name
    public ArrayList<Integer> findByName(String name) {
        ArrayList<Integer> result = new ArrayList<>();
        for (Product product: products) {
            if (product.getName().equals(name))
                result.add(product.getId());
        }
        return result;
    }

    // Вспомогательный метод для поиска объектов Product по заданному id
    private Product getProductById(int id) {
        for (Product product: products) {
            if (product.getId() == id)
                return product;
        }
        return null;
    }

    // Вспомогательный метод для строкового представления объекта данного класса
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Product product: products) {
            s.append("id: ").append(product.getId()).append(", name: ").append(product.getName()).append('\n');
        }
        return s.toString();
    }
}
