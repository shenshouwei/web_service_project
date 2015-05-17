package cn.com.test;

import java.util.Date;

public class TicketInfo {
	/**
	 * 航空公司
	 */
	private String company;
	/**
	 * 航班号:
	 */
	private String airlineCode;
	/**
	 * 出发机场:
	 */
	private String startDrome;
	/**
	 * 到达机场:
	 */
	private String arriveDrome;
	/**
	 * 出发时间:
	 */
	private Date startTime;
	/**
	 * 到达时间:
	 */
	private Date arriveTime;
	/**
	 * 机型:
	 */
	private String Mode;
	/**
	 * 经停:
	 */
	private String airlineStop;
	/**
	 * 飞行周期(星期)
	 */
	private String Week;
	
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getAirlineCode() {
		return airlineCode;
	}
	public void setAirlineCode(String airlineCode) {
		this.airlineCode = airlineCode;
	}
	public String getStartDrome() {
		return startDrome;
	}
	public void setStartDrome(String startDrome) {
		this.startDrome = startDrome;
	}
	public String getArriveDrome() {
		return arriveDrome;
	}
	public void setArriveDrome(String arriveDrome) {
		this.arriveDrome = arriveDrome;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getArriveTime() {
		return arriveTime;
	}
	public void setArriveTime(Date arriveTime) {
		this.arriveTime = arriveTime;
	}
	public String getMode() {
		return Mode;
	}
	public void setMode(String mode) {
		Mode = mode;
	}
	public String getAirlineStop() {
		return airlineStop;
	}
	public void setAirlineStop(String airlineStop) {
		this.airlineStop = airlineStop;
	}
	public String getWeek() {
		return Week;
	}
	public void setWeek(String week) {
		Week = week;
	}
}
