package com.start.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "permission")
@Entity
public class Permission extends HierarchicalNSIEntity<Permission> {

    private String name;
    private String description;
    private int orderr;
    private String code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id", updatable = false, insertable = false)
    private Permission parent;

    @OneToMany(cascade = {CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @OrderBy("orderr")
    @JoinColumn(insertable = false, updatable = false, name = "parent_id")
    @NotFound(action = NotFoundAction.IGNORE)
    private List<Permission> nodes = new ArrayList<>();




}
