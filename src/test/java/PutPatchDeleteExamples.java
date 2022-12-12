import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutPatchDeleteExamples {
	@Test
	public void test_1_put(){	
		
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
			put("/users/2").//put is for updatae
		then().statusCode(200).
		log().all();
	
		
		
	}

	
	@Test
	public void test_1_patch(){	
		
		JSONObject request=new JSONObject();
		request.put("name","Sri");
		request.put("job","tea");
		//System.out.println(request);
		System.out.println(request.toJSONString());
		baseURI="https://reqres.in";
		//let me do some identation
		given().
			header("Cntent-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			patch("/api/users/2").//put is for updatae
		then().statusCode(200).
		log().all();
}
	@Test
	public void test_1_delete(){	
		
		
		baseURI="https://reqres.in";
		//let me do some identation
		given().
		when().
			delete("/api/users/2").//put is for updatae
		then().
		statusCode(204).
		log().all();
}
	
}


