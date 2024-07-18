package in.webearn.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.webearn.entity.Plan;

public interface PlanRepo  extends JpaRepository<Plan,Integer>{

}
