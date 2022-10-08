package BookShop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String authorName = bufferedReader.readLine();
        String bookTitle = bufferedReader.readLine();
        double bookPrice = Double.parseDouble(bufferedReader.readLine());

        GoldenEditionBook book = new GoldenEditionBook(authorName, bookTitle, bookPrice);
        System.out.println(book);
    }
}
