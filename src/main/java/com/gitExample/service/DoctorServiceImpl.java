package com.gitExample.service;

import com.gitExample.entity.Doctor;
import com.gitExample.payload.DoctorDto;
import com.gitExample.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService{

    @Autowired
    private DoctorRepository doctorRepository;


    @Override
    public DoctorDto postDoctor(DoctorDto doctorDto) {
        Doctor doctor= mapToEntity(doctorDto);

       Doctor saved= doctorRepository.save(doctor);
        return mapToDto(saved);
    }

    @Override
    public List<DoctorDto> getAllDoctors() {
        List<Doctor> doctorList=doctorRepository.findAll();
        return doctorList.stream().map(n->mapToDto(n)).collect(Collectors.toList());

    }

    @Override
    public DoctorDto updateDoctor(DoctorDto dto, Long id) {
        Doctor doctor=doctorRepository.findById(id).orElseThrow(
                ()->new RuntimeException("Id not found")
        );
        doctor.setName(dto.getName());
        doctor.setEmail(dto.getEmail());
        Doctor d=doctorRepository.save(doctor);
        return mapToDto(d);
    }

    @Override
    public void deleteDoctor(Long id) {
       Doctor doctor= doctorRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Id not found")
        );
        doctorRepository.deleteById(id);
    }

    private Doctor mapToEntity(DoctorDto doctorDto) {
        Doctor doctor=new Doctor();
        doctor.setId(doctorDto.getId());
        doctor.setName(doctorDto.getName());
        doctor.setEmail(doctorDto.getEmail());
        return doctor;
    }

    private DoctorDto mapToDto(Doctor saved) {
        DoctorDto dto=new DoctorDto();
        dto.setId(saved.getId());
        dto.setName(saved.getName());
        dto.setEmail(saved.getEmail());
        return dto;
    }
}
