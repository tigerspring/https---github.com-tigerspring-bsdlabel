package org.bsd.label.repository;

import java.util.List;

import org.bsd.label.domain.RegistrationInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationInfoRepository extends CrudRepository<RegistrationInfo,Long>,JpaRepository<RegistrationInfo, Long> {

	public List<RegistrationInfo> findRegistrationInfoByregistrationNoLike(String registrationNo);
}
