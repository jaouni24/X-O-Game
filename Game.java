import java.util.*;

public class Game {
	final static int sizeOfTable = 3;
	final static int X = 3*88;
	final static int O = 3*79;
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		char [][]table = new char[sizeOfTable][sizeOfTable];
		
		System.out.println("Lets start with X-O game");
		System.out.println();
		
		makeEmpty(table);
		
		startTheGame(table);
	}
	
	public static void printTable(char [][]table) {
		System.out.println("*******");
		for(int i = 0; i < table.length ; i++) {
			for(int j = 0 ; j < table[i].length ; j++) {
				System.out.print("|"+table[i][j]);
			}
			System.out.print("|");
			System.out.println();
		}
		System.out.println("*******");
		System.out.println();
	}
	
	public static void startTheGame(char [][]table) {
		int counter = 0;
		int row = 0,column = 0;
		char X_O;
		boolean win = false;
		
		printTable(table);
		
		while(true) {
			
			if(isFull(counter) == true) {
				System.out.println("The table is Full!");
				break;
			}
			
			if(counter % 2 == 0)
				X_O = 'X';
			else
				X_O = 'O';
			
			System.out.println("Enter a row (0, 1, or 2) for player "+X_O+": ");
			row = enterNumber(row);
			System.out.println("Enter a column (0, 1, or 2) for player "+X_O+": ");
			column = enterNumber(column);
			
			
			while(!isVlidPosition(table,row,column)) {
				System.out.println("This position is occupied!");
				System.out.println("Please try again:");
				
				System.out.println("Enter a row (0, 1, or 2) for player "+X_O+": ");
				row = enterNumber(row);
				System.out.println("Enter a column (0, 1, or 2) for player "+X_O+": ");
				column = enterNumber(column);
			}
				
			counter++;
			
			table[row][column] = X_O;
			
			printTable(table);
				
			win = checkForLines(table);
			
			if(win){
				System.out.println(X_O+" player won");
				break;
			}
		}
	}
	
	public static boolean checkIfValid(int number) {
		if(number == 0 || number == 1 || number == 2)
			return true;
		else 
			return false;
	}
	
	public static int enterNumber(int number) {
		boolean isValid = true;
		
		number = input.nextInt();
		isValid = checkIfValid(number);
		
		while(!isValid){
			System.out.println(number+" is not valid!");
			System.out.println("Please try again: ");
			number = input.nextInt();
			isValid = checkIfValid(number);
		}
		
		return number;
	}
	
	public static boolean isFull(int counter) {
		return counter == 9;
	}
	
	public static boolean isVlidPosition(char [][]table,int r,int c) {
		if(table[r][c] == 'X' || table[r][c] == 'O')
			return false;
		return 
				true;
	}
	
	public static boolean checkForLines(char [][]table) {
		int sumDiagonal1 = 0;
		int sumDiagonal2 = 0;
		
		int sumRow0 = 0;
		int sumRow1 = 0;
		int sumRow2 = 0;
		
		int sumColumn0 = 0;
		int sumColumn1 = 0;
		int sumColumn2 = 0;
		
		int temp = 0;
		
		for(int i = 0; i < table.length ; i++) {
			sumRow0 += table[0][temp];
			sumRow1 += table[1][temp];
			sumRow2 += table[2][temp];
			
			sumColumn0 += table[i][0];
			sumColumn1 += table[i][1];
			sumColumn2 += table[i][2];
			
			for(int j = 0 ; j < table[i].length ; j++) {
				if(i == j) 
					sumDiagonal1 += table[i][j];
				
				if(i + j == 2)
					sumDiagonal2 += table[i][j];
			}
			
			temp++;
		}
		
		if(sumDiagonal1 == X || sumDiagonal1 == O || sumDiagonal2 == X || sumDiagonal2 == O)
			return true;
		else if(sumRow0 == X || sumRow0 == O || sumRow1 == O || sumRow1 == X || 
				sumRow2 == X || sumRow2 == O)
			return true;
		else if(sumColumn0 == X || sumColumn0 == O || sumColumn1 == X || sumColumn1 == O ||
				sumColumn2 == X || sumColumn2 == O)
			return true;
		else
			return false;
	}
	
	public static void makeEmpty(char [][]table) {
		for(int i = 0 ; i < table.length ; i++)
			for(int j = 0 ; j < table[i].length ; j++)
				table[i][j] = ' ';
	}
}
	
