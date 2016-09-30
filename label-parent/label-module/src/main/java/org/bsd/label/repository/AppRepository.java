package org.bsd.label.repository;

import org.bsd.label.domain.App;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRepository extends JpaRepository<App, Integer> {

}
