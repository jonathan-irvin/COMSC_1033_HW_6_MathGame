/** @author Michael Dobrinski - michael.git2015@gmail.com
 * COMSC 1033 Section 1411
 * Instructor: Dr. Evert
 * 27 September 2015
 */

/** Homework number 6
 *
 * Let us make a math game. The user will be asked a simple math problem in
 * the first round. For example, to add two single digit numbers. If the user
 * gets this correct, they will be given points and asked a more difficult
 * math problem in round 2, such as adding a pair of two digit numbers.
 * They will receive more points and be asked more difficult questions in the
 * following round for every correct answer. Every incorrect answer will be
 * followed by a more simple question. There should be a total of 4 rounds.
 * At the end of 4 rounds, the code should print the final score.
 */

import java.util.Scanner;

public class COMSC_1033_HW_6_Math_Game {
	public static int score=0;
	public static int level=1, numCorrect=0, numIncorrect=0;
	public static Scanner inputAnswer = new Scanner(System.in);
	public static Player player_1 = new Player();
	public static void main(String[] args) {
		int num1 = 0, num2 = 0;

		Scanner input = new Scanner(System.in);
		System.out.print("\nPlease enter your first name: ");
		String playerName = input.nextLine();
		player_1.setName(playerName);

		System.out.print("\n\n************************************************" +
		"*************************************\n");
		System.out.printf("Welcome %s! The rules for the game are:\n",
				player_1.getName());
		System.out.printf("The game consists of four rounds of addition problems"+
		" randomly generated. Each time the \nproblem is answered correctly"+
		" you will receive 5 points and the difficulty level\nwill increase. "+
		"If the problem is answered incorrectly you will lose 5 points and "+
		"the\ndifficulty level will be reduced.");

		for(int round=1; round<=4; round++){
			// Make sure level does not go below 1.
			player_1.setLevel( (player_1.getLevel()<1)? 1: player_1.getLevel());

			switch (player_1.getLevel()){
				case 1:
					num1 =  randomNumber(0, 9);
					num2 =  randomNumber(0, 9);
					roundResult(num1, num2, round);
					break;

				case 2:
					num1 =  randomNumber(10, 99);
					num2 =  randomNumber(10, 99);
					roundResult(num1, num2, round);
					break;

				case 3:
					num1 =  randomNumber(100, 999);
					num2 =  randomNumber(100, 999);
					roundResult(num1, num2, round);
					break;

				case 4:
					num1 =  randomNumber(1000, 9999);
					num2 =  randomNumber(1000, 9999);
					roundResult(num1, num2, round);
					break;
				default:

			}	// End of switch.
		} // End of for loop.

		System.out.printf("\n\n***************************************************"
				+ "****************\n************************** Final Results ********"
				+ "******************\n");
		System.out.printf("%s your final score is %d points and you answered %4.1f"
			+ "%% of\nthe questions correctly.", player_1.getName(), score,
			(double)numCorrect /(numCorrect+numIncorrect)*100.0);

		input.close();
		inputAnswer.close();
	} // ************** End of MAIN method ****************************

/**
 * Method to calculate the result of the round of addition.
 * Inputs: the two numbers for the problem, the player name, and round number
 * Output: The method does not return a value but modifies the global variables
 * score and level.
 */

	private static void roundResult(int num1, int num2,	int round) {
		int playerAnswer;
		int correctAnswer;
		printRoundHeader(score, round, level);
		correctAnswer = num1 + num2;
		System.out.printf("Answer the problem: %d + %d = ", num1, num2);
		playerAnswer = inputAnswer.nextInt(); // Moved this from its own method.
		if (playerAnswer == correctAnswer){
			score += 5;
			level += 1;
			numCorrect++;
			System.out.print("CORRECT");
		}
		else{
			score -= 5;
			level -= 1;
			numIncorrect++;
			System.out.print("INCORRECT");
		}
	} // End of roundResult

	/**
	 * Generate a random number between mn (minimum) and mx (maximum) inclusive.
	 * Inputs: int minimum boundary, int maximum boundary
	 * Output: random integer between mn and mx inclusive.
	 */
	public static int randomNumber(int mn, int mx){
		int result=0;

		result = ((mx - mn + 1) * (int)(Math.random()*100000)) / 100000 + mn;
		return result;
	}	// End of randomNumber.

	/**
	 * Method to print header information at the start of each round.
	 * Inputs: int score, int round, int level, string player's name
	 * Output: void
	 */
	public static void printRoundHeader(int s, int r, int lvl){
		System.out.printf("\n\n***************************************************"
			+ "****************\n***************************** Round %d *************"
			+ "****************\n",r);
		System.out.printf("\n%s your score is %d and you are at a dificulty"
			+ " level of %d.\n", player_1.getName(), s, lvl);
	} // End of printRoundHeader.


} // **************** End of COMSC_1033_HW_6_Math_Game class ********
