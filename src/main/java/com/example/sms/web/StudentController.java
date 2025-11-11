package com.example.sms.web;

import com.example.sms.dto.StudentDto;
import com.example.sms.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;

    @GetMapping
    public Page<StudentDto> list(@PageableDefault(size = 20) Pageable pageable,
                                 @RequestParam(required = false) String q,
                                 @RequestParam(required = false) Long groupId) {
        return service.find(pageable, q, groupId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentDto create(@Valid @RequestBody StudentDto dto) {
        return service.create(dto);
    }

    @GetMapping("/{id}")
    public StudentDto get(@PathVariable Long id) {
        return service.get(id);
    }

    @PutMapping("/{id}")
    public StudentDto update(@PathVariable Long id, @Valid @RequestBody StudentDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
