package com.example.Calculator.domain.repository;

import com.example.Calculator.persistence.entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<Operation, Long> {
}
