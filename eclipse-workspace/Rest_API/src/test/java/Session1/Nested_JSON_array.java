package Session1;

import org.testng.Assert;

import io.restassured.path.json.JsonPath;

public class Nested_JSON_array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//we have made one mock response json api where we are calliing 
		JsonPath js =new JsonPath(payload_addplace.json_nested());
		
		//1.
		int count=js.getInt("courses.size()");
		System.out.println(count);
		
		//2.
		int p_amount= js.getInt("dashboard.purchaseAmount");
		System.out.println(p_amount);
		
		//3.//4.
		for(int i=0;i<count;i++)
		{
			String c_title= js.getString("courses["+i+"].title");
			String c_price= js.getString("courses["+i+"].price"); 
			
			System.out.println(c_title +" "+ c_price);
		}
		
		//5.
		
		for(int i=0;i<count;i++)
		{
			if(js.getString("courses["+i+"].title").equalsIgnoreCase("RPA"));
			{
				System.out.println(js.getString("courses["+i+"].copies").toString());
				break;
			}
		}
		
		
		//6.
		int sum=0;
		for(int i=0;i<count;i++)
		{
			int price_p= js.getInt("courses["+i+"].price");
			int copy_c= js.getInt("courses["+i+"].copies");
			int amount=price_p * copy_c;
			System.out.println(sum);
			sum=sum+amount;
				
		}
		System.out.println("Sum of all Course prices  "+sum);
		Assert.assertEquals(sum, 910);
		
		
		
		
	}

}
/*1. Print No of courses returned by API

2.Print Purchase Amount

3. Print Title of the first course

4. Print All course titles and their respective Prices

5. Print no of copies sold by RPA Course

6. Verify if Sum of all Course prices matches with Purchase Amount*/