package resource;
import java.util.*;
public class URL 
{

	public static String Post()
	{
		return "/maps/api/place/add/json";
	}
	
	public static String Put()
	{
		return "/maps/api/place/update/json";
	}
	public static String Get()
	{
		return "maps/api/place/get/json";
	}
	
}