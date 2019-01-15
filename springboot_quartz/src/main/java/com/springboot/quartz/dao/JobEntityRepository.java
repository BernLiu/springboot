package com.springboot.quartz.dao;

import org.springframework.data.repository.CrudRepository;

import com.springboot.quartz.entity.JobEntity;

public interface JobEntityRepository  extends CrudRepository<JobEntity, Long> {

	JobEntity getById(Integer id);
}
