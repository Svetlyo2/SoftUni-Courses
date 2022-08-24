import java.text.DecimalFormat;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] robotsData= scanner.nextLine().split(";");
        int robotsNumber=robotsData.length;
        int [] timeData= Arrays.stream(scanner.nextLine().split(":"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int startTime=timeData[0]*3600+timeData[1]*60+timeData[2];
        String [] robots =new String[robotsNumber];
        int [] workingTime=new int[robotsNumber];
        int [] processTime=new int[robotsNumber];

        for (int i = 0; i < robotsData.length; i++) {
            String [] current=robotsData[i].split("-");
            //robots[i]=robotsData[i].split("-")[0];
            robots[i]=current[0];
            workingTime[i]=Integer.parseInt(current[1]);
        }
        int time=0;
        Deque<String> products = new ArrayDeque<>();
        String currentProduct = scanner.nextLine();
        while (!currentProduct.equals("End")){
            products.offer(currentProduct);
            currentProduct= scanner.nextLine();
        }
        while (!products.isEmpty()){
            time++;
            String product = products.poll();
            boolean isAssigned=false;
            for (int i = 0; i < robotsNumber; i++) {
                if (processTime[i]==0 && !isAssigned){
                    processTime[i]=workingTime[i];
                    printTask( robots[i], startTime+time, product);
                    isAssigned=true;
                }
                if (processTime[i]>0){
                    processTime[i]--;
                }
            }
            if (!isAssigned) {
                products.offer(product);
            }
        }
    }
    private static void printTask (String robot, int time, String product){
        int hours=(time/3600)%24;
        int minutes=time%3600/60;
        int seconds=time%60;
        DecimalFormat format =new DecimalFormat("00");

        System.out.println(String.format("%s - %s [%s:%s:%s]", robot, product,
                format.format(hours), format.format(minutes), format.format(seconds)));
    }
//    public static String convertSecondsToHHMMSS(int seconds){
//
//        int s = seconds % 60;
//        int m = (seconds/ 60) % 60;
//        int h = (seconds / (60 * 60)) % 24;
//
//        return String.format("%02d:%02d:%02d",h,m,s);
//    }
}
