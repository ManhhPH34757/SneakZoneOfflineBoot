package com.spring.sneakzoneofflineboot.services;


import com.spring.sneakzoneofflineboot.dto.response.StaffResponse;
import com.spring.sneakzoneofflineboot.entities.Staff;
import com.spring.sneakzoneofflineboot.enums.ErrorCode;
import com.spring.sneakzoneofflineboot.exceptions.AppException;
import com.spring.sneakzoneofflineboot.mapper.StaffMapper;
import com.spring.sneakzoneofflineboot.repositories.StaffRepository;
import com.spring.sneakzoneofflineboot.utils.UtilityServices;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StaffService implements UtilityServices<Staff, String> {
    StaffRepository staffRepository;
    StaffMapper staffMapper;

    public List<StaffResponse> getAllStaff() {
        List<StaffResponse> list = new ArrayList<>();
        staffRepository.findAll().forEach(element -> list.add(staffMapper.toStaffResponse(element)));
        return list;
    }

    public StaffResponse findById(String id) {
        if (!staffRepository.existsById(id)){
            throw new AppException(ErrorCode.USER_NOT_EXISTED);
        }
        return staffMapper.toStaffResponse(staffRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED)));
    }


    @Override
    public List<Staff> getAll() {
        return staffRepository.getAll();
    }

    @Override
    public Staff getById(String id) {
        return staffRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));
    }

    @Override
    public Staff save(Staff entity) {
        return staffRepository.save(entity);
    }

    @Override
    public Staff update(Staff entity, String id) {
        if (!staffRepository.existsById(id)) {
           throw new AppException(ErrorCode.USER_NOT_EXISTED);
        }
        entity.setId(id);
        return staffRepository.save(entity);
    }

    @Override
    public void deleteById(String id) {
        if (staffRepository.existsById(id)){
            throw new AppException(ErrorCode.USER_NOT_EXISTED);
        }
        staffRepository.deleteById(id);
    }

    @Override
    public Boolean findByName(String name) {
        return null;
    }

    @Override
    public Staff getByName(String name) {
        return null;
    }

    public Boolean findByStaffCode(String staffCode) {
        return staffRepository.existsByStaffCode(staffCode);
    }

    public Boolean findByEmail(String email) {
        return staffRepository.existsByEmail(email);
    }

    public Boolean findByPhoneNumber(String phoneNumber) {
        return staffRepository.existsByPhoneNumber(phoneNumber);
    }

    public Boolean findByUsername(String username) {
        return staffRepository.existsByUsername(username);
    }

}
