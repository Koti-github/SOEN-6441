import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class main {
	
	static int total_players;
    
	public static void main(String[] args) throws Exception{
        
		menu();
        
        army o_army = new army();
        uem object_uem = new uem();
        int total_country = object_uem.countrylist().size();
        ArrayList<String> country_name = object_uem.countrylist();
		System.out.println(country_name);
		System.out.println(total_players);
		
        int armies_per_player = o_army.totalArmy(total_players,total_country);
        System.out.println("Total No. of countries : "+total_country);
		System.out.println("Per Player armies : "+armies_per_player);
		
		List<List<String>> country_per_player = new ArrayList<List<String>>();
		country_per_player = o_army.divideCountry(total_players,country_name);
		System.out.println("\nList of country per player");
		System.out.println(country_per_player);
		
		HashMap<String,Integer> army_per_country = new HashMap<String,Integer>();
		army_per_country = o_army.armyPerCountry(total_players,armies_per_player,country_per_player);
		System.out.println("No. of armies per country");
		System.out.println(army_per_country);
		
        /*
        mainmethod object_mainmethod = new mainmethod();
        object_mainmethod.generateArmy();
                
        printtable object_printtable = new printtable();
        //int player_count = object_mainmethod.n;
        //System.out.println(player_count);
        int n=5;
        for(int i=0;i<n;i++) {
        	object_printtable.getTable(i);
        }*/
    }
    
	public static void menu(){
        int i = 0;
        Scanner a = new Scanner(System.in);
        System.out.println("******WELCOME TO RISK******");
        while(i == 0) {
            System.out.println("1- Start");
            System.out.println("2- Help");
            System.out.println("3- Exit");
            System.out.println("Enter your option");
            int option = a.nextInt();
            switch (option) {
                case 1:
                	mapo();
                    i = i + 1;
                    break;
                case 2:
                    System.out.println("Help");
                    i = i + 1;
                    break;
                case 3:
                    System.out.println("Exit");
                    i = i + 1;
                    break;
                default:
                    while (option > 3) {
                        System.out.println("hello");
                        break;
                    }

            }
        }

    }
    
	public static void mapo() {
        int i = 0;
        namingplayers o_namingplayers = new namingplayers();
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
                    o_namingplayers.namep();
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
        total_players = o_namingplayers.pinp;
        for(i=0;i<total_players;i++) {
        	System.out.println(o_namingplayers.names[i]);
        }
    }
	
}
