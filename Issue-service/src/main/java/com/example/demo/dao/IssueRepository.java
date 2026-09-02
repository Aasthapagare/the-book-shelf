package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.IssueRecord;

public interface IssueRepository extends JpaRepository<IssueRecord, Integer> {

}
