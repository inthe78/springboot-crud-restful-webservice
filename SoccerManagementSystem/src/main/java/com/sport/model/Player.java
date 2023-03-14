package com.sport.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Player {
	@Id
	private Integer id;
	private String firstName;
	private String lastName;
	private String birth_date;
	private String jerseyNumber;
    private String footballLeague;
	private String team;
	private String salary;
	private String position;
	private String country;
	private String image;

}
