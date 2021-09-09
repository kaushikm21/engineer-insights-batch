package com.udaan.sdlc.engineerinsights.batch.tasks;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface EngineerRepository extends JpaRepository<Engineer, Integer> {

  @Query(value = "Select NEW com.udaan.sdlc.engineerinsights.batch.tasks.Engineer " +
          "(e.id, count(p.engineer_id)) FROM Engineer e, PR p WHERE e.id = p.engineer_id group by e.id")
    List<Engineer> findTotalPRByEngineer();

  @Modifying
  @Transactional
  @Query("update Engineer e set e.total_pr_reviews= :total_pr_reviews where e.id= :id")
  void updateTotalPRsByEngineer(@Param("id") Integer id, @Param("total_pr_reviews") Long total_pr_reviews);
}