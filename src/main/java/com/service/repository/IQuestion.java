package com.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.models.Question;

@Repository
public interface IQuestion extends JpaRepository<Question, Integer>{

}
