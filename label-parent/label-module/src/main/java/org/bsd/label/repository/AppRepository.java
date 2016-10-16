package org.bsd.label.repository;

import org.bsd.label.domain.App;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRepository extends JpaRepository<App, Long> {

}
