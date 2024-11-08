package com.nitastefan.peak_planner;

import com.nitastefan.peak_planner.dao.IAppDAO;
import com.nitastefan.peak_planner.entity.Activity;
import com.nitastefan.peak_planner.entity.Plan;
import com.nitastefan.peak_planner.entity.enums.Type;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class PeakPlannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PeakPlannerApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner commandLineRunner(IAppDAO appDAO) {
//
//		return runner -> {
//			findActivityById(appDAO);
//		};
//	}
//
//	private void findPlansByType(IAppDAO appDAO) {
//
//		Type type = Type.ROUTINE;
//
//		List<Plan> tempPlans = appDAO.findPlansAndActivitiesByType(type);
//
//		System.out.println("the planes of type: " + type + ", are here: " + tempPlans);
////		System.out.println(tempPlans.get(0).getActivities()); // no access, lazy init
//	}
//
//	private void findActivityById(IAppDAO appDAO) {
//
//		Activity tempActivity = appDAO.findActivityById(1);
//		System.out.println("the activity: " + tempActivity);
//		System.out.println("the steps");
//		System.out.println(tempActivity.getSteps()); // no access, lazy init
//
//	}

}
