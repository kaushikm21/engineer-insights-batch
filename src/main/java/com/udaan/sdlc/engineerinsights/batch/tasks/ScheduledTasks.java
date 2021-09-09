package com.udaan.sdlc.engineerinsights.batch.tasks;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    @Autowired
    EngineerRepository engineerRepository;
    @Scheduled(fixedRate = 50000)
    public void updatePRReviewCountByEngineer() {
        List<Engineer> engineerList = engineerRepository.findTotalPRByEngineer();
        for (Engineer engineer : engineerList) {
            engineerRepository.updateTotalPRsByEngineer(engineer.getId(),engineer.getTotal_pr_reviews());
        }

    }
}
