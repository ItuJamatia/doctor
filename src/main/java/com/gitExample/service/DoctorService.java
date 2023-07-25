package com.gitExample.service;

import com.gitExample.payload.DoctorDto;

import java.util.List;

public interface DoctorService {
    DoctorDto postDoctor(DoctorDto doctorDto);

    List<DoctorDto> getAllDoctors();

    DoctorDto updateDoctor(DoctorDto dto, Long id);

    void deleteDoctor(Long id);
}
