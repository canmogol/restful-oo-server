package com.fererlab.oo.commons.model;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@LocalBean
@Stateless(name = "ModelBuilder", mappedName = "ModelBuilder")
public class ModelBuilder {

    @PersistenceContext
    private EntityManager entityManager;

    public <M extends BaseModel> M build(Class<M> modelClass) throws Exception {
        M model = modelClass.newInstance();
        model.setEntityManager(entityManager);
        return model;
    }

}
