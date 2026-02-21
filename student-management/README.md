# Student Management System - Lab 1

## Nhóm thực hiện

- [Tên sinh viên 1] - [MSSV]
- [Tên sinh viên 2] - [MSSV] (nếu có)

## Hướng dẫn chạy dự án

1. **Yêu cầu**: JDK 17+, Maven (hoặc dùng Maven Wrapper có sẵn)

2. **Các bước chạy**:

   ```bash
   # Clone repository
   git clone [url-repo-của-nhóm]
   cd student-management

   # Chạy ứng dụng
   ./mvnw spring-boot:run
   ```

# Câu hỏi lý thuyết

Lab 1 2. Tại sao Database lại chặn thao tác này?
Vì cột id được định nghĩa là PRIMARY KEY, có ràng buộc UNIQUE tự động. Mỗi bản ghi trong bảng phải có giá trị khóa chính duy nhất để đảm bảo tính toàn vẹn dữ liệu và phục vụ cho việc truy xuất nhanh.

    3. Database có báo lỗi không? Từ đó suy nghĩ xem sự thiếu chặt chẽ này ảnh hưởng gì khi code Java đọc dữ liệu lên?
    Trong SQLite mặc định, không báo lỗi vì cột name chưa có ràng buộc NOT NULL. Điều này có thể gây ra lỗi NullPointerException khi code Java đọc dữ liệu nếu không kiểm tra null.

    4. Tại sao mỗi lần tắt ứng dụng và chạy lại, dữ liệu cũ trong Database lại bị mất hết?
    Do cấu hình spring.jpa.hibernate.ddl-auto=create trong file application.properties. Cấu hình này bảo Hibernate xóa schema cũ và tạo mới mỗi khi ứng dụng khởi động. Trong môi trường production, nên dùng update hoặc none để giữ lại dữ liệu.
