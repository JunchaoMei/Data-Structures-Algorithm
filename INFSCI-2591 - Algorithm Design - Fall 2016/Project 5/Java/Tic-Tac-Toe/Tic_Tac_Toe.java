import java.util.*;

class Tic_Tac_Toe
{
	//print the current board
	public static void printBoard (int[][][] currentBoard)
	{
		System.out.println("\n[Current Board]");

		for (int z=1; z<=4; z++)
		{
			System.out.println("Floor " + z + ": ");
			for (int x=1; x<=4; x++)
			{
				for (int y=1; y<=4; y++)
					System.out.print(currentBoard[x][y][z] + "	");
				System.out.println();
			}//end for loop x
		}//end for loop z
		System.out.println();
	}//end printBoard

	//initialize node[][] winningPositions
	public static void initializeWinningPositions (node[][] winningPositions, int[][] winPosition)
	{
		//not null
		for (int w=0; w<winningPositions.length; w++)
		{
			for (int v=0; v<winningPositions[w].length; v++)
			{
				winningPositions[w][v] = new node(-1,-1,-1);
			}//end for loop v
		}//end for loop w

		//give values
		for (int i=1; i<=76; i++)
		{
			for (int j=1; j<=12; j++)
			{
				int a = (j+2)/3;
				int b = (j+2)%3 + 1;

				switch (b)
				{
					case 1:
						winningPositions[i][a].x = winPosition[i][j];
						break;
					case 2:
						winningPositions[i][a].y = winPosition[i][j];
						break;
					case 3:
						winningPositions[i][a].z = winPosition[i][j];
						break;
					default:
						System.out.println("Error!");
						break;
				}//end switch
			}//end for loop j
		}//end for loop i
	}//end initializeWinningPositions

	//print node[][] winningPositions
	public static void printWinningPositions (node[][] winningPositions)
	{
		for (int w=1; w<=76; w++)
		{
			for (int v=1; v<=4; v++)
				System.out.print(winningPositions[w][v].x + "," + winningPositions[w][v].y + "," + winningPositions[w][v].z + "	");
			System.out.println();
		}//end for loop w
	}//end printWinningPositions

	//print node[] winningPositions
	public static void printWinningPosition (node[][] winningPositions, int win)
	{
		System.out.print("longest strand ["+win+"]:  ");
		for (int v=1; v<=4; v++)
			System.out.print("("+winningPositions[win][v].x + "," + winningPositions[win][v].y + "," + winningPositions[win][v].z + ") ");
		System.out.println();
	}//end printWinningPositions

	//whether the current board contains the node currentNode for player
	public static boolean containNode (int[][][] currentBoard, node currentNode, char player)
	{
		if (player=='X')
		{
			if (currentBoard[currentNode.x][currentNode.y][currentNode.z] == 1)
				return true;
			return false;
		} else if (player=='O')
		{
			if (currentBoard[currentNode.x][currentNode.y][currentNode.z] == -1)
				return true;
			return false;
		} else
		{
			System.out.println("illegal input of player !");
			return false;
		}//end else
	}//end containNode

	//whether the winningPositions[w] is blocked by your opponent
	public static boolean isBlocked (int[][][] currentBoard, node[][] winningPositions, int w, char player)
	{
		//set up your opponent
		char opponent;
		switch (player)
		{
			case 'X':
				opponent = 'O';
				break;
			case 'O':
				opponent = 'X';
				break;
			default:
				opponent = 'E';
				System.out.println("illegal input of player !");
				break;
		}//end switch

		//whether it's blocked
		for (int v=1; v<=4; v++)
		{
			if (containNode(currentBoard,winningPositions[w][v],opponent))
				return true;
		}//end for loop w
		return false;
	}//end isBlocked

	//outputs: int longestStrand, int wPro
	public static int[] checkLink (/*inputs*/int[][][] currentBoard, node[][] winningPositions, char player)
	{
		/*wPro - the promising winning position which is not blocked*/
		int w; //the w-th winning position
		int v; //the v-th node in a certain winning position
		int[] output = new int[2];
		output[0] = -1;//longesetStrand
		output[1] = -1;//wPro

		for (w=1; w<=76; w++)
		{
			int length=0;

			if (!isBlocked(currentBoard,winningPositions,w,player))
			{
				for (v=1; v<=4; v++)
				{
					if (containNode(currentBoard, winningPositions[w][v], player))
						length++;
				}//end for loop v
			}//end if

			if (output[0] < length)
			{
				output[0] = length;
				output[1] = w;
			}//end if
		}//end for loop w
		return output;
	}//end checkLink

