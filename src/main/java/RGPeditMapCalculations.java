import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
/**
 * This map is for calculating edit map details and save the file
 * @author pavan
 * @version 1.0.0
 */
public class RGPeditMapCalculations {
	
	main o_main = new main();
	File file = new File("D:\\Projects\\Risk\\SOEN-6441\\src\\main\\java\\world.map");
	//File file = new File("E:/RiskGameGit/SOEN-6441/src/main/java/world.map");
	/**
	 * This method is to add continent to map file
	 * @throws Exception
	 */
    public void addContinent() throws Exception {
        BufferedReader br;
        System.out.println("Please enter the continent name to be added:");
        Scanner sc = new Scanner(System.in);
        String countryname = sc.nextLine();
        System.out.println("Please enter the value for the continent:");
        int value = sc.nextInt();
        String inputSearch = "[Continents]";
        br = new BufferedReader(new FileReader(file));
        PrintWriter outputStream = new PrintWriter(o_main.file);
        String words = br.readLine();
        while (words != null) {
            outputStream.println(words);
            if (words.equals(inputSearch)) {
                outputStream.println(countryname + "=" + value);
            }
            words = br.readLine();

        }
        outputStream.close();
        }
       /**
        * This method is to delete continent from map file
        * @throws Exception
        */
        public void deleteContinent() throws Exception{
            BufferedReader br;
            System.out.println("Please enter the continent name to be Deleted:");
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            String inputSearch = "[Continents]";
            br = new BufferedReader(new FileReader(file));
            PrintWriter outputStream = new PrintWriter(o_main.file);
            String words = br.readLine();
            while (words != null) {
                outputStream.println(words);
                if (words.equals(inputSearch)) {
                    br.readLine();
                }
                words = br.readLine();

            }
            outputStream.close();
        }
        /**
         * This method is to add country to map file
         * @throws Exception
         */
        public void addCountry() throws Exception{
            int i = 0;
            BufferedReader br;
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the country you want to be added:");
            String country = sc.nextLine();
            System.out.println("Enter the co-ordinates of the country:");
            int coord1 = sc.nextInt();
            int coord2 = sc.nextInt();
            System.out.println("Enter the continent in which the country is present:");
            String continent = sc.next();
            System.out.println("Enter the number of adjacent countries:");
            int ad1 = sc.nextInt();
            String[] adjacon = new String[ad1];
            for (i=0;i<ad1;i++){
            	System.out.println("Enter adjacent country name : ");
                adjacon[i] = sc.next();
            }
            br = new BufferedReader(new FileReader(file));
            PrintWriter outputStream = new PrintWriter(o_main.file);
            String words = br.readLine();
            while (words != null) {
                outputStream.println(words);
                words = br.readLine();

            }
            if (words == null){
            	System.out.println("Continent : "+continent+"Countries : "+adjacon);
            	String str = country + "," + coord1 + "," + coord2 + "," + continent + "," + Arrays.toString(adjacon).replace("[","").replace("]","");
                outputStream.println(str.replace(" ", ""));
            }
            outputStream.close();

        }
        /**
         * This method is to delete country from delete file
         * @throws Exception
         */
        public void deleteCountry() throws Exception{
            BufferedReader br;
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the country to be deleted:");
            String country = sc.nextLine();
            br = new BufferedReader(new FileReader(file));
            PrintWriter outputStream = new PrintWriter(o_main.file);
            String words = br.readLine();
            while (words != null) {
                outputStream.println(words);
                if (words.equals(country)) {
                    br.readLine();
                }
                words = br.readLine();

            }
            outputStream.close();
        }


    }
