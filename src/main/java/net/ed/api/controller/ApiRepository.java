package net.ed.api.controller;

// source https://www.youtube.com/watch?v=lpcOSXWPXTk&list=PLmbC-xnvykcghOSOJ1ZF6ja3aOgZAgaMO&index=29
// https://www.callicoder.com/spring-boot-rest-api-tutorial-with-mysql-jpa-hibernate/

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import net.ed.api.entity.Chart;
import net.ed.api.entity.Stocks;

@Repository
public interface ApiRepository extends JpaRepository<Stocks, Long> {
	
}
