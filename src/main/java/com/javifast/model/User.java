package com.javifast.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="users")
@Access(AccessType.FIELD)
public class User extends ParentEntity{

	private static final long serialVersionUID = 1873931211427589702L;

	@Column(name = "first_name", nullable=false, length=50)
    private String firstName;
	
	@Column(name = "last_name", nullable=false, length=50)
    private String lastName;
	
	public String getNombre() {
		return firstName;
	}
	
	public void setNombre(String nombre) {
		this.firstName = nombre;
	}
	
	public String getApellido() {
		return lastName;
	}
	
	public void setApellido(String apellido) {
		this.lastName = apellido;
	}
	
    
}
