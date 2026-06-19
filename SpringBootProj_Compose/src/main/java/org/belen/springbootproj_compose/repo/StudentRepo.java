package org.belen.springbootproj_compose.repo;

import org.belen.springbootproj_compose.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo  extends JpaRepository<Student,Integer> {
}
