package cucumber.Options;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.path.json.JsonPath;
public class jsonpathUtil 
{
	public static String parsejson(String response,String expression)
	{
			
		
		JsonPath js=new JsonPath(response);
		return js.getString(expression);
		
		
	}
	
	
}