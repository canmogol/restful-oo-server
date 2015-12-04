package com.fererlab.oo.commons.restful;

import com.fererlab.oo.commons.model.BaseModel;

import javax.ws.rs.*;
import java.util.List;

@SuppressWarnings("unchecked")
public abstract class AbstractResource<M extends BaseModel> implements Resource<M> {

    @POST
    @Override
    public void create(M model) throws Exception {
        model.create();
    }

    @PUT
    @Override
    public void update(M model) throws Exception {
        model.update();
    }

    @DELETE
    @Override
    public void delete(M model) throws Exception {
        model.delete();
    }

    @GET
    @Override
    @Path("/{id}")
    public M find(@PathParam("id") Integer id) throws Exception {
        M model = build();
        model.setId(id);
        model.find();
        return model;
    }

    @GET
    @Override
    @Path("/")
    public List<M> findAll() throws Exception {
        M model = build();
        return model.findAll();
    }

    protected abstract M build() throws Exception;


}
