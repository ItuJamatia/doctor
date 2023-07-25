package com.gitExample.controller;

import com.gitExample.entity.Doctor;
import com.gitExample.payload.DoctorDto;
import com.gitExample.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    //http:localhost:8080/api/doctor
    @PostMapping
    public ResponseEntity<DoctorDto> postDoctor(@RequestBody DoctorDto doctorDto){
        DoctorDto dto=doctorService.postDoctor(doctorDto);
        return new ResponseEntity<>(dto,HttpStatus.CREATED);
    }
    @GetMapping
    public List<DoctorDto> getAllDoctors(){
    List<DoctorDto> dto=doctorService.getAllDoctors();
    return dto;
    }
    @PutMapping("/{id}")
    public ResponseEntity<DoctorDto> updateDoctor(@RequestBody DoctorDto dto, @PathVariable Long id){
       DoctorDto doctorDto=doctorService.updateDoctor(dto,id);
        return new ResponseEntity<>(doctorDto,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable Long id){
    doctorService.deleteDoctor(id);
    return new ResponseEntity<>("Doctor with id: " +id + "is deleted",HttpStatus.OK);
    }
}
