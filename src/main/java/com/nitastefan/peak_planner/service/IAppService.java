package com.nitastefan.peak_planner.service;

import com.nitastefan.peak_planner.entity.Activity;
import com.nitastefan.peak_planner.entity.Plan;
import com.nitastefan.peak_planner.entity.Step;
import com.nitastefan.peak_planner.entity.enums.Type;

import java.util.List;

public interface IAppService {

    List<Plan> findPlansByType(Type type);

    Activity findActivityById(int id);

    Plan save(Plan thePlan);

    List<Plan> save(List<Plan> thePlans);

    Activity save(Activity theActivity);

    void saveStepForActivity(Step theStep, int activityId);

    void saveActivityForPlan(Activity theActivity, int planId);

    void deletePlanById(int id);

    void deleteExistingPlansOfType(Type theType);

    void deleteActivityById(int id);
}
