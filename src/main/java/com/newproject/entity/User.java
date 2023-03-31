package com.newproject.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="KULLANICILAR")
@Data
public class User extends BaseEntity {
    @Id
    @SequenceGenerator(name="user_seq_gen",sequenceName = "user_gen",initialValue = 100,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_seq_gen")
    @Column(name="ID")
    private Long ıd;
    @Column(name="ISIM")
    private String firstName;
    @Column(name="SOYISIM")
    private String lastName;
    @Column(name="TCNO")
    private Long tcNo;
    @Column(name = "YAS")
    private Integer yas;

}
