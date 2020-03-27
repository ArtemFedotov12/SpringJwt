package com.start.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;
@Getter
@Setter
@Entity
@ApiModel(description="All details about the Employee. ")
// 'callSuper = false' --- means dont't take into consideration parent fields
@EqualsAndHashCode(of={"username"}, callSuper = false)
public class User extends AbstractEntity{

    @Column
    private String username;
    @Column
    @JsonIgnore
    private String password;
    @Column
    private float salary;
    @Column
    private int age;
    @Column
    private boolean isActive = true;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLES", joinColumns = {
            @JoinColumn(name = "USER_ID") }, inverseJoinColumns = {
            @JoinColumn(name = "ROLE_ID") })
    private Set<Role> roles;

}
