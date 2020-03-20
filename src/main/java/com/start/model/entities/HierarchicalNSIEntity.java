package com.start.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
//@ApiModel(description = "Иерархическая сущность НСИ")
public abstract class HierarchicalNSIEntity<T extends HierarchicalNSIEntity> extends AbstractEntity {
    private static final long serialVersionUID = -8301374655882490671L;

    @Column(name = "parent_id")
    private Long parentId;

   /* @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id", updatable = false, insertable = false)
    private T parent;

    @OneToMany(cascade = {CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @OrderBy("orderr")
    @JoinColumn(insertable = false, updatable = false, name = "parent_id")
    @NotFound(action = NotFoundAction.IGNORE)
    private List<T> nodes = new ArrayList<>();*/
}
