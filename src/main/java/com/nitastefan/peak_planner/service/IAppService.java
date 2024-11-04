package com.nitastefan.peak_planner.service;

import com.nitastefan.peak_planner.entity.Activity;
import com.nitastefan.peak_planner.entity.Step;

import java.util.List;

public interface IAppService {

    Activity saveActivity(Activity theActivity);

    void saveStepForActivity(Step theStep, int activityId);

    void deleteActivityById(int id);
}
