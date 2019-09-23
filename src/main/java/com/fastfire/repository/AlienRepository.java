package com.fastfire.repository;

import org.springframework.data.repository.CrudRepository;

import com.fastfire.bean.Alien;

public interface AlienRepository extends CrudRepository<Alien, Integer>
{

}
