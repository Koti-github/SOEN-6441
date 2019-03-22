import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * This class is to implement Dice functionality to decide who is the winner
 * 
 * @author charan
 * @since 1.0.0
 */
public class RGPdiceroll {
	static String RGPattacker;
	static String RGPdefender;
	static int RGPindexv;
	static int RGPattackerCount;
	static int RGPdefenderCount;
	static int noofdefenderdice1;
	private static Scanner RGPscanner;
	private static Scanner string;

	/**
	 * This method is to delete the minimum value from attacker dice values
	 * 
	 * @param dicevalue
	 *            This parameter dicevalue consists of dice values
	 * @param index
	 *            This parameter index gives at what minimum value should be
	 *            deleted
	 * @return This returns the dice values after deleting minimum value
	 */
	public static int[] deleteMinNum(int[] dicevalue, int index) {
		if (dicevalue == null || index < 0 || index >= dicevalue.length) {
			return dicevalue;
		}
		int[] anotherArray = new int[dicevalue.length - 1];
		for (int i = 0, k = 0; i < dicevalue.length; i++) {
			if (i == index) {
				continue;
			}
			anotherArray[k++] = dicevalue[i];
		}
		return anotherArray;
	}

	/**
	 * This method find outs the maximum value of dice values
	 * 
	 * @param dicevalues
	 *            consists of different dice values
	 * @return Returns the maximum value
	 */
	public static int maxOfArray(int[] dicevalues) {
		int max = dicevalues[0];

		for (int i = 1; i < dicevalues.length; i++) {
			if (dicevalues[i] > max) {
				max = dicevalues[i];
			}
		}
		return max;
	}

	/**
	 * This method find outs the minimum value of dice values
	 * 
	 * @param dicevalues
	 *            consists of different dice values
	 * @return Returns the minimum value
	 */
	public static int minOfArray(int[] dicevalues) {
		int min = dicevalues[0];

		for (int i = 1; i < dicevalues.length; i++) {
			if (dicevalues[i] < min) {
				min = dicevalues[i];
			}
		}
		return min;
	}

	/**
	 * This method provides the index for a minimum value in array
	 * 
	 * @param array
	 *            This parameter consists of dice values
	 * @return This returns the index of minimum value
	 */
	public static int minIndexValue(int[] array) {
		int indexv = array[0];
		int min = 0;

		for (int i = 1; i < array.length; i++) {
			if (array[i] < indexv) {
				indexv = array[i];
				min = i;
			}
		}
		return min;
	}

	/**
	 * This method provides the dice values for contestants
	 * 
	 * @param contestantdice
	 *            parameter defines either no of attacker dice or defender dice
	 * @return Returns either attacker or defender dice values
	 */
	static int[] rollOfDice(int contestantdice) {

		int att[] = new int[contestantdice];
		for (int i = 0; i < contestantdice; i++) {
			att[i] = diceNumgeneration();
		}
		return (att);

	}

	/**
	 * This method generates random dice value
	 * 
	 * @return return dice value
	 */
	static int diceNumgeneration() {
		final int numberOfSides = 6;
		int r;
		Random randomNumberGenerator = new Random();
		r = randomNumberGenerator.nextInt(numberOfSides) + 1;
		return r;
	}

