package Session1;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class Post_Put_Get_Delete_booker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		RestAssured.baseURI="https://restful-booker.herokuapp.com/";
		
		//Post for creating a data in server
		String post_response= given().header("Content-type","application/json").body(Payload_body_booker.Body_booker())
		.when().post("booking")
		.then().log().all().statusCode(200).body("booking.bookingdates.checkin", equalTo("2018-01-01")).extract().response().asString();
		
		JsonPath js=new JsonPath(post_response);
		int b_id= js.get("bookingid");
		System.out.println(b_id);
		
		//given().header("Content-type","application/json").body("").
	}

}
