package com.microerp.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(	name = "title")
public class Title {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String workerTitle;
    private Date affectedFrom;
    
    public Title(String workerTitle, Date affectedFrom) {
        super();
        this.workerTitle = workerTitle;
        this.affectedFrom = affectedFrom;

    }
    
    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }
    
	public String getWorkerTitle() {
		return workerTitle;
	}

	public void setWorkerTitle(String workerTitle) {
		this.workerTitle = workerTitle;
	}

	public Date getAffectedFrom() {
		return affectedFrom;
	}

	public void setAffectedFrom(Date affectedFrom) {
		this.affectedFrom = affectedFrom;
	}

}
