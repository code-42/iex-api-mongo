package net.ed.api.controller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.ed.api.entity.Chart;

@Repository
public interface ApiRepository extends CrudRepository<Chart, String> {

}
