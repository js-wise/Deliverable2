import java.util.Scanner;

public class headOrTails {
	
	static String[] getGuess() {
		
		String[] sArray = {"something went wrong", "something went wrong"};
		boolean valid = false;
		Scanner scn = new Scanner(System.in); //init scanner
		
		while (valid != true) {/*loop determines if heads or tails is entered
		then returns either heads or tails as a string*/
			System.out.print("Guess which will have more: heads or tails? ");
			String s1 = scn.nextLine();
			if (s1.equals("heads")) {
				valid = true;
				sArray[0] = s1;
				sArray[1] = "tails";
			} else if (s1.equals("tails")) {
				valid = true;
				sArray[0] = s1;
				sArray[1] = "heads";
			} else {
				System.out.println("Error, guess must be: 'heads' or 'tails'");
			}
		}
		return sArray;
	}
	
	static int flipCount() {
		//get input for number of flips desired
		Scanner scn = new Scanner(System.in);
		boolean valid = false;
		int num = 0;
		
		while (valid != true) {
			System.out.print("How many times shall we flip a coin? ");
			int flips = scn.nextInt();
			if (flips > 0) {
				valid = true;
				num = flips;
			} else {
				System.out.println("Error: must flip at least 1 time");
			}
		}
		return num;
	}
	
	static int getFlips(int n, String[] s) {
		
		int i = 1;
		int numCorrect = 0;
		
		System.out.println();
		while(i <= n) {
			i++;
			int flip = (int) (Math.random() * 2);
			if (flip == 0) {
				System.out.println(s[0]);
				numCorrect++;
			} else {
				System.out.println(s[1]);
			}
		}
		return numCorrect;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] headsOrTailsGuess = getGuess();
		int numberOfFlips = flipCount();
		int correctCount = getFlips(numberOfFlips, headsOrTailsGuess);
		
		System.out.println("\r\nYour guess, " + headsOrTailsGuess[0] + ", came up " + correctCount + " time(s).");
		correctCount *= 100;
		correctCount /= numberOfFlips;
		System.out.println("That's " + correctCount + "%.");
	}

}
