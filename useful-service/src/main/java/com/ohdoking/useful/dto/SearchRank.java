package com.ohdoking.useful.dto;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="search_rank")
public class SearchRank {
	
	@Id
	@GeneratedValue
	private Long id;
	private String rank;
	@Column(name="search_word")
	private String searchWord;
	private String source;
	private Timestamp date;
	
}	
