package org.springframework.samples.petclinic.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.Repositry.FeatureFlagRepository;
import org.springframework.samples.petclinic.model.FeatureFlag;
import org.springframework.stereotype.Service;

@Service
public class FeatureFlagService {
	
	@Autowired
	private FeatureFlagRepository repository;
	
	public boolean isEnabled(String featureName)
	{
		return repository.findByFeatureName(featureName)
				.map(FeatureFlag::isEnabled)
				.orElse(false);
	}
	

}
