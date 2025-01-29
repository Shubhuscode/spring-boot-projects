package com.pinnacle.taskmanager.repository;


import com.pinnacle.taskmanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
