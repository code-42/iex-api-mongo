package net.ed.api.controller;

// source https://www.youtube.com/watch?v=lpcOSXWPXTk&list=PLmbC-xnvykcghOSOJ1ZF6ja3aOgZAgaMO&index=29

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.ed.api.entity.Chart;

@Repository
public interface ApiRepository extends CrudRepository<Chart, String> {

}
