import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ProductsImpl products = new ProductsImpl();
        Product p1 = new Product(5, "p1");
        Product p2 = new Product(1, "p2");
        Product p3 = new Product(125, "p3");
        Product p4 = new Product(0, "p4");
        Product p5 = new Product(3, "p5");
        Product p6 = new Product(3, "p6");
        Product p11 = new Product(11, "p11");
        Product p12 = new Product(12, "p11");
        Product p13 = new Product(13, "p11");

        products.addProduct(p1);
        products.addProduct(p2);
        products.addProduct(p3);
        products.addProduct(p4);
        products.addProduct(p5);

        System.out.println(products.addProduct(p6));
        System.out.println(products);
        System.out.println(products.deleteProduct(p6));
        System.out.println(products);
        System.out.println(products.deleteProduct(p2));
        System.out.println(products);

        System.out.println(products.getName(3));
        System.out.println(products.getName(10));

        products.addProduct(p11);
        products.addProduct(p12);
        products.addProduct(p13);
        ArrayList<Integer> arr = products.findByName("p311");
        System.out.println(arr);

    }
}