	//list of nodes which are vacant
	public static ArrayList allUnoccupied (int[][][] currentBoard)
	{
		ArrayList result = new ArrayList();

		for (int x=1; x<=4; x++)
		{
			for (int y=1; y<=4; y++)
			{
				for (int z=1; z<=4; z++)
				{
					if (currentBoard[x][y][z]==0/*unoccupied*/)
					{
						node newNode = new node(x,y,z);
						result.add(newNode);
					}//end if
				}//end for loop z
			}//end for loop y
		}//end for loop x
		return result;
	}//end allUnoccupied

	//whether the board is full
	public static boolean isFull (int[][][] currentBoard)
	{
		ArrayList unoccupied = allUnoccupied(currentBoard);
		if (unoccupied.size()==0)
			return true;
		else
			return false;
	}//end isFull

	//list of nodes which are vacant in a specific winning position: wPro
	public static ArrayList unoccupied_specificWinPosition (int[][][] currentBoard, node[][] winningPositions, int wPro)
	{
		ArrayList result = new ArrayList();

		for (int v=1; v<=4; v++)
		{
			if (currentBoard[winningPositions[wPro][v].x][winningPositions[wPro][v].y][winningPositions[wPro][v].z] == 0)
				result.add(winningPositions[wPro][v]);
		}//end for loop v

		return result;
	}//end unoccupied_specificWinPosition

	//generate a random integer within [0,m] -> (m+1) items
	public static int random (int m)
	{
		Random r = new Random();
		return r.nextInt(m+1);
	}//end random

	//randomly pick a valid position to put the next pawn
	public static void randomPicking (int[][][] currentBoard, ArrayList validPositions)
	{
		int m = validPositions.size() - 1;
		int index = random(m);
		node picked = (node) validPositions.get(index);
		currentBoard[picked.x][picked.y][picked.z] = -1;
		System.out.println("Program just put a pawn on ("+picked.x+","+picked.y+","+picked.z+")");
	}//end randomPicking

	//block user's
	public static void blocking (int[][][] currentBoard, node[][] winningPositions, int wProX)
	{
		ArrayList validPositions = unoccupied_specificWinPosition(currentBoard,winningPositions,wProX);
		randomPicking(currentBoard,validPositions);
	}//end blocking

	//randomly put a pawn
	public static void randomStep (int[][][] currentBoard)
	{
		ArrayList validPositions = allUnoccupied(currentBoard);
		randomPicking(currentBoard,validPositions);
	}//end blocking

	//extend wProO
	public static void extending (int[][][] currentBoard, node[][] winningPositions, int wProO)
	{
		ArrayList validPositions = unoccupied_specificWinPosition(currentBoard,winningPositions,wProO);
		randomPicking(currentBoard,validPositions);
	}//end extending

	//single step which can be blocking, entending or just a random step
	public static void singleStep (int[][][] currentBoard, node[][] winningPositions)
	{
		int longestStrandO, longestStrandX;
		int wProO, wProX;

		//checkLink(currentBoard, winningPositions, program, longestStrandO, wProO);
		int[] checkLinkO = checkLink(/*inputs*/currentBoard,winningPositions,'O'/*outputs: longestStrandO,wProO*/);
		longestStrandO = checkLinkO[0];
		wProO = checkLinkO[1];
		//checkLink(currentBoard, winningPositions, user, longestStrandX, wProX);
		int[] checkLinkX = checkLink(/*inputs*/currentBoard,winningPositions,'X'/*outputs: longestStrandX,wProX*/);
		longestStrandX = checkLinkX[0];
		wProX = checkLinkX[1];

		//decisions
		if (longestStrandX==0 && longestStrandO==0)
		{
			currentBoard[2][2][2] = -1;
			System.out.println("Program just put a pawn on (2,2,2)");
		} else if (longestStrandX==1 && longestStrandO==0)
			randomStep(currentBoard);
		else if (longestStrandX==4 && longestStrandO<=3)
		{
			System.out.println("You Win !");
			printWinningPosition(winningPositions,wProX);
			System.out.println("Press Ctrl+C to exit game.");
		} else if (longestStrandX<=3 && longestStrandO==4)
		{
			System.out.println("You lose !");
			printWinningPosition(winningPositions,wProO);
			System.out.println("Press Ctrl+C to exit game.");
		} else if (longestStrandX==3 && longestStrandO<=2)
			blocking(currentBoard,winningPositions,wProX);
		else if (longestStrandX==3 && longestStrandO==3)
		{
			if (isBlocked(currentBoard,winningPositions,wProO,'O'))//wProO is occupied
				blocking(currentBoard,winningPositions,wProX);
			else //wProO is NOT occupied
				extending(currentBoard,winningPositions,wProO);
		} else if (longestStrandX<=2 && longestStrandO<=3)
			extending(currentBoard,winningPositions,wProO);
		else
			randomStep(currentBoard);

		//check again
			//checkLink(currentBoard, winningPositions, program, longestStrandO, wProO);
			checkLinkO = checkLink(/*inputs*/currentBoard,winningPositions,'O'/*outputs: longestStrandO,wProO*/);
			longestStrandO = checkLinkO[0];
			wProO = checkLinkO[1];
			//checkLink(currentBoard, winningPositions, user, longestStrandX, wProX);
			checkLinkX = checkLink(/*inputs*/currentBoard,winningPositions,'X'/*outputs: longestStrandX,wProX*/);
			longestStrandX = checkLinkX[0];
			wProX = checkLinkX[1];

		//if someone win
		if (longestStrandX==4 && longestStrandO<=3)
		{
			System.out.println("You Win !");
			printWinningPosition(winningPositions,wProX);
			System.out.println("Press Ctrl+C to exit game.");
		} else if (longestStrandX<=3 && longestStrandO==4)
		{
			System.out.println("You lose !");
			printWinningPosition(winningPositions,wProO);
			System.out.println("Press Ctrl+C to exit game.");
		}//end if...else
	}//end singleStep

