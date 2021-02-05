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
import java.util.List;

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
        if (entity.getMoon() != null && entity.getPlanet() != null){
            throw new ValidationException("You should choose only one object - planet or moon!");
        }
        setDefaultPort(entity,entityManager);
    }

    @Override
    public void onBeforeUpdate(SpacePort entity, EntityManager entityManager) {
        setDefaultPort(entity,entityManager);
    }

    private void setDefaultPort(SpacePort entity, EntityManager entityManager){
        if (entity.getIsDefault()){
            if (entity.getPlanet() != null) {
                log.info("Default port planet update");
                List<SpacePort> spacePortList = (List<SpacePort>) entityManager.createQuery(
                        "select s from st_SpacePort s where s.planet = :planet and s.id <> :id")
                        .setParameter("planet", entity.getPlanet())
                        .setParameter("id", entity.getId())
                        .getResultList();
                if (!spacePortList.isEmpty()){
                    for (SpacePort port: spacePortList) {
                        port.setIsDefault(false);
                        entityManager.persist(port);
                    }
                }
            }
            else if (entity.getMoon() != null) {
                List<SpacePort> spacePortList = (List<SpacePort>) entityManager.createQuery(
                        "select s from st_SpacePort s where s.moon = :moon and s.id <> :id")
                        .setParameter("moon", entity.getMoon())
                        .setParameter("id", entity.getId())
                        .getResultList();
                if (!spacePortList.isEmpty()){
                    for (SpacePort port: spacePortList) {
                        port.setIsDefault(false);
                        entityManager.persist(port);
                    }
                }
            }
        }
    }
}