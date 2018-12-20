import java.util.*;

class NNA
{
	//generate shortest tour starting from vertex i
	public static void generate_tour (int[][] G, int start, ArrayList tour)
	{
		int n = G.length - 1;
		tour.add(start);

		while (tour.size() < n)
		{
			int i = (int) tour.get(tour.size()-1);
			int next = -1;
			int min = 400000;

			for (int j=1; j<=n; j++)
			{
				if (i!=j && G[i][j]<min)
				{
					min = G[i][j];
					next = j;
				}//end if
			}//end for loop j

			tour.add(next);
		}//end while loop
	}//end generate_tour

	//generate the union graph of G1 & G2
	public static int[][] unionGraph (int[][] G1, int[][] G2)
	{
		int n1 = G1.length - 1;
		int n2 = G2.length - 1;
		int[][] G = new int[n1+1][n1+1];

		if (n1!=n2)
			System.out.println("G1 & G2 have different sizes!");
		else //n1==n2
		{
			for (int i=1; i<=n1; i++)
			{
				for (int j=1; j<=n1; j++)
				{
					G[i][j] = G1[i][j]<G2[i][j] ? G1[i][j] : G2[i][j];
				}//end for loop j
			}//end for loop i
		}//end else

		return G;
	}//end unionGraph

	public static void main (String[] args) throws Exception
	{
		//initialize G1 & G2
		Scanner inScan = new Scanner(System.in);
		System.out.println("Please input the G1 file name (*.xls): ");
		String fileNameG1 = inScan.next();
		System.out.println("Please input the G2 file name (*.xls): ");
		String fileNameG2 = inScan.next();
		int[][] G1 = TableIO.matrix(fileNameG1);
		int[][] G2 = TableIO.matrix(fileNameG2);

		//generate union graph G = (G1 U G2)
		System.out.println("\nUnion Graph G = (G1 U G2):");
		int[][] G = unionGraph(G1,G2);
		Print.printMatrix(G);

		//generate tour
		ArrayList tour = new ArrayList();
		int start = 5;
		generate_tour(G,start,tour);

		//print tour
		System.out.println("\nApply NNA to G starting at v" + start + ":");
		for(int i = 0; i<tour.size(); i++)
			System.out.print(tour.get(i)+"->");
		System.out.println(start);
	}//end main
}//end class