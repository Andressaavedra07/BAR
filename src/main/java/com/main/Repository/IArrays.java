package com.main.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.main.Model.arrays;

@Repository
public interface IArrays extends CrudRepository<arrays, Integer> {
	arrays findById(Long id);

}
