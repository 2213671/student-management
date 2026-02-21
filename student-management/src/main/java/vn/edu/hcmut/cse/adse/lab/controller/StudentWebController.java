package vn.edu.hcmut.cse.adse.lab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import vn.edu.hcmut.cse.adse.lab.entity.Student;
import vn.edu.hcmut.cse.adse.lab.service.StudentService;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentWebController {

    @Autowired
    private StudentService service;

    // ===== 1. TRANG DANH SÁCH (List View) =====
    // URL: /students
    // Yêu cầu: Hiển thị danh sách + ô tìm kiếm
    @GetMapping
    public String getAllStudents(@RequestParam(required = false) String keyword, Model model) {
        List<Student> students;
        
        if (keyword != null && !keyword.isEmpty()) {
            students = service.searchByName(keyword);
            model.addAttribute("keyword", keyword);
        } else {
            students = service.getAll();
        }
        
        model.addAttribute("dsSinhVien", students);
        return "students";
    }

    // ===== 2. TRANG CHI TIẾT (Detail View) =====
    // URL: /students/{id}
    @GetMapping("/{id}")
    public String getStudentById(@PathVariable String id, Model model) {
        Student student = service.getById(id);
        model.addAttribute("student", student);
        return "student-detail";
    }

    // ===== 3. TRANG THÊM MỚI =====
    // URL: /students/new
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("student", new Student());
        return "student-form";
    }

    // ===== 4. TRANG CHỈNH SỬA =====
    // URL: /students/edit/{id}
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable String id, Model model) {
        Student student = service.getById(id);
        model.addAttribute("student", student);
        return "student-form";
    }

    // ===== 5. XỬ LÝ LƯU (Thêm mới hoặc Cập nhật) =====
    // URL: /students/save (POST)
    @PostMapping("/save")
    public String saveStudent(@ModelAttribute Student student, RedirectAttributes redirectAttributes) {
        service.save(student);
        redirectAttributes.addFlashAttribute("message", "Lưu thành công!");
        return "redirect:/students";
    }

    // ===== 6. XỬ LÝ XÓA =====
    // URL: /students/delete/{id}
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable String id, RedirectAttributes redirectAttributes) {
        service.delete(id);
        redirectAttributes.addFlashAttribute("message", "Xóa thành công!");
        return "redirect:/students";
    }
}