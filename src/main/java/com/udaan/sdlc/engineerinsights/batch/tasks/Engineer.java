package com.udaan.sdlc.engineerinsights.batch.tasks;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@EnableAutoConfiguration
@Entity

public class Engineer {
    @Id
    private Integer id;
    private int bravo;
    private String joined;
    private String name;
    private String git_id;
    private double average_review_time;
    private Long total_pr_reviews;
    private boolean active;

    @OneToMany(mappedBy = "engineer")
    private List <PR> prs;

    public Engineer(){}
    public Engineer(Integer id){
        this.id=id;
    }
    public Engineer(Integer id, Long total_pr_reviews){this.id=id; this.total_pr_reviews=total_pr_reviews;}

    public Engineer(Integer id, int bravo, String joined, String name, String git_id, double average_review_time, Long total_pr_reviews, boolean active) {
        this.id = id;
        this.bravo = bravo;
        this.joined = joined;
        this.name = name;
        this.git_id=git_id;
        this.average_review_time=average_review_time;
        this.total_pr_reviews=total_pr_reviews;
        this.active=active;
    }
    public double getAverage_review_time() {
        return average_review_time;
    }

    public void setAverage_review_time(double average_review_time) {
        this.average_review_time = average_review_time;
    }

    public Long getTotal_pr_reviews() {
        return total_pr_reviews;
    }

    public void setTotal_pr_reviews(Long total_pr_reviews) {
        this.total_pr_reviews = total_pr_reviews;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBravo() {
        return bravo;
    }

    public String getJoined() {
        return joined;
    }
    public String getGit_id() {return git_id;}

    public void setGit_id(String git_id) {this.git_id = git_id;}

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBravo(int bravo) {
        this.bravo = bravo;
    }

    public void setJoined(String joined) {
        this.joined = joined;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<PR> getPrs() {return prs;}

    public void setPrs(List<PR> prs) {this.prs = prs;}

    @Override
    public String toString() {
        return "Engineer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bravo=" + bravo +
                ", git_id=" + git_id +
                ", joined=" + joined +
                "total_pr_reviews=" + total_pr_reviews+
                "average_review_time=" +average_review_time+
                '}';
    }
}
