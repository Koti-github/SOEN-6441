import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class verify map's correctness. 
 * 
 * @author Dhruvi Gadhiya
 * @version 1.0.0
 * */
public class map {
	
	printtable o_printtable = new printtable();
	uem o_uem = new uem();
	
	/**
	 * This method checks if all the continents given in the map is connected or not.
	 * 
	 * @param country_list This parameter contains list of all countries.
	 * 
	 * @param continent_list This parameter contains list of all the continents.
	 * 
	 * @param country_continent This parameter contains hash map of country(key) and its continent(value).
	 * 
	 * @return This method returns value 1 if continents are connected or else 0.
	 * */
	public int validateConnectedContinents(File file) throws Exception {
		ArrayList<String> neighbour_country = new ArrayList<String>();
		ArrayList<String> continent_list = o_uem.continentlist(file);
		ArrayList<String> new_continent_list = continent_list;
		ArrayList<String> country_list = o_uem.countrylist(file);
		HashMap<String,String> country_continent = o_uem.getCountryContinent(file);
		
		int n = country_list.size();
		String continent = " ",continent1 = " ",country = " ";
		int flag = 0,a=0;
		
		for(int i=0;i<n;i++) {
			//System.out.println(new_continent_list);
			if(new_continent_list.isEmpty()) {
				//System.out.println("Continents are connected.");
				a=1;
				break;
			}
			country = country_list.get(i);
			if(flag == 0) {
				continent = country_continent.get(country);
				flag = 1;
			}
			neighbour_country = o_printtable.getNeighbour(country);
			for(int j=0;j<neighbour_country.size();j++) {
				continent1 = country_continent.get(neighbour_country.get(j));
				if(country_continent.get(country) != country_continent.get(neighbour_country.get(j))) {
					new_continent_list.remove(continent);
					continent = continent1;
				}
			}
			
		}
		return a;
	}
	
	
	/**
	 * This method checks if all the countries given in the map is connected or not.
	 * 
	 * @param country_list This parameter contains list of all countries.
	 * 
	 * @param continent_list This parameter contains list of all the continents.
	 * 
	 * @return This method returns value 1 if countries are connected or else 0.
	 * */
	public int validateConnectedCountries(File file) throws Exception {
		
		ArrayList<String> neighbour_country = new ArrayList<String>();		
		ArrayList<String> continent_list = o_uem.continentlist(file);
		ArrayList<String> country_list = o_uem.countrylist(file);
		ArrayList<String> new_country_list = country_list;

		
		int n = country_list.size();
		String country=" ",country1=" ";
		int flag=0,flag1=0,a=0;
		new_country_list = country_list;
		//System.out.println(country_list);

		for(int i=0;i<n;i++) {
			if(new_country_list.isEmpty()) {
				//System.out.println("Countries are connected.");
				a=1;
				break;
			}
			flag1=0;
			//System.out.println(new_country_list);
			if(flag == 0) {
				country = country_list.get(i);
				flag = 1;
			}else if(flag1==0){
				country = new_country_list.get(0);
				n++;
			}else {
				for(int k=0;k<n;k++) {
					if(country1.equals(country_list.get(k))) {
						country = country_list.get(k);
						break;
					}
				}
			}
			//System.out.println("Country : "+country);
			neighbour_country = o_printtable.getNeighbour(country);
			//System.out.println(neighbour_country);
			new_country_list.remove(country);
			n--;
			for(int j=0;j<neighbour_country.size();j++) {
				if(new_country_list.contains(neighbour_country.get(j))) {
					country1 = neighbour_country.get(j);
					//System.out.println("Country1 : "+country1);
					//System.out.println();
					flag1=1;
					break;
				}
			}
			if(flag1==0) {
				new_country_list.remove(country1);
				n++;
			}
		}
		return a;
	}
	
}
