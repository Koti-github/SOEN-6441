import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
public class uem extends calcline{
        public void countrylist() throws Exception{
            String fileWord = "Territories";
            String searchword = " ";
            ArrayList<String> list = new ArrayList<String>();
            int i;
            File file = new File("C:\\Users\\dattebayo\\Desktop\\Board.map");
            Scanner sc = new Scanner(file);
            int j = 0;
            int n = line2();
            while (sc.hasNextLine()) {
                if (j == 1) {
                    break;
                }
                searchword = sc.next();
                if (searchword.equals("[Territories]")) {
                    for (i = 0; i < n-1; i++) {
                        String text = sc.next();
                        String[] input = text.split(",");
                        list.add(input[0]);
                    }
                    j = j + 1;
                    System.out.println(list);
                }
            }

        }
        public void continentlist() throws Exception{
            String searchcontinent = " ";
            ArrayList<String> continentlist = new ArrayList<String>();
            int i;
            File file = new File("C:\\Users\\dattebayo\\Desktop\\Board.map");
            Scanner sc = new Scanner(file);
            int j = 0;
            int n = line1();
            while (sc.hasNextLine()) {
                if (j == 1) {
                    break;
                }
                searchcontinent = sc.next();
                if (searchcontinent.equals("[Continents]")) {
                    for (i = 0; i <= n-2; i++) {
                        String text = sc.next();
                        String[] input = text.split("=");
                        continentlist.add(input[0]);
                    }
                    j = j + 1;
                    System.out.println(continentlist);
                }
            }
        }

    }


