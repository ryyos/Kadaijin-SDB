package com.kadaijin.kadaijin.model.log;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "user")
@Data
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userID;

    private String userName;

    @OneToMany(mappedBy = "userModel")
    private List<LogModel> log = new ArrayList<>();

    private Integer totalLogin;
}
