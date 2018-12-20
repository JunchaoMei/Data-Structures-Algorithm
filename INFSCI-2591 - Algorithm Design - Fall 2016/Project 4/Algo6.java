import java.util.*;

public class Algo6
{
    public static int select(int n,int[] S, int k)
	{
        return selection2(S,1,n-1,k);
    }//end select

    public static int selection2(int[] S,int low, int high, int k)
	{
        int pivotpoint;
        
        if(low == high)
            return S[low];
        else
		{
            pivotpoint = partition(S, low, high);
            if(k == pivotpoint)
                return S[pivotpoint];
            else if(k < pivotpoint)
                return selection2(S, low, pivotpoint-1, k);
            else 
                return selection2(S, pivotpoint+1, high, k);
        }//end else
    }//end selection2
    
    private static int partition(int[] S, int low, int high)
	{
        int arraysize = high - low;
        int r = arraysize/5;
        int i,j, mark=0, first, last,temp;
        int pivotitem;
        int[] T = new int[r];
        
        for(i=0; i<r; i++)
		{
            first = low + 5*i -5;
            last = Math.min(low+5*i-1, arraysize);
            int mid = (last - first)/2;
            T[i] = S[mid];
        }//end for loop i
         
        pivotitem = select(r,T,(r+1)/2);
        j = low;
        
        for(i = low; i<high; i++)
		{
            if(S[i] == pivotitem)
			{
                //exchange(S[i], S[j]);
                temp = S[i];
                S[i] = S[j];
                S[j] = temp;
                mark = j;
                j++;
            } else if(S[i] < pivotitem)
			{
                //exchange(S[i], S[j]);
                temp = S[i];
                S[i] = S[j];
                S[j] = temp;
                j++;
            }//end else
        }//end for loop i
        
        //exchange(S[mark], S[j-1]);
        temp = S[mark];
        S[mark] = S[j-1];
        S[j-1] = temp;
        return j-1;
    }//end partition

    public static void main(String[] args)
	{
        int[] S = ArrayGenerator.randomArray(15, 50);;
        System.out.println("The array S is "+Arrays.toString(S));Arrays.sort(S);
		Scanner inScan = new Scanner(System.in);
		System.out.println("please enter k:");
		int k = inScan.nextInt();
        System.out.println("The " +k+ "th-smallest key in S is "+S[k-1]);
    }//end main
}//end class