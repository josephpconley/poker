package joejava.util;
//
//JMath.java
//
//Class containing some math-based methods

import java.util.ArrayList;
import java.util.Random;

public class MathUtility{
	
	static Random generator = new Random();
	
	public static int gcd (int m, int n){
		int min;
		int gcd = 1;
		int count = 1;
	
		if(n<=m){
			min = n;
		}else{
			min = m;
		}	
		while(count <= min){
			if((n/count)*count == n && (m/count)*count == m)	//this part works b/c division in Java cuts off remainders
				gcd = count;
				count++;
		}
		return gcd;
	}
				
	//Returns a double array of possible indexes for a given number of limits	
	public static int[][] combArray(int[] limit){
		int comb = 1;
		int length = limit.length;
		comb = arrayProd(0,length-1,limit);
		int[][] combArray = new int[comb][];
		
		for(int f=0;f<comb;f++){
			combArray[f] = new int[length];

			for(int g=0;g<(length-1);g++){
				combArray[f][g] = (f/arrayProd(g+1,length-1,limit)) % limit[g];
			}
			combArray[f][length-1] = f % limit[length-1];
		}
		return combArray;
	}
	
	//Performs factorial (n!)	
	public static int fact(int n){
		int fact = 1;

		if(n > 1){
			for(int i=1;i<n+1;i++){
				fact = fact * i;
			}
		}
		return fact;
	}

	//Calculates mCn (m choose n, used for combinations)
	public static int nCr(int n, int r){
		int C = 0;
		C = ( fact(n) / (fact(n-r) * fact(r)) );	
		return C;
	}
	
//Produce next combination as an int[]
	public static int[] nextCombo(int n, int r,int[] a){
		int[] b = new int[r];
	
		for(int x=0;x<r;x++){
			b[x] = a[x];	//can't do straight equality of arrays, gets weird
		}
	
		int i = r - 1;
		while (b[i] == n - r + i) {
			i--;
		}
		b[i]++;
	
		for(int j=i+1;j<r;j++){
			b[j] = b[i]+j-i;
		}
		return b;
	}

//Enumerates all combinations of nCr

	public static int[][] combos(int n, int r){
		int nCr = nCr(n,r);
		int[] a = new int[r];
		int[][] combos = new int[nCr][];
		
		for(int i=0;i<r;i++){
			a[i]=i;
		}
		combos[0]=a;
	
		for(int j=1;j<nCr;j++){
			a = nextCombo(n,r,a);
			combos[j] = a;
		}
	
		return combos;
	}		
		
//Multiplies an array of integers
//	Use a and b to specify the interval of multiplication//

