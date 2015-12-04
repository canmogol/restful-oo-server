package com.fererlab.oo.restful;


import com.fererlab.oo.commons.model.ModelBuilder;
import com.fererlab.oo.commons.restful.AbstractResource;
import com.fererlab.oo.commons.restful.Resource;
import com.fererlab.oo.model.Computer;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/computer")
@Produces({"application/json"})
@Consumes({"application/json"})
@Singleton(name = "ComputerResource", mappedName = "ComputerResource")
@Local(Resource.class)
public class ComputerResource extends AbstractResource<Computer> {

    @EJB(beanName = "ModelBuilder")
    private ModelBuilder modelBuilder;

    @Override
    protected Computer build() throws Exception {
        return modelBuilder.build(Computer.class);
    }
}