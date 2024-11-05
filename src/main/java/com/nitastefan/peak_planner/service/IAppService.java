package com.nitastefan.peak_planner.service;

import com.nitastefan.peak_planner.entity.Activity;
import com.nitastefan.peak_planner.entity.Plan;
import com.nitastefan.peak_planner.entity.Step;
import com.nitastefan.peak_planner.entity.enums.Type;

import java.util.List;

public interface IAppService {

    List<Plan> findPlansAndActivitiesByType(Type type);

    Activity findActivityById(int id);

    Plan save(Plan thePlan);

    Activity save(Activity theActivity);

    void saveStepForActivity(Step theStep, int activityId);

    void saveActivityForPlan(Activity theActivity, int planId);

    void deletePlanById(int id);

    void deleteActivityById(int id);
}
