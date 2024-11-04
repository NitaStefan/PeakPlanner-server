package com.nitastefan.peak_planner.rest;

import com.nitastefan.peak_planner.entity.Activity;
import com.nitastefan.peak_planner.entity.Step;
import com.nitastefan.peak_planner.service.IAppService;
import org.springframework.web.bind.annotation.*;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

    private IAppService appService;

    public RestController(IAppService appService) {
        this.appService = appService;
    }

    @PostMapping("/activities/{activityId}/steps")
    public void addStepForActivity(@RequestBody Step theStep, @PathVariable int activityId) {

        appService.saveStepForActivity(theStep, activityId);
    }

    @PostMapping("/activities")
    public Activity addActivity(@RequestBody Activity theActivity) {

        theActivity.setId(0); // in case some id is added to JSON; this forces a save of new item

        return appService.saveActivity(theActivity);
    }

    @DeleteMapping("/activities/{activityId}")
    public void deleteActivityById(@PathVariable int activityId) {

        appService.deleteActivityById(activityId);
    }
}
