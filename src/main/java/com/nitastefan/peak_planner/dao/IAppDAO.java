package com.nitastefan.peak_planner.dao;

import com.nitastefan.peak_planner.entity.Activity;
import com.nitastefan.peak_planner.entity.Plan;
import com.nitastefan.peak_planner.entity.Step;
import com.nitastefan.peak_planner.entity.enums.Type;

import java.util.List;

public interface IAppDAO {

    List<Plan> findPlansByType(Type type);

    Plan findPlanById(int id);

    Activity findActivityById(int id);

    Step findStepById(int id);

    Plan save(Plan thePlan);

    Activity save(Activity theActivity);

    Step save(Step theStep);

    void deletePlanById(int id);

    void deleteActivityById(int id);
}
