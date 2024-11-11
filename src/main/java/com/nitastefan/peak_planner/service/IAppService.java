package com.nitastefan.peak_planner.service;

import com.nitastefan.peak_planner.entity.Activity;
import com.nitastefan.peak_planner.entity.Plan;
import com.nitastefan.peak_planner.entity.Step;
import com.nitastefan.peak_planner.entity.enums.Type;

import java.util.List;

public interface IAppService {

    List<Plan> findPlansByType(Type type);

    Activity findActivityById(int id);

    Plan persist(Plan thePlan);

    List<Plan> persist(List<Plan> thePlans);

    Plan update(Plan thePlan, int planId);

    Activity update(Activity theActivity, int activityId);

    Step persistStepForActivity(Step theStep, int activityId);

    Activity persistActivityForPlan(Activity theActivity, int planId);

    void deletePlanById(int id);

    void deleteExistingPlansOfType(Type theType);

    void deleteActivityById(int id);
}
