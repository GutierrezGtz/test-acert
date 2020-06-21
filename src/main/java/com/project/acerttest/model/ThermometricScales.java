package com.project.acerttest.model;

public enum ThermometricScales {

    CELSIUS("celsius"),
    FAHRENHEIT("fahrenheit");
 
    private String desc;
 
    ThermometricScales(String desc) {
		this.desc = desc;
	}

	public String getDesc() {
        return desc;
    }
}
