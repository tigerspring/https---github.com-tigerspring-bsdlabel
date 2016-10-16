package org.bsd.label.repository;

import org.bsd.label.domain.SkuInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkuInfoRepository extends JpaRepository<SkuInfo, Long>,JpaSpecificationExecutor<SkuInfo>,CrudRepository<SkuInfo, Long>{

}
