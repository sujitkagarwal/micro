package com.mkyong.scheduler;

/**
 * Created by sujitagarwal on 28/05/17.
 */
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RunScheduler {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job job;

    public void run() {

        try {
            JobParameters jobParameters =
                    new JobParametersBuilder()
                            .addLong("time",System.currentTimeMillis()).toJobParameters();
            JobExecution execution = jobLauncher.run(job, jobParameters);
            System.out.println("Exitus : " + execution.getStatus());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}