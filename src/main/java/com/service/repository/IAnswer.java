package com.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.models.Answer;

@Repository
public interface IAnswer extends JpaRepository<Answer, Integer> {

}
