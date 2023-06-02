public class Product implements Comparable<Product>{
    private final int id;
    private final String name;

    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public int compareTo(Product product) {
        return Integer.compare(this.id, product.getId());
    }
}
