package net.ed.api.controller;

import org.springframework.data.repository.CrudRepository;

import net.ed.api.entity.Chart;

public interface ApiRepository extends CrudRepository<Chart, String> {

}
