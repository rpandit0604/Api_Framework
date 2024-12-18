package Session1;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

public class Post_Put_Get_delete {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
		
		//update
		String new_address= "80 morning walk";  //whatver address u want to update just update here
		String respon= given().log().all().queryParam("key","qaclick123").header("content-type","application/json").body("{\r\n"
				+ "\"place_id\":\""+placeid+"\",\r\n"
				+ "\"address\":\""+new_address+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}")
		.when().put("maps/api/place/update/json")
		.then().log().all().extract().response().asString();
		System.out.println(respon);
		
		//get
		String rosh_getresponse= given().queryParam("key","qaclick123").queryParam("place_id",placeid)
		.when().get("maps/api/place/get/json")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js1=new JsonPath(rosh_getresponse);
		String actual_Address = js1.getString("address");
		System.out.println(actual_Address);		
		Assert.assertEquals(actual_Address, new_address);
		
		
		//Resource
		//Note: Post :  maps/api/place/add/json
		   //   PUT  :  maps/api/place/update/json
		   //   Get  :  maps/api/place/get/json
		
		//Content-Length: 0 : body is empty in response
		
		
		//add request->recieving the response ->storing the response->converting raw to json format->parsing the json and extracting the value
		
	}

}
