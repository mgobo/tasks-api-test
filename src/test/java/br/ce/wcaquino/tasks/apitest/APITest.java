package br.ce.wcaquino.tasks.apitest;

import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class APITest {
	
	@BeforeClass
	public static void setup() {
		RestAssured.baseURI = "http://localhost:8001/tasks-backend/";
	}
	
	@Test
	public void deveRetornarTarefas() {
		RestAssured.given()
				   .when()
				   		.get("/todo")
				   .then()
				   		.log().all()
				   		.statusCode(200)
				   ;
	}
	
	@Test
	public void deveAdicionarTarefaComSucesso() {
		String json = "{\n"
				+ "        \"id\": 11,\n"
				+ "        \"task\": \"Task test 11\",\n"
				+ "        \"dueDate\": \"2021-10-27\"\n"
				+ "    }";
		System.out.println(json);
		
		RestAssured.given()
				   .body(json)
				   .contentType(ContentType.JSON)
				   .when()
				   	.post("/todo")
				   .then()
				   	.log().all()
				   	.statusCode(201);
	}
	
}
