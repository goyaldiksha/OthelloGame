package othello;

import java.util.Scanner;

public class OthelloManager {
	final static int player1Symbol = 1;
	final static int player2Symbol = 2;

	public static void main(String[] args) {
		OthelloBoard b = new OthelloBoard();
		Scanner s=new Scanner(System.in);
		System.out.println("Enter number of moves to be executed(Must be an even number and maximum possible steps are 64):");
		int n = s.nextInt();
		while(n%2!=0 || n>64) {
			System.out.println("Number of moves must be even number less than 64");
			System.out.println("Enter Again!!");
			n=s.nextInt();
		}
		boolean p1Turn = true;
		boolean status1=false;
		boolean status2=false;
	
		while(n > 0) {
			boolean ans = false;
			if(p1Turn) {
				System.out.println("Player 1 turn!!");
				System.out.println("Enter x cordinate :");
				int x = s.nextInt()-1;
				System.out.println("Enter y coordinate:");
				int y = s.nextInt()-1;
				ans = b.move(player1Symbol, x, y);
				status1=ans;
			}
			else {
				System.out.println("Player 2 turn!!");
				System.out.println("Enter x cordinate:");
				int x = s.nextInt()-1;
				System.out.println("Enter y coordinate:");
				int y = s.nextInt()-1;
				ans = b.move(player2Symbol, x, y);
				status2=ans;
			}
			if((!status1 && !status2) || n==0) {
				System.out.print("Game Over!!");
				break;
			}
			if(ans) {
				b.print();
				p1Turn = !p1Turn;
				n--;
			}
			else {
				System.out.println(ans);
				p1Turn = !p1Turn;
			}
		}
		
		b.result();
		
	}
}
