package com.spring.sneakzoneofflineboot.services;

import com.spring.sneakzoneofflineboot.dto.response.StaffResponse;
import com.spring.sneakzoneofflineboot.repositories.StaffRepository;
import com.spring.sneakzoneofflineboot.repositories.StaffResponseRepository;
import com.spring.sneakzoneofflineboot.utils.UtilityServices;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StaffResponseService implements UtilityServices<StaffResponse,String> {

    StaffResponseRepository staffResponseRepository;
    StaffRepository staffRepository;

    public Page<StaffResponse> filerStaffs(String staffCode, String fullName, String gender, String email, String isActive, String phoneNumber, Pageable pageable){
        return staffResponseRepository.filter( staffCode, fullName, gender,  email,  isActive,  phoneNumber,pageable);
    }

    @Override
    public List<StaffResponse> getAll() {
        return staffResponseRepository.findAll();
    }

    @Override
    public StaffResponse getById(String id) {
        return null;
    }

    @Override
    public StaffResponse save(StaffResponse entity) {
        return null;
    }

    @Override
    public StaffResponse update(StaffResponse entity, String id) {
        return null;
    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public Boolean findByName(String name) {
        return null;
    }

    @Override
    public StaffResponse getByName(String name) {
        return null;
    }
}
