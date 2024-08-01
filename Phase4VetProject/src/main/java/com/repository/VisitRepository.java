package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Visit;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Long>{

}
