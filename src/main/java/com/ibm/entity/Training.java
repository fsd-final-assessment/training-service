package com.ibm.entity;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Training {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer id;
	  
	@Column(name = "rating")
	private Float rating;
	
	@Column(name = "start_date")
//	@Temporal(TemporalType.DATE)
	private LocalDateTime startDate;
	
	@Column(name = "end_date")
//	@Temporal(TemporalType.DATE)
	private LocalDateTime endDate;
	
	@Column(name = "status", length = 40)
	private String status;
	
	@Column(name = "create_date")
//	@Temporal(TemporalType.DATE)
	private LocalDateTime createDate;
	
	@Column(name = "update_date", columnDefinition="timestamp DEFAULT CURRENT_TIMESTAMP")
//	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime updateDate;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "mentor_id")
	private User mentor;
	
	@ManyToOne
	@JoinColumn(name = "skill_id",referencedColumnName="id")
	private Skill skill;
	
}
