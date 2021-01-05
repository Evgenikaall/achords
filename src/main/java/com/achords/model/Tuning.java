package com.achords.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "instrument_tuning")
@AllArgsConstructor
@NoArgsConstructor
public class Tuning {
    @Id
    private String tuning;
}
