package com.start.model.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name ="role")
@EqualsAndHashCode(callSuper = false)
public class Role  extends AbstractEntity{

    @Column
    private String name;

    @Column
    private String description;

}
