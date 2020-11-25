package com.example.springbootbackend.repository;

import com.example.springbootbackend.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ResultsRepository extends JpaRepository<Result, Long> {
}
