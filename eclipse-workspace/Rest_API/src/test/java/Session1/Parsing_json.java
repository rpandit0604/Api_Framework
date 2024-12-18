package Session1;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Parsing_json {

	public static void main(String args[])
	{
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		//capture the response
		String rosh_response=given().log().all().queryParam("key","qaclick123").header("content-type","application/json").body(payload_addplace.addApi())
		.when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200)
		.body("scope",equalTo("APP")).header("Server","Apache/2.4.52 (Ubuntu)")
		.extract().response().asString();
		
		System.out.println(rosh_response);
		
		//parse the json
		JsonPath js = new JsonPath(rosh_response);
		String placeid= js.getString("place_id");
		System.out.println(placeid);
		
		
	}
	
}
