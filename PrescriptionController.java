package com.example.medicalshop.controller;
import com.example.medicalshop.model.Prescription;
import com.example.medicalshop.repository.PrescriptionRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
@RestController @RequestMapping("/api/prescriptions") @CrossOrigin(origins="*")
public class PrescriptionController {
 private final PrescriptionRepository repository;
 public PrescriptionController(PrescriptionRepository repository){this.repository=repository;}
 @GetMapping public List<Prescription> all(){return repository.findAll();}
 @PostMapping public Prescription submit(@RequestBody Prescription p){p.setId(null);p.setStatus("PENDING");return repository.save(p);}
 @PatchMapping("/{id}/status") public Prescription status(@PathVariable Long id,@RequestParam String value){
  if(!List.of("PENDING","VERIFIED","REJECTED").contains(value.toUpperCase())) throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Status must be PENDING, VERIFIED, or REJECTED");
  Prescription p=repository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Prescription not found"));p.setStatus(value.toUpperCase());return repository.save(p);
 }
}
