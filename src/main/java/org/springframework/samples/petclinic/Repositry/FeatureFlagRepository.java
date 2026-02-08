package org.springframework.samples.petclinic.Repositry;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.samples.petclinic.model.FeatureFlag;
import org.springframework.stereotype.Repository;

@Repository
public interface FeatureFlagRepository extends JpaRepository<FeatureFlag,Long> 
{
Optional<FeatureFlag> findByFeatureName(String featureName);
	
}
