package com.microerp.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(	name = "bonus")
public class Bonus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date bonusDate;
    private double bonusAmount;
    
    public Bonus(Date bonusDate, double bonusAmount) {
    	super();
    	this.bonusDate = bonusDate;
    	this.bonusAmount = bonusAmount;
    }
    
    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }
	
    public Date getBonusDate() {
		return bonusDate;
	}
	public void setBonusDate(Date bonusDate) {
		this.bonusDate = bonusDate;
	}
	public double getBonusAmount() {
		return bonusAmount;
	}
	public void setBonusAmount(double bonusAmount) {
		this.bonusAmount = bonusAmount;
	}
}
