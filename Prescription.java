package com.example.medicalshop.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity @Table(name="prescriptions")
public class Prescription {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 private String customerName; private String customerEmail; @Column(length=1000) private String notes;
 private String fileName; private String status="PENDING"; private LocalDateTime submittedAt=LocalDateTime.now();
 public Prescription(){}
 public Long getId(){return id;} public void setId(Long id){this.id=id;}
 public String getCustomerName(){return customerName;} public void setCustomerName(String v){customerName=v;}
 public String getCustomerEmail(){return customerEmail;} public void setCustomerEmail(String v){customerEmail=v;}
 public String getNotes(){return notes;} public void setNotes(String v){notes=v;}
 public String getFileName(){return fileName;} public void setFileName(String v){fileName=v;}
 public String getStatus(){return status;} public void setStatus(String v){status=v;}
 public LocalDateTime getSubmittedAt(){return submittedAt;} public void setSubmittedAt(LocalDateTime v){submittedAt=v;}
}
