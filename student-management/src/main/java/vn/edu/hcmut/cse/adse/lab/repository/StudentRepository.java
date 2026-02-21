package vn.edu.hcmut.cse.adse.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.hcmut.cse.adse.lab.entity.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
    // Tìm kiếm theo tên (cho Lab 3 và Lab 4)
    List<Student> findByNameContainingIgnoreCase(String name);
}