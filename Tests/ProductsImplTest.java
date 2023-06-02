import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ProductsImplTest {
    static ProductsImpl products;

    @BeforeEach
    void createList() {
        products = new ProductsImpl();
        products.addProduct(new Product(1, "Молоко"));
        products.addProduct(new Product(2, "Чай"));
        products.addProduct(new Product(3, "Кофе"));
        products.addProduct(new Product(4, "Молоко"));
    }

    @Test
    void addProductPositive() {
        assertTrue(products.addProduct(new Product(16, "Молоко")));
        assertTrue(products.addProduct(new Product(100, "Хлеб")));
        assertTrue(products.addProduct(new Product(15, "Печеньки")));
    }

    @Test
    void addProductNegative() {
        assertFalse(products.addProduct(new Product(1, "Молоко")));
        assertFalse(products.addProduct(new Product(1, "Хлеб")));
        assertFalse(products.addProduct(new Product(10, "")));
        assertFalse(products.addProduct(new Product(-1, "Вафли")));
    }

    @Test
    void deleteProductPositive() {
        assertTrue(products.deleteProduct(new Product(1, "Молоко")));
        assertTrue(products.deleteProduct(new Product(3, "Кофе")));
    }

    @Test
    void deleteProductNegative() {
        assertFalse(products.deleteProduct(new Product(1, "Кофе")));
        assertFalse(products.deleteProduct(new Product(5, "Молоко")));
    }

    @Test
    void getNamePositive() {
        assertEquals("Молоко", products.getName(1));
        assertEquals("Кофе", products.getName(3));
    }

    @Test
    void getNameNegative() {
        assertEquals("", products.getName(10));
        assertEquals("", products.getName(-1));
    }

    @Test
    void findByNamePositive() {
        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();
        l1.add(1);
        l1.add(4);
        l2.add(3);
        assertEquals(l1, products.findByName("Молоко"));
        assertEquals(l2, products.findByName("Кофе"));
    }

    @Test
    void findByNameNegative() {
        assertEquals(new ArrayList<>(), products.findByName("Шоколад"));
    }

}