package com.example.springbootbackend.repository;

import com.example.springbootbackend.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultsRepository extends JpaRepository<Result, Long> {
}