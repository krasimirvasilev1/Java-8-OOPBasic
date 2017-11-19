package ThirdExersiceInheritance.BookShop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        try {
            String author = console.readLine();
            String title = console.readLine();
            double price = Double.parseDouble(console.readLine());

            Book book = new Book(author, title, price);
            GoldenEditionBook goldenBook = new GoldenEditionBook(author, title, price);

            System.out.println(book.toString());
            System.out.println(goldenBook.toString());
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }
}
