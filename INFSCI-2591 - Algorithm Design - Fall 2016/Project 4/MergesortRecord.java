class MergesortRecord
{
	//Indicates if the first and second half of the array have already been sorted 
	public boolean sorted;
	public int first;
	public int last;

	MergesortRecord(boolean s, int f, int l)
	{
		sorted = s;
		first = f;
		last = l;
	}//end MergesortRecord
	
	void print()
	{
		System.out.println(sorted+" "+first+" "+last);
	}//end print
}//end class