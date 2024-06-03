package com.jtsp.springboot3redis.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product implements Serializable {
    @Id
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private Long quantity;

    @Column
    private String company;
}
