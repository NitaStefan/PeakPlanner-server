package com.nitastefan.peak_planner.rest;

import com.nitastefan.peak_planner.entity.Activity;
import com.nitastefan.peak_planner.entity.Plan;
import com.nitastefan.peak_planner.entity.Step;
import com.nitastefan.peak_planner.entity.enums.Type;
import com.nitastefan.peak_planner.service.IAppService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@CrossOrigin(origins = "http://localhost:5173/")
@RequestMapping("/api")
public class RestController {

    private IAppService appService;

    public RestController(IAppService appService) {
        this.appService = appService;
    }

    @GetMapping("/plans")
    public List<Plan> getPlansByType(@RequestParam("type") Type type) {

        return appService.findPlansByType(type);
    }

    @GetMapping("/activities/{activityId}")
    public Activity findActivityById(@PathVariable int activityId) {

        return appService.findActivityById(activityId);
    }

    @PostMapping("/activities/{activityId}/steps")
    public Step addStepForActivity(@RequestBody Step theStep, @PathVariable int activityId) {

        return appService.persistStepForActivity(theStep, activityId);
    }

    @PostMapping("/plans/{planId}/activities")
    public Activity addActivityForPlan(@RequestBody Activity theActivity, @PathVariable int planId) {

        return appService.persistActivityForPlan(theActivity, planId);
    }

    @PostMapping("/plans")
    public Plan addPlan(@RequestBody Plan thePlan) {

        return appService.persist(thePlan);
    }

    @PostMapping("/plans/bulk")
    public List<Plan> addRoutinePlans(@RequestBody List<Plan> thePlans) {

        appService.deleteExistingPlansOfType(Type.ROUTINE);

        return appService.persist(thePlans);
    }

    @PutMapping("/plans/{oldPlanId}")
    public Plan updatePlanById(@RequestBody Plan newPlan, @PathVariable int oldPlanId){

        return appService.update(newPlan, oldPlanId);
    }

    @PutMapping("/activities/{oldActivityId}")
    public Activity updateActivityById(@RequestBody Activity newActivity, @PathVariable int oldActivityId) {

        return appService.update(newActivity, oldActivityId);
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
