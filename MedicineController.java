package com.example.medicalshop.controller;

import com.example.medicalshop.model.Medicine;
import com.example.medicalshop.repository.MedicineRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
@RequestMapping("/api/medicines")
@CrossOrigin(origins = "*")
public class MedicineController {
    private final MedicineRepository repository;
    public MedicineController(MedicineRepository repository){this.repository=repository;}
    @GetMapping public List<Medicine> all(@RequestParam(required=false) String search) {
        return (search == null || search.isBlank()) ? repository.findAll() : repository.findByNameContainingIgnoreCaseOrCategoryContainingIgnoreCase(search, search);
    }
    @GetMapping("/{id}") public Medicine one(@PathVariable Long id){return repository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Medicine not found"));}
    @PostMapping public Medicine create(@Valid @RequestBody Medicine medicine){medicine.setId(null); return repository.save(medicine);}
    @PutMapping("/{id}") public Medicine update(@PathVariable Long id,@Valid @RequestBody Medicine incoming){
        Medicine m=one(id); m.setName(incoming.getName());m.setCategory(incoming.getCategory());m.setManufacturer(incoming.getManufacturer());m.setPrice(incoming.getPrice());m.setStock(incoming.getStock());m.setExpiryDate(incoming.getExpiryDate());return repository.save(m);
    }
    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id){if(!repository.existsById(id)) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Medicine not found");repository.deleteById(id);}
}
