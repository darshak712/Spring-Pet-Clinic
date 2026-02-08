package org.springframework.samples.petclinic.Service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.springframework.http.HttpStatus;
import org.springframework.samples.petclinic.Repositry.CheckFeature;
import org.springframework.web.server.ResponseStatusException;

public class FeatureFlagAspect {

	private  FeatureFlagService service;

    @Before("@annotation(checkFeature)")
    public void validateFeature(JoinPoint jp,
                                CheckFeature checkFeature) {

        String user = "demoUser"; 
        // In real apps → fetch from SecurityContext

        boolean enabled =
                service.isEnabled(checkFeature.value(), user);

        if (!enabled) {
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN,
                    "Feature is disabled"
            );
        }
    }
	
}
