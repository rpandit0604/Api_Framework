package Session1;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class Post_bookerApi {

	
	public static void main(String args[])
	{
		
		RestAssured.baseURI="https://restful-booker.herokuapp.com";
		given().header("content-type","application/json").body(Payload_body_booker.Body_booker())
		.when().post("/booking")
		.then().log().all().assertThat().statusCode(200).body("booking.firstname",equalTo("{{fname}}"))
		.body("booking.depositpaid",equalTo(true))
		.header("Server","Cowboy");
	}
}
