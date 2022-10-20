package Тelephony;

import java.util.List;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder builder = new StringBuilder();
        for (String url : this.urls) {
            if (!containsDigit(url)) {
                builder.append("Browsing: ").append(url).append("!\n");
            } else {
                builder.append("Invalid URL!");
            }
        }
        return builder.toString();
    }

    @Override
    public String call() {
        StringBuilder builder = new StringBuilder();
        for (String number : this.numbers) {
            if (number.matches("[0-9]+") && number.length() > 0) {
                builder.append("Calling... ").append(number).append("\n");
            } else {
                builder.append("Invalid number!");
            }
        }
        return builder.toString();
    }

    private boolean containsDigit(String s) {
        boolean containsDigit = false;

        if (s != null && !s.isEmpty()) {
            for (char c : s.toCharArray()) {
                if (containsDigit = Character.isDigit(c)) {
                    break;
                }
            }
        }
        return containsDigit;
    }
}
