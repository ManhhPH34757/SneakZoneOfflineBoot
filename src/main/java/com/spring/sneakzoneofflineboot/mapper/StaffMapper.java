package com.spring.sneakzoneofflineboot.mapper;

import com.spring.sneakzoneofflineboot.dto.response.StaffResponse;
import com.spring.sneakzoneofflineboot.entities.Staff;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StaffMapper {
    StaffResponse toStaffResponse(Staff staff);
}
