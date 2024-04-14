package com.oumayma.student_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.oumayma.student_service.model.Enrolment;
import com.oumayma.student_service.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EnrolmentRepository extends JpaRepository<Enrolment, Long> {
    List<Enrolment> findByUser(User user);

    @Query("SELECT e.course.id FROM Enrolment e WHERE e.user.studentId = :studentId")
    List<Long> findEnrolledCourseIdsByStudentId(@Param("studentId") String studentId);
}
