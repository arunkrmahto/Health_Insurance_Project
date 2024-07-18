package in.webearn.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import in.webearn.entity.Plan;
import in.webearn.entity.PlanCategory;
import in.webearn.repo.PlanCatogoryRepo;
import in.webearn.repo.PlanRepo;

public class PlanServiceImpl implements PlanService {

	@Autowired
	private PlanRepo planRepo;
	
	@Autowired
	private PlanCatogoryRepo planCategoryRepo;
	@Override
	public Map<Integer, String> getPlanCategories() {
		List<PlanCategory> categories = planCategoryRepo.findAll();
		Map<Integer, String> CategoryMap=new HashMap<>();
		
		categories.forEach(Category->{
			CategoryMap.put(Category.getCategoryId(),Category.getCategoryName());
			});
		return CategoryMap;
	}

	@Override
	public boolean savePlan(Plan plan) {
		Plan save = planRepo.save(plan);
		return save.getPlanId()!=null;
	}

	@Override
	public List<Plan> getAllPlans() {
		
		return planRepo.findAll();
	}

	@Override
	public Plan getPlanById(Integer planId) {
		Optional<Plan> findById = planRepo.findById(planId);
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public boolean updatePlan(Plan plan) {
		 planRepo.save(plan);
		return plan.getPlanId()!=null;
	}

	@Override
	public boolean deletePlanById(Integer planId) {
		boolean status=false;
		try {
			planRepo.deleteById(planId);
			status =true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean planStatusChange(Integer planId, String status) {
		
		return false;
	}

}
