package PracticeCodes;

import java.util.Arrays;

public class RevString1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//hello world come goa
		//aog emoc dlrow olleh
		
		String originalString="hello world come goa";
		String[] brokenstring=originalString.split("");
		String[] spacestring=originalString.split(" ");
		//System.out.println(Arrays.toString(brokenstring));
		//System.out.println(Arrays.toString(spacestring));
		for(String s:brokenstring)
		{
			System.out.println(s);
		}
		
		for(int i =spacestring.length-1;i>=0;i--)
		{
			
			String[] revstring=spacestring[i].split("");
			for(int j=revstring.length-1;j>=0;j--)
			{
				System.out.print(revstring[j]);
			}
			System.out.print(" ");
			
			
		}
		
	}

}
