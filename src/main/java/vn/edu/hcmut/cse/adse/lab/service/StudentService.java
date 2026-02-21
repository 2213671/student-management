package vn.edu.hcmut.cse.adse.lab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.hcmut.cse.adse.lab.entity.Student;
import vn.edu.hcmut.cse.adse.lab.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {
    
    @Autowired
    private StudentRepository repository;
    
    // Lấy tất cả
    public List<Student> getAll() {
        return repository.findAll();
    }
    
    // Lấy theo ID
    public Student getById(String id) {
        return repository.findById(id).orElse(null);
    }
    
    // Tìm theo tên
    public List<Student> searchByName(String keyword) {
        return repository.findByNameContainingIgnoreCase(keyword);
    }
    
    // THÊM MỚI: Lưu (thêm hoặc sửa)
    public Student save(Student student) {
        return repository.save(student);
    }
    
    // THÊM MỚI: Xóa theo ID
    public void delete(String id) {
        repository.deleteById(id);
    }
}