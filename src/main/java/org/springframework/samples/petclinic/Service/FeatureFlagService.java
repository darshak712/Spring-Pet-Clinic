package org.springframework.samples.petclinic.Service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.samples.petclinic.Repositry.FeatureFlagRepository;
import org.springframework.samples.petclinic.model.FeatureFlag;
import org.springframework.stereotype.Service;

//import lombok.RequiredArgsConstructor;
@Service
//@RequiredArgsConstructor
public class FeatureFlagService {
	
	@Autowired
	private   FeatureFlagRepository repository;
	
	public boolean isEnabled(String featureName,String user)
	{
		FeatureFlag flag=repository.findByName(featureName).orElse(null);
		
		if(flag==null)
			return false;
		if(!flag.isGlobalEnable())
			return false;
		if(flag.getBlacklist()!=null && flag.getBlacklist().contains(user))
			return false;
		if(flag.getWhitelist()!=null && flag.getWhitelist().contains(user))
			return true;
		int hash=Math.abs(user.hashCode())%100;
		return hash<flag.getRolloutPercentage();
		
//		return repository.findByFeatureName(featureName)
//				.map(FeatureFlag::isEnabled)
//				.orElse(false);
	}
	

}
