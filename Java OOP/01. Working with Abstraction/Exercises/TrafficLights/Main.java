package TrafficLights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner scanner = new Scanner(System.in); EXCEEDS TIME LIMIT
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TrafficLight[] trafficLights = Arrays.stream(reader.readLine().split("\\s+"))
                .map(l -> new TrafficLight(Lights.valueOf(l)))
                .toArray(TrafficLight[]::new);
//        String[] initialState = reader.readLine().split("\\s+");
//        ArrayList<TrafficLight> trafficLights = new ArrayList<>();
//        for (String state : initialState) {
//            TrafficLight trafficLight = new TrafficLight(Lights.valueOf(state));
//            trafficLights.add(trafficLight);
//        }
        int n = Integer.parseInt(reader.readLine());
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (TrafficLight trafficLight : trafficLights) {
                trafficLight.update();
                builder.append(trafficLight.toString() + " ");
            }
            builder.append("\n");
        }
        System.out.println(builder);
    }
}
