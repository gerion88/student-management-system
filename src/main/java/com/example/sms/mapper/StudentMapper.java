package com.example.sms.mapper;

import com.example.sms.domain.Group;
import com.example.sms.domain.Student;
import com.example.sms.dto.StudentDto;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    @Mapping(target = "group", ignore = true)
    Student toEntity(StudentDto dto);

    @Mapping(target = "groupId", source = "group.id")
    StudentDto toDto(Student entity);

    @AfterMapping
    default void linkGroup(@MappingTarget Student student, StudentDto dto) {
        if (dto.groupId() != null) {
            student.setGroup(Group.builder().id(dto.groupId()).build());
        } else {
            student.setGroup(null);
        }
    }
}
