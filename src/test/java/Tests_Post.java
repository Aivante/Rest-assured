import java.util.HashMap;
import java.util.Map;
import static io. restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Tests_Post {
	@Test
	public void test_1_post(){
		//map is key value 
		// Sample comment
		Map<String,Object>map = new HashMap<String, Object>();
		//this is not json request
//		map.put("name", "Sravani");
//		map.put("job", "Teacher");
//		System.out.println(map);
		//JSONObject request=new JSONObject(map);
		//here i am using json object
		//here i dont need to use hash map concept because we are usung json library
		//
		
		
		//JSONObject request=new JSONObject(map);
		JSONObject request=new JSONObject();
		request.put("name","Sravani");
		request.put("job","teacher");
		//System.out.println(request);
		System.out.println(request.toJSONString());
		baseURI="https://reqres.in/api";
		//let me do some identation
		given().
			header("Cntent-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("/users").
		then().statusCode(201).
		log().all();
	
		
		
	}

}
