package stepDefinations;
import cucumber.Options.jsonpathUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import resource.URL;


import static io.restassured.RestAssured.*;

public class StepDefinations {
	
	String base="https://rahulshettyacademy.com";
	String response;
	String responseString;
	String placeID;
	int code;
	
	@Given("Add the Payload")
	public void add_the_payload() 
	{
	   RestAssured.baseURI=base;
	  System.out.println("given created the payload:"+Payload.payloadPost.body().toString());
		
	}

	@When("send the Post request")
	public void send_the_post_request()
	{
		response=given().queryParam("key","qaclick123")
		.header("content-type","application/json")
		.body(Payload.payloadPost.body())
		.when().post(URL.Post())
		.then().extract().response().asString();
		
		responseString=response.toString();
		placeID=jsonpathUtil.parsejson(responseString,"place_id");
		
	}

	@Then("the user get response code as {int}")
	public void the_user_get_response_code_as(Integer int1)
	{
		code=given().queryParam("key","qaclick123")
		.header("content-type","application/json")
		.body(Payload.payloadPost.body())
		.when().post(URL.Post())
		.then().extract().response().getStatusCode();
		
		System.out.println(code);
	    
		
	}

	@And("the response contains the {string}")
	public void the_response_contains_the(String string) 
	{
		System.out.println("placeID is : "+placeID);
	   
	}

	@Given("the Update Place API payload with place_id {string} and new address {string}")
	public void the_update_place_api_payload_with_place_id_and_new_address(String string, String string2)
	{
	    
	}

	@When("the user calls the UpdatePlace API with PUT HTTP request")
	public void the_user_calls_the_update_place_api_with_put_http_request() 
	{
	   
	}

	@Then("the update API call is successful with status code {int}")
	public void the_update_api_call_is_successful_with_status_code(Integer int1)
	{
	    
	}

	@And("the response contains the message Address successfully updated")
	public void the_response_contains_the_message_address_successfully_updated() 
	{
	    
	}

	@Given("the place_id {string}")
	public void the_place_id(String string) 
	{
	   
	}

	@When("the user calls the GetPlace API with GET HTTP request")
	public void the_user_calls_the_get_place_api_with_get_http_request()
	{
	   
	}
	
	@Then("the get API call is successful with status code {int}")
	public void the_get_API_call_is_successful_with_status_code(Integer int2)
	{
		
	}
	
	@And("the response contains the name {string}")
	public void the_response_contains_the_name(String string)
	{
	   
	}

	@And("the response contains the address {string}")
	public void the_response_contains_the_address(String string) 
	{
	    
	}

	@Given("the Delete Place API payload with place_id {string}")
	public void the_delete_place_api_payload_with_place_id(String string) 
	{
	   
	}

	@When("the user calls the DeletePlace API with DELETE HTTP request")
	public void the_user_calls_the_delete_place_api_with_delete_http_request() 
	{
	   
	}
	
	@Then("the delete API call is successful with status code {int}")
	public void the_delete_API_call_is_successful_with_status_code(Integer int3)
	{
		
	}

	@And("the response contains the message Place deleted successfully")
	public void the_response_contains_the_message_place_deleted_successfully()
	{
	    
	}
	
	
}