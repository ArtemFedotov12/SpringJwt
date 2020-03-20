package com.start.dao;

import com.start.model.entities.PermissionGroup;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PermissionGroupGraphRepo {

    @PersistenceContext(name = "entity-graph-pu")
    private final EntityManager entityManager;


    public List<PermissionGroup> findAllGraph() {

        EntityGraph entityGraph = entityManager.getEntityGraph("permissionGroup-graph-with-nodes-actions");

        List<PermissionGroup> permissionGroups = entityManager.createQuery(
                "select p" +
                        " from PermissionGroup p" +
                        //" where p.parent is null" +
                        " order by p.orderr", PermissionGroup.class)
                .setHint("javax.persistence.fetchgraph", entityGraph)
                .getResultList();

        entityManager.close();


        return permissionGroups;

    }

}
