package com.example.demo.netflix;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class Responser {
	
	public static Response getResponse(Status status,Object message) {
		return Response.ok(message).status(status).build();
	}

}
