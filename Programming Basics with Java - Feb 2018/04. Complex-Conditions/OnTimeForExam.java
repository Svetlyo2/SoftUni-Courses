import java.util.Scanner;

public class OnTimeForExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer examH = Integer.parseInt(scanner.nextLine());
        Integer examM = Integer.parseInt(scanner.nextLine());
        Integer arrivalH = Integer.parseInt(scanner.nextLine());
        Integer arrivalM = Integer.parseInt(scanner.nextLine());
        Integer examTime = examH * 60 + examM;
        Integer arrTime = arrivalH * 60 + arrivalM;
        Integer difference = Math.max(examTime, arrTime) - Math.min(examTime, arrTime);
        Integer difHour = difference / 60;
        Integer difMin = Math.round(difference % 60);

        if (examTime - arrTime > 0) {

            if (difference >= 60) {
                System.out.println("Early");
                System.out.printf("%d:%02d hours before the start", difHour, difMin);
            } else if (difference < 60 && difference > 30) {
                System.out.println("Early");
                System.out.printf("%d minutes before the start", difference);
            } else if (difference < 60 && difference <= 30) {
                System.out.println("On time");
                System.out.printf("%d minutes before the start", difference);
            }
        } else if (examTime - arrTime < 0) {
            System.out.println("Late");
            if (difference >= 60) {
                System.out.printf("%d:%02d hours after the start", difHour, difMin);
            } else if (difference < 60) {
                System.out.printf("%d minutes after the start", difMin);
            }
        } else System.out.println("On time");
    }
}