import java.util.*;

class Play_3Dttt
{
	public static void tic_tac_toe_3D (int[][][] currentBoard, node[][] winningPositions, char starter)
	{
		Scanner inScan = new Scanner(System.in);

		if (starter=='X')
		{
			System.out.print("Please input your first step (format: 'x y z'): ");
			int x = inScan.nextInt();
			int y = inScan.nextInt();
			int z = inScan.nextInt();
			currentBoard[x][y][z] = 1;
		}//end if

		//rest of rounds
		while (!Tic_Tac_Toe.isFull(currentBoard))
		{
			Tic_Tac_Toe.singleStep(currentBoard, winningPositions);
			Tic_Tac_Toe.printBoard(currentBoard);
			System.out.print("Please input your next step (format: 'x y z'): ");
			int x = inScan.nextInt();
			int y = inScan.nextInt();
			int z = inScan.nextInt();
			currentBoard[x][y][z] = 1;
		}//end while

		//if tie
		if (Tic_Tac_Toe.isFull(currentBoard))
			System.out.println("Tie! (Board is full)");
	}//end tic-tac-toe_3D

	public static void main(String[] args) throws Exception
	{
		//initialization
		Scanner inScan = new Scanner(System.in);
			//int[][][] currentBoard
			int[][][] currentBoard = new int[5][5][5];
			//node[][] winningPositions
			System.out.println("Please input the file name of Winning Positions:");
			String fileName = inScan.next();
			int[][] winPosition = TableIO.matrix(fileName);
			node[][] winningPositions = new node[77][5];
			Tic_Tac_Toe.initializeWinningPositions(winningPositions,winPosition);
			//char starter
			System.out.print("Please input the start player ('X' for user, 'O' for program): ");
			char starter = inScan.next().charAt(0);
		
		//playing
		tic_tac_toe_3D(currentBoard,winningPositions,starter);
	}//end main
}//end class Play_3Dttt