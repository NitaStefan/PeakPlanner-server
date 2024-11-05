package com.nitastefan.peak_planner.service;

import com.nitastefan.peak_planner.dao.IAppDAO;
import com.nitastefan.peak_planner.entity.Activity;
import com.nitastefan.peak_planner.entity.Plan;
import com.nitastefan.peak_planner.entity.Step;
import com.nitastefan.peak_planner.entity.enums.Type;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppService implements IAppService {

    private IAppDAO appDAO;

    public AppService(IAppDAO appDAO) {
        this.appDAO = appDAO;
    }

    @Override
    public List<Plan> findPlansAndActivitiesByType(Type type) {
        return appDAO.findPlansAndActivitiesByType(type);
    }

    @Override
    public Activity findActivityById(int id) {
        return appDAO.findActivityById(id);
    }

    @Override
    public Plan save(Plan thePlan) {

        return appDAO.save(thePlan);
    }

    @Override
    public Activity save(Activity theActivity) {
        return appDAO.save(theActivity);
    }

    @Override
    public void saveStepForActivity(Step theStep, int activityId) {

        theStep.setActivity(appDAO.findActivityById(activityId));

        appDAO.save(theStep);
    }

    @Override
    public void saveActivityForPlan(Activity theActivity, int planId) {

        theActivity.setPlan(appDAO.findPlanById(planId));

        appDAO.save(theActivity);
    }

    @Override
    public void deletePlanById(int id) {

        appDAO.deletePlanById(id);
    }

    @Override
    public void deleteActivityById(int id) {

        appDAO.deleteActivityById(id);
    }
}
