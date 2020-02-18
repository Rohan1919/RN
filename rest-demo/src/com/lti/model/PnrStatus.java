package com.lti.model;

import java.time.LocalDate;
import java.util.List;

public class PnrStatus {
	private long pnrNo;
	private int trainNo;
	private LocalDate travelDate;
	public PnrStatus() {
		// TODO Auto-generated constructor stub
	}
	
	public PnrStatus(long pnrNo, int trainNo, LocalDate travelDate, List<Passenger> passenger) {
		super();
		this.pnrNo = pnrNo;
		this.trainNo = trainNo;
		this.travelDate = travelDate;
		this.passenger = passenger;
	}

	private List<Passenger> passenger;

	public long getPnrNo() {
		return pnrNo;
	}

	public void setPnrNo(long pnrNo) {
		this.pnrNo = pnrNo;
	}

	public int getTrainNo() {
		return trainNo;
	}

	public void setTrainNo(int trainNo) {
		this.trainNo = trainNo;
	}

	public LocalDate getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(LocalDate travelDate) {
		this.travelDate = travelDate;
	}

	public List<Passenger> getPassenger() {
		return passenger;
	}

	public void setPassenger(List<Passenger> passenger) {
		this.passenger = passenger;
	}

	
	

}
