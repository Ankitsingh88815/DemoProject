package com.example.demo.Entity;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    
    @Column(nullable = false)
    @NotBlank(message = "Name cannot be blank")
    private String name;
   
    @Column(nullable = false)
    @NotBlank(message = "Name cannot be blank")
    private String address;

    @Column(nullable = false)
    @NotBlank(message = "Name cannot be blank")
    private String college;
}