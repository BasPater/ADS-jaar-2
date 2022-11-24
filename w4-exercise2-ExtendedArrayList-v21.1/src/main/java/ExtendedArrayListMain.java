import models.ExtendedArrayList;
import models.Product;

import java.io.InputStream;
import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Function;

public class ExtendedArrayListMain {

    public static void main(String[] args) {
        System.out.println("Welcome to the HvA ExtendedArrayList processor");

        InputStream fileStream = ExtendedArrayListMain.class.getResourceAsStream("/products.txt");
        assert fileStream != null;
        Scanner scanner = new Scanner(fileStream);

        ExtendedArrayList<Product> products = new ExtendedArrayList<>();
        // load all products from the text file
        importFromScanner(scanner, products, Product::fromLine);

        System.out.printf("\nImported products:\n%s\n", products);

        // TODO show the first product that has a price above 2.00
        //  using ExtendedArrayList.getFirst
        System.out.printf("\nFirst product with a price above 2.00:\n%s\n",

                products.getFirst(Product::priceAbove2)
        );

        // TODO show the last product that has a price above 2.00
        //  using ExtendedArrayList.getLast
        System.out.printf("\nLast product with a price above 2.00:\n%s\n",

                products.getLast(Product::priceAbove2)
        );

        // TODO only keep the product in the list that have at least 10 items in stock
        //  using ExtendedArrayList.retainIf
        products.retainIf(Product::stockMoreThan10);

        System.out.printf("\nAll products with at least 10 items in stock:\n%s\n",products);


        // TODO sort the inventory by product title
        //  using Comparator.comparing

        products.sort(Product::compareTo);

        System.out.printf("\nAll products sorted by title:\n%s\n",products);

        // TODO remove duplicates from the list on the basis of equal product title
        //  using ExtendedArrayList.removeSuccessiveDuplicates and a lambda expression

        products.removeSuccessiveDuplicates(Product::areTheSame);

        System.out.printf("\nAll products with unique titles:\n%s\n", products);
    }

    public static <E> void importFromScanner(Scanner scanner, List<E> items,
                                            Function<String,E> converter) {
        while (scanner.hasNext()) {
            // input another line with author information
            String line = scanner.nextLine();





           items.add((E) Product.fromLine(line));

            // TODO convert the line to an instance of E

            // TODO add the item to the list of items

        }
    }
}
