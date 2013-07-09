package com.actio.app.rest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import javax.ejb.Stateful;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import javax.validation.Validator;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.actio.app.data.EventRepository;
import com.actio.app.model.Event;

/**
 * JAX-RS Example
 * <p/>
 * This class produces a RESTful service to read/write the contents of the members table.
 */
@Path("/events")
@RequestScoped
@Stateful
public class EventService {
    @Inject
    private Logger log;

    @Inject
    private Validator validator;

    @Inject
    private EventRepository repository;

    //@Inject
    //MemberRegistration registration;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Event> listAllMembers() {
        return repository.findAllOrderedByTitle();
    }

    @GET
    @Path("/{id:[0-9][0-9]*}")
    @Produces(MediaType.APPLICATION_JSON)
    public Event lookupById(@PathParam("id") long id) {
    	Event result = repository.findById(id);
        if (result == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return result;
    }
}
