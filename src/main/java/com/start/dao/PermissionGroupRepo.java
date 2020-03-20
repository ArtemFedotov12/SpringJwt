package com.start.dao;

import com.start.model.entities.PermissionGroup;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionGroupRepo extends JpaRepository<PermissionGroup, Long> {

   @EntityGraph(value = "permissionGroup-graph-with-nodes-actions",type = EntityGraph.EntityGraphType.FETCH)
   /*@Query(value = "WITH RECURSIVE r(id, name, parent_id, code, description, orderr)\n" +
           "\n" +
           "    AS  (   SELECT pg.id, pg.name , pg.parent_id, pg.code, pg.description, pg.orderr\n" +
           "    FROM permission_group pg\n" +
           "    UNION\n" +
           "    SELECT pg.id, pg.name , pg.parent_id, pg.code, pg.description, pg.orderr\n" +
           "    FROM permission_group pg\n" +
           "        JOIN r ON pg.parent_id = r.id)\n" +
           "\n" +
           "SELECT r.id, r.name, r.parent_id, r.code, r.description, r.orderr FROM r" ,nativeQuery = true)*/
    //List<PermissionGroup> findAllByParentIsNullOrderByOrderrAsc();
   List<PermissionGroup> findAll();

}
