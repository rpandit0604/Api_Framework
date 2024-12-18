package session4_Oauth2_token;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class OAuth2 {

	String token_generated;
	@Test
	public void AccessToken()
	{
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String token=given().formParams("client_id",payload_credentials.id())
		.formParams("client_secret",payload_credentials.secret())
		.formParams("grant_type","client_credentials")
		.formParams("scope","trust")
		.when().post("/oauthapi/oauth2/resourceOwner/token")
		.then().log().all().statusCode(200).extract().response().asString();
		System.out.println(token);
		
		JsonPath js=new JsonPath(token);
		token_generated=js.get("access_token");
		
	}
	
	@Test(dependsOnMethods = "AccessToken")
	public void course()
	{
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String details=given().queryParam("access_token",token_generated).when().get("/oauthapi/getCourseDetails")
				.then().log().all().assertThat().statusCode(401).extract().response().asString();
		System.out.println(details);
	}
	
	
}
