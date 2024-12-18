package Session1;

public class Payload_body_booker {

	public static String Body_booker()
	{
		return "{\r\n"
				+ "    \"firstname\": \"{{fname}}\",\r\n"
				+ "    \"lastname\": \"{{lname}}\",\r\n"
				+ "    \"totalprice\": 18,\r\n"
				+ "    \"depositpaid\": true,\r\n"
				+ "    \"bookingdates\": {\r\n"
				+ "        \"checkin\": \"2018-01-01\",\r\n"
				+ "        \"checkout\": \"2019-01-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\": \"super bowls\"\r\n"
				+ "}";
		
	}
}
