package session5_POJO;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

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
		GetCourse gc=given().queryParam("access_token",token_generated).when().get("/oauthapi/getCourseDetails")
				.then().log().all().assertThat().statusCode(401).extract().response().as(GetCourse.class);
		
		System.out.println(gc.getExpertise());
		System.out.println(gc.getInstructor());
		System.out.println(gc.getServices());
		System.out.println(gc.getCourses().getApi().get(1).getPrice());
		
		List<webAutomation> webCourse = gc.getCourses().getWebAutomation(); //multiple items are there so we generate one list
		for(int i=0;i<webCourse.size();i++)
		{
			if(webCourse.get(i).getCourseTitle().equalsIgnoreCase("Protractor"))
			{
				System.out.println(webCourse.get(i).getPrice());
			}
		}
		
		/*List<courses> allCourses = new ArrayList<>();
		allCourses.addAll(gc.getCourses().getWebAutomation());
		allCourses.addAll(gc.getCourses().getApi());
		allCourses.addAll(gc.getCourses().getApi());
		
		
		for(courses course:allCourses)
		{
			System.out.println(course.getCourseTitle());
		}
		*/
		
		
	}
	
	
}
