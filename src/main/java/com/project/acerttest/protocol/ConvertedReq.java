package com.project.acerttest.protocol;

public class ConvertedReq {

	/**
	 * Não estou tratando de origem e destino, apenas origem, ou seja, de qual 
	 * escala termometrica origem para qual escala destino, pois
	 * foram pedidas apenas conversões de celsius para fahrenheit e vice versa.
	 * mas se em um futuro fosse adicionado outra escala, 
	 * isto devera ser revisto(neste caso acredito que ainda exista coesão).
	 */
	private String origin;
	private double originValue;
	
	
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public double getOriginValue() {
		return originValue;
	}
	public void setOriginValue(double originValue) {
		this.originValue = originValue;
	}
}
