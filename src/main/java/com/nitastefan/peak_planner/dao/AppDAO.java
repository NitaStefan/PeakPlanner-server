package com.nitastefan.peak_planner.dao;

import com.nitastefan.peak_planner.entity.Activity;
import com.nitastefan.peak_planner.entity.Step;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AppDAO implements IAppDAO {

    private EntityManager entityManager;

    public AppDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public Activity save(Activity theActivity) {

        // if id = 0 it does not exist and a new entry is added, else update existing entry
        return entityManager.merge(theActivity);
    }

    @Override
    @Transactional
    public Step save(Step theStep) {

        return entityManager.merge(theStep);
    }

    @Override
    public Activity findActivityById(int id) {

        return entityManager.find(Activity.class, id);
    }

    @Override
    @Transactional
    public void deleteActivityById(int id) {

        entityManager.remove(findActivityById(id));
    }
}
