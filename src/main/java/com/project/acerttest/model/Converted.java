package com.project.acerttest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "CONVERTED")
public class Converted {
	
	@Id
	@GeneratedValue
	@Column(name = "id", nullable = false)
	private Long id;

    @Column(name = "origin", length = 64, nullable = false)
	private String origin;
    
    @Column(name = "destiny", length = 64, nullable = false)
    private String destiny;
   
    @Column(name = "originValue", length = 64, nullable = false)
	private long originValue;
    
    @Column(name = "convertedValue", length = 64, nullable = false)
	private long convertedValue;

	public Long getId() {
		return id;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestiny() {
		return destiny;
	}

	public void setDestiny(String destiny) {
		this.destiny = destiny;
	}


	public long getOriginValue() {
		return originValue;
	}

	public void setOriginValue(long originValue) {
		this.originValue = originValue;
	}

	public long getConvertedValue() {
		return convertedValue;
	}

	public void setConvertedValue(long convertedValue) {
		this.convertedValue = convertedValue;
	}

}
