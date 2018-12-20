class TestGirthCases
{
	public static void main(String[] args) throws Exception
	{	
		//arg[0] = input file name
		Girth g = new Girth(args[0]);
		g.BFS();
		System.out.println("Girth="+g.getGirth());
	}//end main
}//end class TestGirth