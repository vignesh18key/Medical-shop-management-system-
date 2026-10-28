package com.example.medicalshop.repository;
import com.example.medicalshop.model.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PrescriptionRepository extends JpaRepository<Prescription,Long> {}
