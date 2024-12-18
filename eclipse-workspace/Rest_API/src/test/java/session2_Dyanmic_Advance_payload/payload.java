package session2_Dyanmic_Advance_payload;

public class payload {
	
	public static String Add(String ISBN , String AISLE)
	{
		String add_payload="{\r\n"
				+ "  \"name\": \"Lear Appium Automation with Java\",\r\n"
				+ "  \"isbn\": \""+ISBN+"\",\r\n"
				+ "  \"aisle\": \""+AISLE+"\",\r\n"
				+ "  \"author\": \"John foe\"\r\n"
				+ "}\r\n"
				+ "";
		return add_payload;
		
	}

}
