import java.util.Scanner;
public class mapoptions {
    public void mapo() {
        int i = 0;
        Scanner a = new Scanner(System.in);
        while (i == 0) {
            System.out.println("1- Create a new map");
            System.out.println("2- Use an existing map");
            System.out.println("3- Edit an existing map");
            int option = a.nextInt();
            switch (option) {
                case 1:
                    System.out.println("go to new map");
                    i = i + 1;
                    break;
                case 2:
                    System.out.println("go to existing map");
                    i = i + 1;
                    break;
                case 3:
                    System.out.println("go to edit map");
                    i = i + 1;
                    break;
                default:
                    System.out.println("Enter correct option");
            }
        }
    }
}
