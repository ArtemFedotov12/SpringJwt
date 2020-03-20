package com.start.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@NamedEntityGraph(
        name = "permissionGroup-graph-with-nodes-actions",
        attributeNodes = {
                @NamedAttributeNode("code"),
                @NamedAttributeNode("name"),
                @NamedAttributeNode("parentId"),
                @NamedAttributeNode("nodes"),
                @NamedAttributeNode("parent"),
                @NamedAttributeNode(value = "actions", subgraph = "actions-subgraph"),
        },
        subgraphs = {
                @NamedSubgraph(
                        name = "actions-subgraph",
                        attributeNodes = {
                                @NamedAttributeNode("code"),
                                @NamedAttributeNode("name")
                        }
                )
        }
)

@Getter
@Setter
@NoArgsConstructor
@Table(name = "permission_group")
@Entity
public class PermissionGroup extends HierarchicalNSIEntity<PermissionGroup> {


    @Column(name = "parent_id")
    private Long parentId;

    private String name;

    private String description;

    private String code;

    private int orderr;

    @OrderBy("orderr ASC")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "permission_group_id")
    private Set<Permission> actions;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id", updatable = false, insertable = false)
    private PermissionGroup parent;

    @OneToMany(cascade = {CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @OrderBy("orderr")
    @JoinColumn(insertable = false, updatable = false, name = "parent_id")
    @NotFound(action = NotFoundAction.IGNORE)
    private List<PermissionGroup> nodes = new ArrayList<>();


}
