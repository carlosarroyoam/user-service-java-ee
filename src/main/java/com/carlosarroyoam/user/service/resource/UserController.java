package com.carlosarroyoam.user.service.resource;

import java.net.URI;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import com.carlosarroyoam.user.service.dto.UserResponse;
import com.carlosarroyoam.user.service.entity.User;
import com.carlosarroyoam.user.service.service.UserService;

@Path("/users")
@ApplicationScoped
public class UserController {

	@Inject
	private UserService userService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAll() {
		List<UserResponse> users = userService.findAll();
		return Response.ok(users).build();
	}

	@GET
	@Path("/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findById(@PathParam("userId") Long userId) {
		UserResponse findById = userService.findById(userId);
		return Response.ok(findById).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(User user) {
		UserResponse createdUser = userService.create(user);

		URI location = UriBuilder.fromResource(UserController.class).path("/{userId}")
				.resolveTemplate("userId", user.getId()).build();

		return Response.created(location).entity(createdUser).build();
	}

	@PUT
	@Path("/{userId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("userId") Long userId, User user) {
		UserResponse updatedUser = userService.update(userId, user);
		return Response.ok(updatedUser).build();
	}

	@DELETE
	@Path("/{userId}")
	public Response delete(@PathParam("userId") Long userId) {
		userService.delete(userId);
		return Response.noContent().build();
	}

}