	//test methods
	public static void main (String[] args) throws Exception
	{
		int[][][] currentBoard = new int[5][5][5];
		//printBoard(currentBoard);

		Scanner inScan = new Scanner(System.in);
		System.out.println("Please input the file name of Winning Positions:");
		String fileName = inScan.next();
		int[][] winPosition = TableIO.matrix(fileName);
		//Print.print2dArray(winPosition);

		node[][] winningPositions = new node[77][5];
		initializeWinningPositions(winningPositions,winPosition);
		//printWinningPositions(winningPositions);

		node testNode = new node(1,2,3);
		currentBoard[1][2][3] = 1;
		//System.out.println(containNode(currentBoard,testNode,'X'));
		currentBoard[1][2][3] = 0;
		//System.out.println(containNode(currentBoard,testNode,'X'));

		int w=73;
		currentBoard[3][3][2] = 1;//blocked by user
		//System.out.println(isBlocked(currentBoard,winningPositions,w,'O'));
		currentBoard[3][3][2] = 0;//unblocking
		//System.out.println(isBlocked(currentBoard,winningPositions,w,'O'));

		//blocked in winningPosition[73] with longestStrandO==3
		currentBoard[1][1][4] = -1;currentBoard[2][2][3] = -1;currentBoard[3][3][2] = -1;currentBoard[4][4][1] = 1;
		//unblocked in winningPosition[75] with longestStrandO==2
		currentBoard[2][2][2] = -1;currentBoard[1][1][1] = -1;
		printBoard(currentBoard);
		int[] checkLinkOutput = checkLink(/*inputs*/currentBoard,winningPositions,'O'/*outputs: longestStrandO,wProO*/);
		int longestStrandO = checkLinkOutput[0];
		int wProO = checkLinkOutput[1];
		//System.out.println("wProO:"+wProO+" longestStranO:"+longestStrandO);

		ArrayList unoccupied = allUnoccupied(currentBoard);
		System.out.println("unoccupiedCell="+unoccupied.size());

		ArrayList unoccupied75 = unoccupied_specificWinPosition(currentBoard,winningPositions,75);
		System.out.println("unoccupied75="+unoccupied75.size());
/*
		for (int i=1; i<=50; i++)
		{
			System.out.println(random(3));
		}//end for loop i
*/
		//randomPicking(currentBoard, unoccupied75);
		//extending(currentBoard,winningPositions,wProO);
		//printBoard(currentBoard);
		currentBoard[2][1][1] = 1;currentBoard[2][2][1] = 1;currentBoard[2][4][1] = 1;
		int[] checkLinkOutput2 = checkLink(/*inputs*/currentBoard,winningPositions,'X'/*outputs: longestStrandX,wProX*/);
		int longestStrandX = checkLinkOutput2[0];
		int wProX = checkLinkOutput2[1];
		//System.out.println("wProX:"+wProX+" longestStranX:"+longestStrandX);
		//blocking (currentBoard,winningPositions,wProX);
		//randomStep(currentBoard);
		printBoard(currentBoard);
		singleStep(currentBoard,winningPositions);
		printBoard(currentBoard);

		System.out.println("The Board is full: " + isFull(currentBoard));
	}//end main
}//end class Tic_Tac_Toe