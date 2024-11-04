package com.nitastefan.peak_planner.dao;

import com.nitastefan.peak_planner.entity.Activity;
import com.nitastefan.peak_planner.entity.Step;

public interface IAppDAO {

    Activity save(Activity theActivity);

    Step save(Step theStep);

    Activity findActivityById(int id);

    void deleteActivityById(int id);
}