	public static int arrayProd(int a, int b, int[] numArray){
		int prod=1;

		for(int c=a;c<b+1;c++){
			prod = prod*numArray[c];
		}
		return prod;
	}
	
//Multiplies the entire array of integers			
	public static int arrayProd(int[] numArray){
		int prod=1;

		for(int c=0;c<numArray.length;c++){
			prod=prod*numArray[c];
		}
	
		return prod;
	}

//Sums an array of integers
	public static int arraySum(int[] numArray){
		int sum=0;
	
		for(int d=0;d<numArray.length;d++){
			sum=sum+numArray[d];
		}
		
		return sum;	
	}	
	
//Sums two arrays by rules of vector (component-wise)
//	Should be of same length!!!
	public static int[] addVectors(int[] v1, int[] v2){
		for(int i=0;i<v1.length;i++){
			v2[i] = v1[i]+v2[i];
		}
		return v2;
	}
	
//Adds a scalar value component-wise to a vector	
	public static int[] addCtoVector(int c, int[]v){
		int[] r = new int[v.length];
	
		for(int i=0;i<r.length;i++){
			r[i] = v[i]+c;
		}
		return r;
	}

//Produces an array of random integers from 0 to n-1//
	public static ArrayList<Integer> randIntList(int n)	{
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(generator.nextInt(n));
		
		for(int i=1;i<n;i++){
			int num = -1;
			while(nums.contains((num = generator.nextInt(n)))){
			}
			
			nums.add(num);
		}
		
		return nums; 	
	}
	
//Given an array of Strings, removes specified Strings
	public static String[] subtractArray(String[] base,String[] removed){
		int newLen =base.length-removed.length; 
		String[] trimmed = new String[newLen];
		boolean member=true;
		int index=0;
		
		for(int i=0;i<base.length;i++){
			member = true;
			for(int j=0;j<removed.length;j++){
				if(base[i].equals(removed[j]))
				member=false;
			}
		
			if(member == true){
				trimmed[index] = base[i];	
				index++;
			}	
		}
	
		return trimmed;
	}
	
//Used to determine if an array of boolean are all true
	public static boolean allTrue(boolean[] b,int n){
		boolean test = false;
		int count=0;
	
		for(int i=0;i<n;i++){
			if(b[i] == false){
				count++;
			}
		}
		if(count==0){
			test=true;
		}
		return test;
	}
	
//Checks to see if String a is a member of String array B[]	
	public static boolean isMember (String a, String[] B){
		boolean test = false; 
	
		for(int j=0;j<B.length;j++){
			if(a.equals(B[j])){
				test = true;
			}
		}	
		return test;	
	}
	
//Checks to see if int n is a member of int[] array 		
	public static boolean isMember (int n, int[] array){
		boolean test = false; 
	
		for(int i=0;i<array.length;i++){
			if(n == array[i]){
				test = true;
			}
		}	

		return test;	
	}

//Return the min of an array of doubles
	public static double min (double[] index1)	{
		int count = 0;
		double min = 0;
		int len = index1.length;
			
		for(int i=0;i<len;i++){
			count = 0;
			for(int j=0;j<len;j++){
				if(index1[i] > index1[j])
				count++;
			}
			if(count == 0){
				min = index1[i];
			}
		}
		return min;
	}

//Return the min of an array of integers	
	public static int min (int[] index1){
		int count = 0;
		int min = 0;
		int len = index1.length;
			
		for(int i=0;i<len;i++){
			count = 0;
			for(int j=0;j<len;j++){
				if(index1[i] > index1[j]){
					count++;
				}
			}
	
			if(count == 0){
				min=index1[i];
			}
		}
		return min;
	}
	
//Return the max of an array of doubles
	public static double max (double[] index1){
		int count = 0;
		double max = 0;
		int len = index1.length;
			
		for(int i=0;i<len;i++){
			count = 0;
			for(int j=0;j<len;j++){
				if(index1[i] < index1[j]){
					count++;
				}
			}
	
			if(count == 0){
				max=index1[i];
			}
		}
		return max;
	}

//Return the max of an array of integers	
	public static int max (int[] index1){
		int count = 0;
		int max = 0;
		int len = index1.length;
			
		for(int i=0;i<len;i++){
			count = 0;
			for(int j=0;j<len;j++){
				if(index1[i] < index1[j]){
					count++;
				}
			}
			if(count == 0){
				max=index1[i];
			}
		}
		return max;
	}
	
//SET THEORY STUFF (unions of "sets" (arrays in our case), etc.)	
	
//Takes the union of an array of integer arrays	
	public static int[] union (int[][] arrays){
		boolean zerocheck = false;
		int[] lengths = new int[arrays.length];
	
		for(int i=0;i<arrays.length;i++){
			lengths[i]=arrays[i].length;
		}
	
		int[] union = new int[arraySum(lengths)];
		int index=0;
	
		for(int j=0;j<arrays.length;j++){
			for(int k=0;k<arrays[j].length;k++){
				if(isMember(arrays[j][k],union) == false || (arrays[j][k] == 0 && zerocheck == false)){
					union[index] = arrays[j][k];	
					index++;
					if(arrays[j][k] == 0){
						zerocheck=true;
					}
				}		
			}				
		}
		return union;
	}
	
//Takes one int[] array X and subtracts all elements from A (i.e. X - A)
	public static int[] subtractArray(int[] X, int[] A){
		int[] comp = new int[X.length];
		boolean diff = true;
		int index = 0;
		
		for(int i=0;i<X.length;i++){
			diff = true;
			
			for(int j=0;j<A.length;j++){
				if(X[i] == A[j])
				diff = false;
			}	
			
			if(diff == true){
				comp[index] = X[i];
				index++;
			}
		}
			
		return comp;//a.trim(comp,index);
	}	

//Determines if a given string is a number or not
	public boolean isNumber(String str){
		boolean test = true;
		char[] digits = str.toCharArray();
	
		for(int i=0;i<digits.length;i++){
			if(Character.isDigit(digits[i]) == false)
				test = false;
		}
		return test;
	}		

//Returns the written form of a number (restricted to sub-100 for now)
//	- no dashes are used as this function helps to create table names in a database
	public String toString(int n){
		
		String numStr = null;
		
		String[] low = { "zero",  "one",   "two",  "three", "four",   "five",   "six",
		        "seven", "eight", "nine", "ten",   "eleven", "twelve", "thirteen",
		        "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };
		String[] high = { "twenty", "thirty", "forty", "fifty", 
				"sixty", "seventy", "eighty", "ninety"};

		if(n < 20){
			numStr = low[n];
		}else{
			String str = Integer.toString(n);
			int tens = Integer.valueOf(str.substring(0,1));
			int ones = Integer.valueOf(str.substring(1,2));
			if(ones > 0){
				numStr = high[tens-2] + low[ones];
			}else{
				numStr = high[tens-2];
			}
		}
		return numStr;			
	}
}