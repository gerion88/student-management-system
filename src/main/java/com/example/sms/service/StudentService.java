package com.example.sms.service;

import com.example.sms.domain.Student;
import com.example.sms.dto.StudentDto;
import com.example.sms.mapper.StudentMapper;
import com.example.sms.repo.GroupRepository;
import com.example.sms.repo.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class StudentService {

    private final StudentRepository repo;
    private final GroupRepository groups;
    private final StudentMapper mapper;

    public Page<StudentDto> find(Pageable p, String q, Long groupId) {
        Specification<Student> spec = Specification.where(null);
        if (q != null && !q.isBlank()) {
            String like = "%" + q.toLowerCase() + "%";
            spec = spec.and((root, cq, cb) -> cb.or(
                    cb.like(cb.lower(root.get("firstName")), like),
                    cb.like(cb.lower(root.get("lastName")), like)
            ));
        }
        if (groupId != null) {
            spec = spec.and((root, cq, cb) -> cb.equal(root.get("group").get("id"), groupId));
        }
        return repo.findAll(spec, p).map(mapper::toDto);
    }

    public StudentDto create(StudentDto dto) {
        Student e = mapper.toEntity(dto);
        // Group is linked in mapper; ensure exists if provided
        if (dto.groupId() != null) {
            groups.findById(dto.groupId()).orElseThrow();
        }
        return mapper.toDto(repo.save(e));
    }

    @Transactional(readOnly = true)
    public StudentDto get(Long id) {
        return mapper.toDto(repo.findById(id).orElseThrow());
    }

    public StudentDto update(Long id, StudentDto dto) {
        Student e = repo.findById(id).orElseThrow();
        e.setFirstName(dto.firstName());
        e.setLastName(dto.lastName());
        e.setBirthDate(dto.birthDate());
        e.setEmail(dto.email());
        e.setPhone(dto.phone());
        if (dto.groupId() == null) {
            e.setGroup(null);
        } else {
            e.setGroup(groups.findById(dto.groupId()).orElseThrow());
        }
        return mapper.toDto(repo.save(e));
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
