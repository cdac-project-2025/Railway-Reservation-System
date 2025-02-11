package com.railway.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "cancelled_trains")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class CancelledTrain {
	
	@Column(length = 100, nullable = false)
	private String trainName;
	
	@Column(length = 100, nullable = false)
	private String fromStation;
	
	@Column(length = 100, nullable = false)
	private String toStation;
	
	@EmbeddedId
	private CompositeTrainKey compositeTrainKey;
}