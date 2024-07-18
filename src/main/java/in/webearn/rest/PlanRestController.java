package in.webearn.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import in.webearn.entity.Plan;
import in.webearn.service.PlanService;

public class PlanRestController {

	@Autowired
	private PlanService planService;
	
	@GetMapping("/categories")
	public ResponseEntity<Map<Integer,String>> planCategories(){
		Map<Integer,String> planCategories = planService.getPlanCategories();
		return new ResponseEntity<Map<Integer,String>>(planCategories,HttpStatus.OK);
	}
	
	@PostMapping("/plan")
	public ResponseEntity<String> savePlan( @RequestBody Plan plan){
		String responseMsg="";
	boolean savePlan = planService.savePlan(plan);
	if(savePlan) {
		responseMsg="plan Saved";
	}else{
		responseMsg=" plan not saved";
	}
	return new ResponseEntity<String>(responseMsg,HttpStatus.CREATED);	
	}
	@GetMapping("/plan")
	public ResponseEntity<List<Plan>> plans(){
		List<Plan> allPlans = planService.getAllPlans();
		return new ResponseEntity<List<Plan>>(allPlans,HttpStatus.OK);
	}
	@GetMapping("/plan/{planId}")
	public ResponseEntity<Plan> editPlan(@PathVariable Integer planId){
		Plan planById = planService.getPlanById(planId);
		return new ResponseEntity<Plan>(planById,HttpStatus.OK);
		
	}
	@PutMapping("/plan")
	public ResponseEntity<String> updatePlan(@RequestBody Plan plan){
		boolean updatePlan = planService.updatePlan(plan);
		String msg="";
		if(updatePlan) {
			msg="record deleted";
		}else {
			msg="record not deleted";
		}
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}

	
	@DeleteMapping("/plan/{planId}")
	public ResponseEntity<String> deletePlan(@PathVariable Integer planId){
		boolean deletePlanById = planService.deletePlanById(planId);
		String msg="";
		if(deletePlanById) {
			msg="record deleted";
		}else {
			msg="record not deleted";
		}
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
	
	@PutMapping("/status-change/{planId}/{status}")
	public ResponseEntity<String> statusChanged(@PathVariable Integer planId,@PathVariable String status){
		boolean statusChange = planService.planStatusChange(planId, status);
		String msg="";
		if(statusChange) {
			msg="record deleted";
		}else {
			msg="record not deleted";
		}
		return new ResponseEntity<>(msg,HttpStatus.OK);

		}
}
