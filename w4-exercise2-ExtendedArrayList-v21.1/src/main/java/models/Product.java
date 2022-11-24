package models;

import java.util.Locale;

public class Product implements Comparable<Product>{
    private String title;
    private double price;
    private int stock;

    public Product(String title, double price) {
        this.title = title;
        this.price = price;
        this.stock = 0;
    }
    public Product(String title, double price, int stock) {
        this(title, price);
        this.stock = stock;
    }

    /**
     * parses product information from a textLine
     * @param textLine
     * @return  a new Product instance with the provided information
     *          or null if the textLine is corrupt or incomplete
     */
    public static Product fromLine(String textLine) {
        Product newProduct;

        String [] lineString = textLine.split(", ", 6);

        newProduct = new Product(lineString[0],Double.parseDouble(lineString[1]), Integer.parseInt(lineString[2]));

        return newProduct;
    }

    public boolean priceAbove2() {
        return this.price > 2.0;
    }

    public boolean stockMoreThan10() {
        return this.stock <= 10;
    }

    public boolean areTheSame(Product o) {
        return this.title.equals(o.title);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {

        return String.format("%s/%.2f/%d", this.title, this.price, this.stock);
    }

    @Override
    public int compareTo(Product o) {
        int result = this.title.compareTo(o.title);

        return result;
    }
}
