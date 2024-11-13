package com.nitastefan.peak_planner.dao;

import com.nitastefan.peak_planner.entity.Activity;
import com.nitastefan.peak_planner.entity.Plan;
import com.nitastefan.peak_planner.entity.Step;
import com.nitastefan.peak_planner.entity.enums.Type;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AppDAO implements IAppDAO {

    private EntityManager entityManager;

    public AppDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public Plan save(Plan thePlan) {

        return entityManager.merge(thePlan);
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
    public List<Plan> findPlansByType(Type type) {

        TypedQuery<Plan> query = entityManager.createQuery(
                "SELECT p FROM Plan p "
                   + "WHERE p.type = :planType", Plan.class);

        query.setParameter("planType", type);

        return query.getResultList();
    }

    @Override
    public Plan findPlanById(int id) {

        return entityManager.find(Plan.class, id);
    }

    @Override
    public Activity findActivityById(int id) {

        return entityManager.find(Activity.class, id);
    }

    @Override
    public Step findStepById(int id) {
        return entityManager.find(Step.class, id);
    }

    @Override
    @Transactional
    public void deletePlanById(int id) {

        entityManager.remove(findPlanById(id));
    }

    @Override
    @Transactional
    public void deleteActivityById(int id) {

        entityManager.remove(findActivityById(id));
    }
}
