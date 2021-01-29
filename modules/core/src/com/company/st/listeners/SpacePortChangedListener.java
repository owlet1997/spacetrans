package com.company.st.listeners;

import com.company.st.entity.spaceport.SpacePort;
import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.listener.BeforeDeleteEntityListener;
import com.haulmont.cuba.core.listener.BeforeInsertEntityListener;
import com.haulmont.cuba.core.listener.BeforeUpdateEntityListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.validation.ValidationException;

@Component("st_SpacePortChangedListener")
public class SpacePortChangedListener implements
        BeforeUpdateEntityListener<SpacePort>,
        BeforeInsertEntityListener<SpacePort>,
        BeforeDeleteEntityListener<SpacePort>{
    private static final Logger log = LoggerFactory.getLogger(SpacePortChangedListener.class);


    @Override
    public void onBeforeDelete(SpacePort entity, EntityManager entityManager) {

    }

    @Override
    public void onBeforeInsert(SpacePort entity, EntityManager entityManager) {
        log.info(entity.toString());
        if (entity.getMoon() != null && entity.getPlanet() != null){
            throw new ValidationException("You should choose only one object - planet or moon!");
        }
    }

    @Override
    public void onBeforeUpdate(SpacePort entity, EntityManager entityManager) {

    }
}