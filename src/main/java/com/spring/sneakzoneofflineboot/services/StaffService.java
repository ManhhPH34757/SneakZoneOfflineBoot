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
        if (!staffRepository.existsById(Integer.valueOf(id))){
            throw new AppException(ErrorCode.USER_NOT_EXISTED);
        }
        return staffMapper.toStaffResponse(staffRepository.findById(Integer.valueOf(id)).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED)));
    }


    @Override
    public List<Staff> getAll() {
        return staffRepository.findAll();
    }

    @Override
    public Staff getById(String id) {
        return null;
    }

    @Override
    public Staff save(Staff entity) {
        return null;
    }

    @Override
    public Staff update(Staff entity, String id) {
        return null;
    }

    @Override
    public void deleteById(String id) {

    }
}
