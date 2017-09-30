package com.italocosta.crudvraptor.model;

import java.util.Date;

public class Client {
	
	private Integer id;
	private String name;
	private Date birthDay;
	private Double height;
	private boolean active;
	
	public Client(Integer id, String name, Date birthDay, Double height, boolean active) {
		super();
		this.id = id;
		this.name = name;
		this.birthDay = birthDay;
		this.height = height;
		this.active = active;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (id.compareTo(other.id)!=0)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return name;
	}
	
	
	
}
