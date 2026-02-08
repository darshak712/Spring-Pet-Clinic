package org.springframework.samples.petclinic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="feature_flag")
public class FeatureFlag {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique=true,nullable=false)
	private String name;
	
	private boolean globalEnable=true;
	
	private int rolloutPercentage=100;
	
	private String whitelist;
	private String blacklist;
	
	
	private String description;

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isGlobalEnable() {
		return globalEnable;
	}

	public void setGlobalEnable(boolean globalEnable) {
		this.globalEnable = globalEnable;
	}

	public int getRolloutPercentage() {
		return rolloutPercentage;
	}

	public void setRolloutPercentage(int rolloutPercentage) {
		this.rolloutPercentage = rolloutPercentage;
	}

	public String getWhitelist() {
		return whitelist;
	}

	public void setWhitelist(String whitelist) {
		this.whitelist = whitelist;
	}

	public String getBlacklist() {
		return blacklist;
	}

	public void setBlacklist(String blacklist) {
		this.blacklist = blacklist;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
}
