import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, LinkedHashMap<String, List<String>>> continentData = new LinkedHashMap<>();
        int rowCount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < rowCount; i++) {
            String[] parts = scanner.nextLine().split(" ");
            String continent = parts[0];
            String country = parts[1];
            String city = parts[2];

            LinkedHashMap<String, List<String>> countriesData;
            if (continentData.containsKey(continent)) {
                countriesData = continentData.get(continent);

                List<String> cities;
                if (countriesData.containsKey(country)) {
                    cities = countriesData.get(country);
                } else {
                    cities = new ArrayList<>();
                }
                cities.add(city);
                countriesData.put(country, cities);
            } else {
                countriesData = new LinkedHashMap<>();
                List<String> cities = new ArrayList<>();
                cities.add(city);
                countriesData.put(country, cities);
            }
            continentData.put(continent, countriesData);
        }

        for (String continentName : continentData.keySet()) {
            System.out.println(continentName + ":");
            LinkedHashMap<String, List<String>> countriesData = continentData.get(continentName);
            for (String countryName : countriesData.keySet()) {
                System.out.print(countryName + " -> ");
                String countriesNames = String.join(", ", countriesData.get(countryName));
                System.out.println(countriesNames);
            }
        }
    }
}
