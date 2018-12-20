import java.util.*;

class GEA
{
	//generate edges
	public static Edge[] get_edges (int[][] G)
	{
		int n = G.length - 1;//number of vertices
		int N = n*(n-1);//number of max edges

		//initialize E
		Edge[] E = new Edge[N];
		for (int i=0; i<N; i++)
			E[i] = new Edge(-1,-1,400000);

		int e=0;

		for (int i=1; i<=n; i++)
		{
			for (int j=1; j<=n; j++)
			{
				if (G[i][j]>0 && G[i][j]<300000)
				{
					E[e].from = i;
					E[e].to = j;
					E[e].distance = G[i][j];
					e++;
				}//end if
			}//end for loop j
		}//end for loop i

		return E;
	}//end get_edges

	//print edges
	public static void printEdges (Edge[] E)
	{
		for (int i=0; i<E.length; i++)
		{
			if (E[i].from != -1)
				System.out.print("v" + E[i].from + "--" + E[i].distance + "--" + "v" + E[i].to + "	");
		}//end for loop i
		System.out.println();
	}//end printEdges

	//sorting edges
	public static void edge_sorting (Edge[] E)
	{
		//insertion sort
		int i,j;
		for (i=1;i<E.length;i++)
		{
			Edge temp = E[i];
			j=i-1;
			while (j>-1 && temp.distance<E[j].distance)
			{
				E[j+1]=E[j];
				j--;
			}//end while loop j
			E[j+1]=temp;
		}//end for loop i

	}//end edge_sorting

	//swap elements
	public static void swap(Edge[] E, int i, int j)
	{
		Edge temp = E[j];
		E[j] = E[i];
		E[i] = temp;
	}//end swap

	public static void generate_tour (int[][] G, ArrayList tour)
	{
		int n = G.length - 1;
		HashSet verticesFrom = new HashSet();
		HashSet verticesTo = new HashSet();

		Edge[] E = get_edges(G);
		edge_sorting(E);
		System.out.println("\nEdges in G (after sorting):");
		printEdges(E);

		for (int i=0; i<E.length && tour.size()<=n; i=i++)
		{
			if (addCondition(n,E[i],verticesFrom,verticesTo,tour))
			{
				tour.add(E[i]);
				verticesFrom.add(E[i].from);
				verticesTo.add(E[i].to);
			}//end if
		}//end for loop i
	}//end generate_tour

	public static boolean addCondition (int n, Edge nextEdge, HashSet verticesFrom, HashSet verticesTo, ArrayList tour)
	{
		//adding next edge to tour does not result in a vertex having 2 edges touching it
		if (nextEdge.distance < 300000)
		{
			if (!verticesFrom.contains(nextEdge.from) && !verticesTo.contains(nextEdge.to))
			{
				//does not creat a cycle smaller than n
				HashSet veticesFromNew = new HashSet();
					veticesFromNew.addAll(verticesFrom);
					veticesFromNew.add(nextEdge.from);
				HashSet veticesToNew = new HashSet();
					veticesToNew.addAll(verticesTo);
					veticesToNew.add(nextEdge.to);
				if (!(subtractSet(veticesFromNew,veticesToNew).size()==0/*cycle*/ && tour.size()<n && tour.size()>0/*cycle not tour*/))
					return true;
			}//end if
		}//end if
		return false;
	}//end addCondition

	//return A-B
	public static HashSet subtractSet(HashSet A, HashSet B)
	{
		HashSet subtraSet = new HashSet();
		subtraSet.clear();
		subtraSet.addAll(A);
		subtraSet.removeAll(B);
		return subtraSet;
		//System.out.println("Subtract Set: "+subtraSet);
	}//end subtractSet

	//return A+B
	public static HashSet UnionSet(HashSet A, HashSet B)
	{
		HashSet UniSet = new HashSet();
	    UniSet.clear();
        UniSet.addAll(A);
        UniSet.addAll(B);
        return UniSet;
	}//end UnionSet

	public static void printTour (ArrayList tour)
	{
		for(int i = 0; i<tour.size(); i++)
		{
			Edge e = (Edge)tour.get(i);
			System.out.print(e.from +"->"+e.to+"	");
		}//end for loop i
	}//end printTour

	public static void main (String[] args) throws Exception
	{
		//initialize G
		Scanner inScan = new Scanner(System.in);
		System.out.println("Please input the G file name (*.xls): ");
		String fileNameG = inScan.next();
		int[][] G = TableIO.matrix(fileNameG);

		//print G
		System.out.println("\nInput graph G:");
		Print.printMatrix(G);
/*
		//print edges
		Edge[] E = get_edges(G);
		System.out.println("\nEdges in G (before sorting):");
		printEdges(E);

		//sorting edges
		edge_sorting(E);
		System.out.println("\nEdges in G (after sorting):");
		printEdges(E);
*/
		//generate tour
		ArrayList tour = new ArrayList();
		generate_tour(G,tour);
		printTour(tour);
	}//end main
}//end class