package org.table.processor.model;

import java.util.Date;

public class TotalRow {

	private String title="Total";
	private double factQliqData1;
	private double factQliqData2;
	private double factQoilData1;
	private double factQoilData2;
	private double forecastQliqData1;
	private double forecastQliqData2;
	private double forecastQoilData1;
	private double forecastQoilData2;
	private Date date;
	
	
	public TotalRow(double factQliqData1,double factQliqData2,double factQoilData1,double factQoilData2,
			double forecastQliqData1,double forecastQliqData2,double forecastQoilData1,double forecastQoilData2,
			Date date) {
		this.factQliqData1 = factQliqData1;
		this.factQliqData2 = factQliqData2;
		this.factQoilData1 = factQoilData1;
		this.factQoilData2 = factQoilData2;
		this.forecastQliqData1 = forecastQliqData1;
		this.forecastQliqData2 = forecastQliqData2;
		this.forecastQoilData1 = forecastQoilData1;
		this.forecastQoilData2 = forecastQoilData2;

		this.date = date;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getFactQliqData1() {
		return factQliqData1;
	}
	public void setFactQliqData1(double factQliqData1) {
		this.factQliqData1 = factQliqData1;
	}
	public double getFactQliqData2() {
		return factQliqData2;
	}
	public void setFactQliqData2(double factQliqData2) {
		this.factQliqData2 = factQliqData2;
	}
	public double getFactQoilData1() {
		return factQoilData1;
	}
	public void setFactQoilData1(double factQoilData1) {
		this.factQoilData1 = factQoilData1;
	}
	public double getFactQoilData2() {
		return factQoilData2;
	}
	public void setFactQoilData2(double factQoilData2) {
		this.factQoilData2 = factQoilData2;
	}
	public double getForecastQliqData1() {
		return forecastQliqData1;
	}
	public void setForecastQliqData1(double forecastQliqData1) {
		this.forecastQliqData1 = forecastQliqData1;
	}
	public double getForecastQliqData2() {
		return forecastQliqData2;
	}
	public void setForecastQliqData2(double forecastQliqData2) {
		this.forecastQliqData2 = forecastQliqData2;
	}
	public double getForecastQoilData1() {
		return forecastQoilData1;
	}
	public void setForecastQoilData1(double forecastQoilData1) {
		this.forecastQoilData1 = forecastQoilData1;
	}
	public double getForecastQoilData2() {
		return forecastQoilData2;
	}
	public void setForecastQoilData2(double forecastQoilData2) {
		this.forecastQoilData2 = forecastQoilData2;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
