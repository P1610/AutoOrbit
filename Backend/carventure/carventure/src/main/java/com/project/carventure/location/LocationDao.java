package com.project.carventure.location;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationDao extends JpaRepository<Location, Integer> {

	Location findFirstByOrderByIdAsc();

}
