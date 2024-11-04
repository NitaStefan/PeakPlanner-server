package com.nitastefan.peak_planner.service;

import com.nitastefan.peak_planner.dao.IAppDAO;
import com.nitastefan.peak_planner.entity.Activity;
import com.nitastefan.peak_planner.entity.Step;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppService implements IAppService {

    private IAppDAO appDAO;

    public AppService(IAppDAO appDAO) {
        this.appDAO = appDAO;
    }

    @Override
    public Activity saveActivity(Activity theActivity) {

        return appDAO.save(theActivity);
    }

    @Override
    public void saveStepForActivity(Step theStep, int activityId) {

        Activity theActivity = appDAO.findActivityById(activityId);
        System.out.println("For activity: " + theActivity);
        System.out.println("Actual steps: " + theActivity.getSteps());

        theActivity.addStep(theStep);
        System.out.println("Updating activity: " + theActivity);
        System.out.println("Actual steps: " + theActivity.getSteps());

        appDAO.save(theActivity);
    }

    @Override
    public void deleteActivityById(int id) {

        appDAO.deleteActivityById(id);
    }
}
