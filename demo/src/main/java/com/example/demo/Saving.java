package com.example.demo;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
public class Saving {

    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private String savingId;

    @Column
    private int savingTenor;

    @Column
    private double firstDeposit;

    @Column
    private double monthlyDeposit;

    @Column
    private String purpose;

}
