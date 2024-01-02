package com.springboot.backend.app.dwback.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.springboot.backend.app.dwback.models.entity.Dwback;

public interface DwbackDao extends CrudRepository<Dwback, Long> {

}
