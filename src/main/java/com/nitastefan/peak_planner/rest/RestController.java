package com.nitastefan.peak_planner.rest;

import com.nitastefan.peak_planner.entity.Activity;
import com.nitastefan.peak_planner.entity.Plan;
import com.nitastefan.peak_planner.entity.Step;
import com.nitastefan.peak_planner.entity.enums.Type;
import com.nitastefan.peak_planner.service.IAppService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

    private IAppService appService;

    public RestController(IAppService appService) {
        this.appService = appService;
    }

    @GetMapping("/plans")
    public List<Plan> getPlansByType(@RequestParam("type") Type type) {

        return appService.findPlansAndActivitiesByType(type);
    }

    @GetMapping("/activities/{activityId}")
    public Activity findActivityById(@PathVariable int activityId) {

        Activity tempActivity = appService.findActivityById(activityId);

        System.out.println("the activity: " + tempActivity);
        System.out.println("its plan: " + tempActivity.getPlan());

        return tempActivity;
    }

    @PostMapping("/activities/{activityId}/steps")
    public void addStepForActivity(@RequestBody Step theStep, @PathVariable int activityId) {

        theStep.setId(0);

        appService.saveStepForActivity(theStep, activityId);
    }

    @PostMapping("/plans/{planId}/activities")
    public void addActivityForPlan(@RequestBody Activity theActivity, @PathVariable int planId) {

        theActivity.setId(0); // in case some id is added to JSON; this forces a save of new item

        appService.saveActivityForPlan(theActivity, planId);
    }

    @PostMapping("/plans")
    public Plan addPlan(@RequestBody Plan thePlan) {

        thePlan.setId(0);

        return appService.save(thePlan);
    }

    @PutMapping("/activities/{activityId}")
    public void updateActivityById(@RequestBody Activity theActivity, @PathVariable int activityId) {

        Activity oldActivity = appService.findActivityById(activityId);

        if (oldActivity == null)
            throw new RuntimeException("Activity with id " + activityId + " not found");

        theActivity.setId(activityId);
        theActivity.setPlan(oldActivity.getPlan());
        appService.save(theActivity);
    }

    @DeleteMapping("/plans/{planId}")
    public void deletePlanById(@PathVariable int planId) {

        appService.deletePlanById(planId);
    }

    @DeleteMapping("/activities/{activityId}")
    public void deleteActivityById(@PathVariable int activityId) {

        appService.deleteActivityById(activityId);
    }
}
