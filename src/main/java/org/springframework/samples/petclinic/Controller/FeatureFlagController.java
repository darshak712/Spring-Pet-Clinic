package org.springframework.samples.petclinic.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.Repositry.FeatureFlagRepository;
import org.springframework.samples.petclinic.model.FeatureFlag;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/features")
public class FeatureFlagController {

	@Autowired
    private  FeatureFlagRepository repository;

    @PostMapping
    public FeatureFlag create(@RequestBody FeatureFlag flag) {
        return repository.save(flag);
    }

    @GetMapping
    public List<FeatureFlag> getAll() {
        return repository.findAll();
    }

    @PutMapping("/{id}")
    public FeatureFlag update(@PathVariable Long id,
                             @RequestBody FeatureFlag updated) {

        FeatureFlag flag = repository.findById(id)
                .orElseThrow();

        flag.setGlobalEnable(updated.isGlobalEnable());
        flag.setRolloutPercentage(updated.getRolloutPercentage());
        flag.setWhitelist(updated.getWhitelist());
        flag.setBlacklist(updated.getBlacklist());

        return repository.save(flag);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}