package rest.client;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import rest.api.exception.ErrorMessage;
import rest.api.payload.Data;


public class RESTClient {

	public static void main(String[] args) {
		// Create Jersey client
		com.sun.jersey.api.client.config.ClientConfig clientConfig = new com.sun.jersey.api.client.config.DefaultClientConfig();
		clientConfig.getFeatures().put(com.sun.jersey.api.json.JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);

		String target = "http://localhost:8080/server/api/rest/";

		// add
		add(client, target);

		// get
		get(client, target);

		// update
		update(client, target);
		
		// delete
		delete(client, target);
	}

	/**
	 * Add
	 * @param Client
	 */
	static void add(Client client, String path) {
		System.out.println("add");
		WebResource webResource = client.resource(path);
		Data input = new Data("Info");
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, input);
		ErrorMessage output = response.getEntity(ErrorMessage.class);
		Gson gson = new Gson().newBuilder().setPrettyPrinting().create();
		System.out.println(gson.toJson(output));
	}

	/**
	 * Get
	 * @param client
	 */
	static void get(Client client, String path) {
		System.out.println("get");
		int id = 1;
		WebResource webResource = client.resource(path).queryParam("id", String.valueOf(id));
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		ErrorMessage output = response.getEntity(ErrorMessage.class);
		Gson gson = new Gson().newBuilder().setPrettyPrinting().create();
		System.out.println(gson.toJson(output));
	}
	
	/**
	 * Update
	 * @param client
	 */
	static void update(Client client, String path) {
		System.out.println("updateStudent");
		WebResource webResource = client.resource(path);
		Data input = new Data("Info");
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).put(ClientResponse.class, input);
		ErrorMessage output = response.getEntity(ErrorMessage.class);
		Gson gson = new Gson().newBuilder().setPrettyPrinting().create();
		System.out.println(gson.toJson(output));
	}
		
	/**
	 * Delete
	 * @param client
	 */
	static void delete(Client client, String path) {
		System.out.println("delete");
		WebResource webResource = client.resource(path);
		Data input = new Data("Info");
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).delete(ClientResponse.class, input);
		ErrorMessage output = response.getEntity(ErrorMessage.class);
		Gson gson = new Gson().newBuilder().setPrettyPrinting().create();
		System.out.println(gson.toJson(output));
	}	
}