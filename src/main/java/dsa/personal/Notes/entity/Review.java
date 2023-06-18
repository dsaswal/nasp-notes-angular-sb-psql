package dsa.personal.Notes.entity;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
public class Review {
    private static final Logger logger = LoggerFactory.getLogger(Review.class);
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)   
    private Long id;
    private Timestamp reviewedTime;
    private String reviewedStatus;
    
    public Review() {
    }
    
    public Review(String reviewedStatus) {
        this.reviewedStatus = reviewedStatus;
    }
    
    @PrePersist
    protected void onCreate() {
        reviewedTime = new Timestamp(System.currentTimeMillis());
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Timestamp getReviewedTime() {
        return reviewedTime;
    }
    public void setReviewedTime(Timestamp reviewedTime) {
        this.reviewedTime = reviewedTime;
    }
    public String getReviewedStatus() {
        return reviewedStatus;
    }
    public void setReviewedStatus(String reviewedStatus) {
        this.reviewedStatus = reviewedStatus;
    }
    
    
}
