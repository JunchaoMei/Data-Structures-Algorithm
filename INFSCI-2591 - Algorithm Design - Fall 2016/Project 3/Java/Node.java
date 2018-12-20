import java.util.*;

class Node
{
	private int vertex = -1;
	private int parent = -1;
	private int level = -1;
	private HashSet ancestors = new HashSet();
	private HashSet ancestorsVertex = new HashSet();
	private HashSet children = new HashSet();
	private HashSet childrenVertex = new HashSet();

	//constructors
	public Node(int ver, int par, int lev)
	{ vertex=ver; parent=par; level=lev;}

	//getters
	public int getVertex()
	{ return vertex;}
	public int getParent()
	{ return parent;}
	public int getLevel()
	{ return level;}
	public HashSet getAncestors()
	{ return ancestors;}
	public HashSet getAncestorsVertex()
	{ return ancestorsVertex;}
	public HashSet getChildren()
	{ return children;}
	public HashSet getChildrenVertex()
	{ return childrenVertex;}

	//setters
	public void setVertex(int ver)
	{ vertex=ver;}
	public void setParent(int par)
	{ parent=par;}
	public void setLevel(int lev)
	{ level=lev;}
	public void setChildren(HashSet child)
	{ children = child;}
	public void addChild(Node child)
	{ children.add(child);}
	public void addChildVertex(int childVertex)
	{ childrenVertex.add(childVertex);}
	public void setAncestors(HashSet ancest)
	{ ancestors = ancest;}
	public void addAncestor(Node ancest)
	{ ancestors.add(ancest);}
	public void addAncestorVertex(int ancestVertex)
	{ ancestorsVertex.add(ancestVertex);}


	public HashSet intersect()
	{
		HashSet result = new HashSet();
		result.clear();
        result.addAll(ancestorsVertex);
        result.retainAll(childrenVertex);
		return result;
	}//end intersect

	public Node correctAncestor()
	{
		HashSet inter = intersect();
		Iterator itInter = inter.iterator();
		int ancestorVertex;
		ancestorVertex = Integer.parseInt(itInter.next().toString().trim());
		//System.out.println("ancestorVertex: " + ancestorVertex);

		Iterator itAncestor = ancestors.iterator();
		while (itAncestor.hasNext())
		{
			Node nod = (Node) itAncestor.next();
			//System.out.println(nod.toString());
			//System.out.println(nod.getVertex());
			if (nod.getVertex() == ancestorVertex)
				return nod;
		}//end while loop
		return null;
	}//end correctAncestor

	public int cycleLength()
	{
		int result = 300000;
		if (!intersect().isEmpty())
			result = level-correctAncestor().getLevel()+1;
		return result;
	}//end cycleLength

	//test methods
	public static void main(String[] args)
	{
		Node N6 = new Node(6, 2, 4);
		Node N1 = new Node(1, -1, 1);
		Node N2 = new Node(2, 4, 3);
		Node N4 = new Node(4, 1, 2);

		N6.addChildVertex(1);
		System.out.println("childrenVertex: " + N6.childrenVertex.toString());

		N6.addAncestorVertex(N2.getVertex());
		N6.addAncestor(N2);
		N6.addAncestorVertex(4);
		N6.addAncestor(N4);
		N6.addAncestorVertex(1);
		N6.addAncestor(N1);
		System.out.println("ancestorsVertex: " + N6.ancestorsVertex.toString());
		System.out.println("ancestors: " + N6.ancestors.toString());

		System.out.println("intersect: " + N6.intersect());

		Node An = N6.correctAncestor();
		System.out.println("correctAncestor: " + An.toString());
		int shortest = N6.cycleLength();
		System.out.println("cycleLength: " + shortest);
	}//end main

}//end Node