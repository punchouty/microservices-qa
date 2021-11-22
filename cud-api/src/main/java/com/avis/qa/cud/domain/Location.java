package com.avis.qa.cud.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique=true)
    @NotBlank(message = "Location name is mandatory")
    private String name;
    @ManyToOne
    @JoinColumn(name="brand_id")
    private Brand brand;
}
