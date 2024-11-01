import java.util.Scanner;
import java.util.Random;

public class ProjectRPSV {
	
	//method to get the user's move
	public static int getMove() {
		Scanner input=new Scanner(System.in);
		System.out.println("Enter your move(Rock, Paper, Scissors, Lizard, Spock) ");
		String userMove=input.nextLine();
		//if the user input is invalid
		while(!validMove(userMove)){
			System.out.println("This isn't a valid movement.");
			System.out.print("Enter your move(Rock, Paper, Scissors, Lizard, Spock) ");
			userMove=input.nextLine();
		}
		//return value for their choice
		if(userMove.equalsIgnoreCase("rock"))
			return 0;
		else if(userMove.equalsIgnoreCase("paper"))
			return 1;
		else if(userMove.equalsIgnoreCase("scissors"))
			return 2;
		else if(userMove.equalsIgnoreCase("lizard"))
			return 3;
		else
			return 4;
		
	}
	//method for the normal rock paper scissors game
	//same as the method to get user's move
	public static int normalRPS() {
		Scanner input=new Scanner(System.in);
		System.out.print("\nEnter your move(Rock, Paper, Scissors) ");
		String userMove=input.nextLine();
		//if the user input is invalid
		while(!validMove(userMove)){
			System.out.println("This isn't a valid movement.");
			System.out.print("Enter your move(Rock, Paper, Scissors) ");
			userMove=input.nextLine();
		}
		//return value for their choice
		if(userMove.equalsIgnoreCase("rock"))
			return 0;
		else if(userMove.equalsIgnoreCase("paper"))
			return 1;
		else
			return 2;
	}
	//validation return true if not false
	public static boolean validMove(String userMove) {
		if (userMove.equalsIgnoreCase("rock"))
			return true;
		if (userMove.equalsIgnoreCase("paper"))
			return true;
		if (userMove.equalsIgnoreCase("scissors"))
			return true;
		if (userMove.equalsIgnoreCase("lizard"))
			return true;
		if (userMove.equalsIgnoreCase("spock"))
			return true;
		return false;
	}
	//computer's rpsls picker
	public static int compMove() {
		Random rng=new Random();
		return rng.nextInt(5);
	}
	//computer's rps picker
	public static int normalRPSbot() {
		Random rng=new Random();
		return rng.nextInt(3);
	}
	//game outcome based on what beats what based on RPSLS picture
	public static int gameOutcome(int pM, int cM) {
		//draw = 2, comp win = 1, player win = 0
		if(pM==cM)
			return 2;
		//if player is rock lose to paper or spock
		else if(pM==0 && (cM==1||cM==4))
			return 1;
		//if player is rock wins scissors or lizard
		else if(pM==0 && (cM==2||cM==3))
			return 0;
		//if player is paper lose to scissors or lizard
		else if(pM==1 && (cM==2||cM==3))
			return 1;
		//if player is paper wins to rock and spock
		else if(pM==1 && (cM==0||cM==4))
			return 0;
		//if player is scissors lose to rock or spock
		else if(pM==2 && (cM==0||cM==4))
			return 1;
		//if player is scissors win to paper or lizard
		else if(pM==2 && (cM==1||cM==3))
			return 0;
		//if player is lizard loses to scissors or rock
		else if(pM==3 && (cM==2||cM==0))
			return 1;
		//if player is lizard win to spock or paper
		else if(pM==3 && (cM==4||cM==1))
			return 0;
		//if player is spock loses to lizard or paper
		else if(pM==4 && (cM==3||cM==1))
			return 1;
		//if player is spock wins to scissors or rock
		else if(pM==4 && (cM==2||cM==0))
			return 0;
		else
			return 0;
		
		
	}
	//method for RPSLS game
	public static int theGame() {
		//method for user input
		int pM=getMove();
		//method for bot's random input
		int cM=compMove();
		//method to get results
		int result=gameOutcome(pM, cM);
		//return result
		return result;
	}
	//method for bots' RPSLS game
	public static int botGame() {
		//method for bot random input twice
		//first bot would count as player for convenience
		int pM=compMove();
		int cM=compMove();
		//method to get results
		int result=gameOutcome(pM, cM);
		//return result
		return result;
	}
	//method for normal RPS game if user won the first round
	public static int normalGame() {
		//method for user input but for normal RPS
		int pM=normalRPS();
		//method for normal RPS bot
		int cM=normalRPSbot();
		int normalResult=gameOutcome(pM, cM);
		//return normal game result
		return normalResult;
	}
	//method for bot normal RPS game if user is eliminated first round
	public static int normalBotGame() {
		//bot random choice from RPS
		int pM=normalRPSbot();
		int cM=normalRPSbot();
		//method to get results
		int botResult=gameOutcome(pM, cM);
		//return bot game result
		return botResult;
	}
	//method to produce menu
	public static void myMenu() {
		Scanner input=new Scanner(System.in);
		//declare variables for wins for menu select 3
		int userWins=0,firstCompWins=0,secondCompWins=0;
		//declare option select to be 0
		int optionSelect=0;
		//menu stays as long as user doesn't quit
		while(optionSelect!=4) {
			System.out.println("\nMenu | Choose an option with corresponding number.");
			System.out.println("1. See the rules of the game");
			System.out.println("2. Play against the computer players.");
			System.out.println("3. Show current wins for each player.");
			System.out.println("4. Quit.");
			optionSelect = input.nextInt();
			//rules
			if(optionSelect==1) {
				System.out.println("The double-fisting variation of the RPS game is an interesting one on one multiple-match mode. The players are arranged in a circle. Each player will play against the players on his right and on his \nleft with the use of both hands. Any player who loses to the throws on both sides is eliminated from the circle of play. "
						+ "This continues until only two players are left. "+ "Then a regular RPS match(es) will be\nplayed by the surviving two players to declare who is victorious and who loses. A Double Fisting RPS match usually requires a referee who will monitor the game and prevent any form of cheating. "
							+"\nThis is because it has been discovered to be very easy for a player to falsify his throws or leverage the carelessness or split the attention of another player.\r\n"
						+ "\r\n" + "Your game is going to have 3 players. One is going to be the program user and the other 2 has to be simulated by as automatic players with random moves. Even in the event that the player loses in the first part, \nyou should allow the 2 computer simulated players to play the final round.");
			//if user selects to play the computer
			}else if(optionSelect==2) {
					System.out.println("You have chosen to play against the computer.");
					//letting the user know it'll keep asking until one of the three loses both games
					System.out.println("Until someone loses both games, we will keep asking you to throw your choice out.");
					//declare variables to do elimination
					boolean elimination=false, userFirstWin=false, firstCompWin=false, secondCompWin=true, userSecondWin=true;
					//bot elimination
					boolean againstSecondComputer=true;
					//elimination to determine who plays second round
					boolean userElim=false, firstElim=false, secondElim = false;
					//while no one is eliminated
					while(!elimination) {
						//get the result of the three games
						int firstGameResult = theGame();
						int secondGameResult = theGame();
						int botGameResult = botGame();
						//determine who gets eliminated
						//user wins, first bot lose
						if(firstGameResult==0) {
							userFirstWin = true;
							firstCompWin = false;
						}
						//user loses, first bot wins
						else if(firstGameResult==1) {
							userFirstWin = false;
							firstCompWin = true;
						}
						//user wins, second bot lose
						if(secondGameResult==0) {
							userSecondWin = true;
							secondCompWin = false;
						}
						//user loses, second bot wins
						else if(secondGameResult==1) {
							userSecondWin = false;
							secondCompWin = true;
						}
						//first bot wins second bot loses
						if (botGameResult==0) {
							againstSecondComputer = true;
						//second bot wins, first bot loses
						}else {
							againstSecondComputer = false;
						}
						//lets the user know they lost both games
						if(userFirstWin == false && userSecondWin == false) {
							elimination = true;
							System.out.println("You have lost both games and have been eliminated.");
							userElim = true;
						}
						//lets the user know the first bot lost both games
						if(firstCompWin == false && againstSecondComputer == false) {
							elimination=true;
							System.out.println("The first computer has lost both games and has been eliminated.");
							firstElim = true;
						}
						//lets the user know the second bot lost both games
						if(secondCompWin==false&&againstSecondComputer==true) {
							elimination=true;
							System.out.println("The second computer has lost both games and has been eliminated");
							secondElim = true;
						}
						}
					//second round normal rps
					//if user lost first round
					if(userElim==true) {
						//get reuslt from the normal bot game method
						int normalBotResult =normalBotGame();
						//if result = 1 second bot wins due to first bot counting as player one
						if(normalBotResult==1) {
							System.out.println("Second bot has won the game!");
							secondCompWins++;
						}
						//if result = 0 first bot wins due to first bot counting as player one
						else if(normalBotResult==0) {
							System.out.println("First bot has won the game!");
							firstCompWins++;
						}
						//if result = 2 or else it becomes a draw
						else
							System.out.println("\nIt's a draw between the bots!");
					}
					//if user didnt get eliminated and first bot didnt
					if(userElim==false && firstElim==false) {
						//user does the RPS game but with three options
						int normalPlayerResult = normalGame();
						//user loses
						if(normalPlayerResult==1) {
							System.out.println("The First Bot has won the game!");
							firstCompWins++;
						}
						//user wins
						else if(normalPlayerResult==0) {
							System.out.println("The player has won the game!");
							userWins++;
						}
						//user got 2 as a result
						else
							System.out.println("It's a draw!");
					}
					//if user and second bot didnt get eliminated
					if(userElim==false && secondElim==false) {
						int normalPlayerResult = normalGame();
						//user loses
						if(normalPlayerResult==1) {
							System.out.println("The Second Bot has won the game!");
							secondCompWins++;
						}
						//user wins
						else if(normalPlayerResult==0) {
							System.out.println("The player has won the game!");
							userWins++;
						}
						//user got 2 as a result
						else
							System.out.println("It's a draw!");
					}
					
					
					
				}else if(optionSelect==3){
					//prints round 2 wins not round 1
					System.out.println("\nUser has won "+ userWins+" games.");
					System.out.println("First computer has won "+firstCompWins+" games.");
					System.out.println("Second computer has won "+secondCompWins+" games.");
				}
		}
		
	}

	public static void main(String[] args) {
		//calls myMenu 
		myMenu();

	}

}