	/**
	 * This method decided the winner of roll dice
	 * 
	 * @param attack_armies
	 *            no of attacker armies
	 * @param defend_armies
	 *            no of defender armies
	 * @param file
	 *            is file name
	 * @param p
	 *            is player index
	 * @param country_per_player
	 *            no of countries per player
	 * @param army_per_country
	 *            no of armies per country
	 * @param attack_country
	 *            is name of attacker country
	 * @param defend_country
	 *            is name of defender country
	 * @return returns hashmap with armies and winner
	 * @throws Exception
	 */
	public HashMap<String, Integer> rollDice(int attack_armies, int defend_armies, File file, int p,
			List<List<String>> country_per_player, HashMap<String, Integer> army_per_country, String attack_country,
			String defend_country) throws Exception {
		HashMap<Integer, Integer> armies = new HashMap<Integer, Integer>();
		RGPfortification o_fortification = new RGPfortification();
		int attacker_armies = attack_armies;
		int defender_armies = defend_armies;
		int noOfAttackerDice = 0;
		Scanner scan = new Scanner(System.in);
		int z = 1;
		String ans = null;
		if (attacker_armies >= 2) {
			System.out.println("Do you want go with 'all out mode'?(yes/no)");
			 ans = scan.next();
			if(ans.equalsIgnoreCase("yes")){
				while((attacker_armies != 0) && (defender_armies != 0)){
				int[] minattckerarmy = new int[2];
				minattckerarmy[0] = attacker_armies;
				minattckerarmy[1] = 3;
				int noofattackerdice = minOfArray(minattckerarmy);
				int noofdefenderdice = 2;
				//System.out.println("Enter no of dice you want to play with "+ "(maximum of" + (noofattackerdice-1)+")" );
				// noOfAttackerDice = string.nextInt();
				int a[] = rollOfDice(noofattackerdice);

				if (defender_armies < 2) {
					noofdefenderdice1 = noofdefenderdice - 1;

				} else {
					noofdefenderdice1 = noofdefenderdice;
				}

				int b[] = rollOfDice(noofdefenderdice1);

				int minvalue = minOfArray(a);
				System.out.println("Attacker Dice values");
				for (int i = 0; i < a.length; i++) {
					System.out.println(a[i]);
				}
				System.out.println("Min value in three dice");
				System.out.println(minvalue);

				int indexv = minIndexValue(a);
				System.out.println("index is" + indexv);
				if (attacker_armies > 2) {
					a = deleteMinNum(a, indexv);
				}
				System.out.println("Attacker Dice values after deleting min value");
				for (int i = 0; i < a.length; i++) {
					System.out.println(a[i]);
				}
				System.out.println("Defender Dice values");
				for (int i = 0; i < b.length; i++) {
					System.out.println(b[i]);
				}

				int max_dicevalue_attacker = maxOfArray(a);
				int max_dicevalue_defender = maxOfArray(b);
				int min_dicevalue_attacker = minOfArray(a);
				int min_dicevalue_defender = maxOfArray(b);
				if (max_dicevalue_attacker > max_dicevalue_defender
						&& min_dicevalue_attacker > min_dicevalue_defender) {
				
					RGPattackerCount++;
				} else if (max_dicevalue_attacker >= max_dicevalue_defender
						&& min_dicevalue_attacker > min_dicevalue_defender) {
					RGPattackerCount++;
				} else if (max_dicevalue_attacker > max_dicevalue_defender
						&& min_dicevalue_attacker >= min_dicevalue_defender) {
					RGPattackerCount++;
				} else if (max_dicevalue_attacker < max_dicevalue_defender
						&& min_dicevalue_attacker < min_dicevalue_defender) {
					RGPdefenderCount++;
				} else if (max_dicevalue_attacker <= max_dicevalue_defender
						&& min_dicevalue_attacker < min_dicevalue_defender) {
					RGPdefenderCount++;
				} else if (max_dicevalue_attacker < max_dicevalue_defender
						&& min_dicevalue_attacker <= min_dicevalue_defender) {
					RGPdefenderCount++;
				} else {
					RGPdefenderCount++;
				}
				if (RGPattackerCount > 0) {
					defender_armies = defender_armies - 1;
					System.out.println(" Defender Armies count value" + defender_armies);
					System.out.println("Attacker Armies count value" + attacker_armies);
					RGPattackerCount = 0;
				}
				if (RGPdefenderCount > 0) {
					attacker_armies = attacker_armies - 1;
					System.out.println("Attacker Armies count value" + attacker_armies);
					System.out.println(" Defender Armies count value" + defender_armies);
					RGPdefenderCount = 0;
				}
				}
				if (attacker_armies < 1) {
					army_per_country.put(attack_country, attacker_armies);
					army_per_country.put(defend_country, defender_armies);
				}
				if (defender_armies < 1) {
					army_per_country.put(attack_country, attacker_armies);
					army_per_country.put(defend_country, defender_armies);
				}
							

			}
			
		else if(ans.equalsIgnoreCase("no")){
			string = new Scanner(System.in);
			int[] minattckerarmy = new int[2];
			minattckerarmy[0] = attacker_armies;
			minattckerarmy[1] = 3;
			int noofattackerdice = minOfArray(minattckerarmy);
			int noofdefenderdice = 2;
			System.out.println("Enter no of dice you want to play with " + "(maximum of" + (noofattackerdice) + ")");
			noOfAttackerDice = string.nextInt();
			int a[] = rollOfDice(noOfAttackerDice);

			if (defender_armies < 2) {
				noofdefenderdice1 = noofdefenderdice - 1;

			} else {
				noofdefenderdice1 = noofdefenderdice;
			}

			int b[] = rollOfDice(noofdefenderdice1);

			int minvalue = minOfArray(a);
			System.out.println("Attacker Dice values");
			for (int i = 0; i < a.length; i++) {
				System.out.print(a[i]);
				System.out.println(" ");
			}

			System.out.println("Defender Dice values");
			for (int i = 0; i < b.length; i++) {
				System.out.print(b[i]);
				System.out.println(" ");
			}

			int max_dicevalue_attacker = maxOfArray(a);
			int max_dicevalue_defender = maxOfArray(b);
			int min_dicevalue_attacker = minOfArray(a);
			int min_dicevalue_defender = maxOfArray(b);
			if ((max_dicevalue_attacker >= max_dicevalue_defender) && (defender_armies > 0)) {

				defender_armies = defender_armies - 1;
				System.out.println("Attacker Dice Won");
				System.out.println("Attacker: " + attack_country + "(" + attacker_armies + ")");
				System.out.println(" Defender: " + defend_country + "(" + defender_armies + ")");

			}
			if (max_dicevalue_attacker <= max_dicevalue_defender && (defender_armies > 0)) {
				attacker_armies = attacker_armies - 1;
				System.out.println("Defender Dice Won");
				System.out.println("Attacker: " + attack_country + "(" + attacker_armies + ")");
				System.out.println(" Defender: " + defend_country + "(" + defender_armies + ")");

			}
			if (min_dicevalue_attacker <= min_dicevalue_defender && (defender_armies > 0)) {
				attacker_armies = attacker_armies - 1;
				System.out.println("Defender Dice Won");
				System.out.println("Attacker: " + attack_country + "(" + attacker_armies + ")");
				System.out.println(" Defender: " + defend_country + "(" + defender_armies + ")");

			}
			if ((min_dicevalue_attacker >= min_dicevalue_defender) && (defender_armies > 0)) {

				defender_armies = defender_armies - 1;
				System.out.println("Attacker Dice Won");
				System.out.println("Attacker: " + attack_country + "(" + attacker_armies + ")");
				System.out.println(" Defender: " + defend_country + "(" + defender_armies + ")");

			}

		}
		}
		army_per_country.put(attack_country, attacker_armies);
		army_per_country.put(defend_country, defender_armies);

		return army_per_country;
	}

}
