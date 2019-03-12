package othello;

public class OthelloBoard {
	private int board[][];
	final static int player1Symbol=1;
	final static int player2Symbol=2;
	
	private static int x_dir[]= {-1,-1,0,1,1,1,0,-1};
	private static int y_dir[]= {0,1,1,1,0,-1,-1,-1};
	
	//constructor set board
	public OthelloBoard() {
		board=new int[8][8];
		board[3][3]=player1Symbol;
		board[3][4]=player2Symbol;
		board[4][4]=player1Symbol;
		board[4][3]=player2Symbol;
		print();
	}
	
	//print board status
	public void print() {
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	
	//result
	public void result() {
		int count1=0;
		int count2=0;
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				if(board[i][j]==1) {
					count1++;
				}
				else if(board[i][j]==2) {
					count2++;
				}
			}
		}
		if(count1>count2) {
			System.out.println("Player 1 Won!!");
		}
		else if(count2>count1) {
			System.out.println("Player 2 Won!!");
		}
		else if(count1==count2) {
			System.out.println("It is Draw!!");
		}
	}
	
	//check for valid move
	
	public boolean move(int symbol, int x, int y) {
		if(x<0 || x>=8 || y<0 || y>=8 || board[x][y]!=0) {
			return false;
		}
		
		boolean moveSafe=false;
		for(int i=0;i<8;i++) {
			int x_step=x_dir[i];
			int y_step=y_dir[i];
			int curr_x=x+x_step;
			int curr_y=y+y_step;
			int count=0;//count other player pieces in path
			boolean conversion=false;
			while(curr_x>=0 && curr_x<8 && curr_y>=0 && curr_y<8) {
				//empty block
				if(board[curr_x][curr_y]==0) {
					conversion=false;
					break;
				}
				else if(board[curr_x][curr_y]==symbol) {
					conversion=true;
					break;
				}
				else if(board[curr_x][curr_y]!=symbol) {
					curr_x+=x_step;
					curr_y+=y_step;
					count++;
					if(board[curr_x][curr_y]==0) {
						conversion=true;
					}
				}
				
					//break;
			}
			//convert
			if(count>0 && conversion) {
				moveSafe=true;
				int convert_x=curr_x-x_step;
				int convert_y=curr_y-y_step;
				
				while(convert_x!=x || convert_y!=y) {
					board[convert_x][convert_y]=symbol;
					convert_x-=x_step;
					convert_y-=y_step;
				}
			}
		}
		if(moveSafe) {
			board[x][y]=symbol;
		}
		return moveSafe;
	}
	
}
