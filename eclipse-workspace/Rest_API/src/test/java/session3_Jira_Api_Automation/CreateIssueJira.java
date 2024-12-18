package session3_Jira_Api_Automation;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class CreateIssueJira {

	 String jiraId;
	//postman we use accept but in restassured we can directly given without giving accept header.
	@Test(dataProvider="Create")
	public void Create(String summar)
	{
		RestAssured.baseURI="https://roshanapidemo.atlassian.net";
		String jira_response= given().header("Authorization","Basic cnBhbmRpdDA2MDRAZ21haWwuY29tOkFUQVRUM3hGZkdGMHJ1eFBWclRCZ3Z6UnlYUkhPTXZURXF3ci1PNmVsVGpIQUg1SFBkOEpianMwQ1BEYjg0Wmw0ajRuUTBxeno1aWItQmhNU212QlJHcC1lemdid2dsUXlHcmJVSE8tN2cycDZnLThBa2dOX2gzQWFYS01OTkJ4bjN2ZVdFZFdHUkd2S0FmZVlYbE5hb1F1aWxRU3FnZUFUMXhPVkgxUXNoVDQ0UE9FT3RQZkk0ST02RUQ5NTE5Qg==")
		.header("Content-type","application/json")
		.body(payloadJira.Payload(summar))
		.when().post("/rest/api/3/issue")
		.then().log().all().assertThat().statusCode(201).extract().response().asString();
		System.out.println(jira_response);
		
		JsonPath js=new JsonPath(jira_response);
		jiraId=js.get("key");
		
	}
	@Test(dependsOnMethods = "Create")
	public void Attachment()
	{
		RestAssured.baseURI="https://roshanapidemo.atlassian.net";
		File file = new File("C:/Users/rospandi/Downloads/Info.txt");
		String attach_response= given().header("Authorization","Basic cnBhbmRpdDA2MDRAZ21haWwuY29tOkFUQVRUM3hGZkdGMHJ1eFBWclRCZ3Z6UnlYUkhPTXZURXF3ci1PNmVsVGpIQUg1SFBkOEpianMwQ1BEYjg0Wmw0ajRuUTBxeno1aWItQmhNU212QlJHcC1lemdid2dsUXlHcmJVSE8tN2cycDZnLThBa2dOX2gzQWFYS01OTkJ4bjN2ZVdFZFdHUkd2S0FmZVlYbE5hb1F1aWxRU3FnZUFUMXhPVkgxUXNoVDQ0UE9FT3RQZkk0ST02RUQ5NTE5Qg==")
		.header("X-Atlassian-Token","no-check")
		.multiPart("file",file)
		.when().post("rest/api/2/issue/" + jiraId + "/attachments")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		System.out.println(attach_response);
	}
	
	@DataProvider(name="Create")
	public Object[][] getData()
	{
		
		return new Object[][] {{"THis is bug 1"},{"This is bug 2"},{"This is bug 3"},{"This is bug 4"}};
	}
	
	
	
}
