package com.udaan.sdlc.engineerinsights.batch.tasks;




import javax.persistence.*;

@Entity
public class PR {


    @Id
    @GeneratedValue
    private Integer id;
    private Integer review_duration_sec;
    private String review_date;
    private String comments;
    private Integer misses;
    @ManyToOne(fetch = FetchType.LAZY)
    private Engineer engineer;
    @Column(name = "engineer_id", insertable = false, updatable = false)
    private int engineer_id;
public PR(){}
    public PR(Integer id, String comments){
    this.id=id;
    this.comments=comments;
    }
    public PR(Integer id, Integer review_duration_sec, String review_date, String comments, Integer misses, Integer engineer_id) {

        this.id = id;
        this.review_duration_sec = review_duration_sec;
        this.review_date = review_date;
        this.comments = comments;
        this.misses = misses;
       Engineer engineer = new Engineer(engineer_id);
        this.setEngineer(engineer);
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getReview_duration_sec() {
        return review_duration_sec;
    }

    public void setReview_duration_sec(Integer review_duration_sec) {
        this.review_duration_sec = review_duration_sec;
    }

    public String getReview_date() {
        return review_date;
    }

    public void setReview_date(String review_date) {
        this.review_date = review_date;
    }


    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Integer getMisses() {
        return misses;
    }

    public void setMisses(Integer misses) {
        this.misses = misses;
    }


    public int getEngineer_id() {
        return engineer_id;
    }

    public void setEngineer_id(int engineer_id) {
        this.engineer_id = engineer_id;
    }


    public Engineer getEngineer() {
        return engineer;
    }

    public void setEngineer(Engineer engineer) {
        this.engineer = engineer;
    }

    @Override
    public String toString() {
        return "PRDetails{" +
                ", review_duration_sec=" + review_duration_sec +
                ", review_date=" + review_date +
                ", comments='" + comments + '\'' +
                ", misses=" + misses +
                '}';
    }
}
