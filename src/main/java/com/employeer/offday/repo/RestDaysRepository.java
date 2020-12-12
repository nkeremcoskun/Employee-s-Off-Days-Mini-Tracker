package com.employeer.offday.repo;

import com.employeer.offday.entity.Employees;
import com.employeer.offday.entity.RestDays;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestDaysRepository extends JpaRepository<RestDays, Integer> {

}
