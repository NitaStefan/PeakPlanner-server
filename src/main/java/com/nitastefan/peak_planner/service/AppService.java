package com.nitastefan.peak_planner.service;

import com.nitastefan.peak_planner.dao.IAppDAO;
import com.nitastefan.peak_planner.entity.Activity;
import com.nitastefan.peak_planner.entity.Plan;
import com.nitastefan.peak_planner.entity.Step;
import com.nitastefan.peak_planner.entity.enums.Type;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppService implements IAppService {

    private IAppDAO appDAO;

    public AppService(IAppDAO appDAO) {
        this.appDAO = appDAO;
    }

    @Override
    public List<Plan> findPlansByType(Type type) {
        return appDAO.findPlansByType(type);
    }

    @Override
    public Activity findActivityById(int id) {

        // if @JsonIgnore, retrieve based on the getter
        return appDAO.findActivityById(id);
    }

    @Override
    public Plan persist(Plan thePlan) {

        thePlan.setId(0);

        return appDAO.save(thePlan);
    }

    @Override
    public List<Plan> persist(List<Plan> thePlans) {

        List<Plan> savedPlans = new ArrayList<>();

        for (Plan plan : thePlans) {
            plan.setId(0);
            savedPlans.add(appDAO.save(plan));
        }

        return savedPlans;
    }

    @Override
    public Plan update(Plan newPlan, int oldPlanId) {

        Plan oldPlan = appDAO.findPlanById(oldPlanId);

        if (oldPlan == null)
            throw new RuntimeException("Plan with id " + oldPlanId + " not found");

        newPlan.setId(oldPlanId);

        return appDAO.save(newPlan);
    }

    @Override
    public Activity update(Activity newActivity, int oldActivityId) {

        Activity oldActivity = findActivityById(oldActivityId);

        if (oldActivity == null)
            throw new RuntimeException("Activity with id " + oldActivityId + " not found");

        newActivity.setId(oldActivityId);
        newActivity.setPlan(oldActivity.getPlan());
        // the steps remain associated with that activity's id

        return appDAO.save(newActivity);
    }

    @Override
    public Step persistStepForActivity(Step theStep, int activityId) {

        theStep.setId(0);

        theStep.setActivity(appDAO.findActivityById(activityId));

        return appDAO.save(theStep);
    }

    @Override
    public Activity persistActivityForPlan(Activity theActivity, int planId) {

        theActivity.setId(0);

        theActivity.setPlan(appDAO.findPlanById(planId));

        return appDAO.save(theActivity);
    }

    @Override
    public void deletePlanById(int id) {

        appDAO.deletePlanById(id);
    }

    @Override
    public void deleteExistingPlansOfType(Type theType) {

        List<Plan> thePlans = findPlansByType(theType);

        // test lazy loading after

        for (Plan plan : thePlans)
            deletePlanById(plan.getId());

    }

    @Override
    public void deleteActivityById(int id) {

        appDAO.deleteActivityById(id);
    }
}
