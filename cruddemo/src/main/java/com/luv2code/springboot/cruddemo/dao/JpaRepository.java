package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;

public interface JpaRepository extends org.springframework.data.jpa.repository.JpaRepository<Employee, Integer> {

}
