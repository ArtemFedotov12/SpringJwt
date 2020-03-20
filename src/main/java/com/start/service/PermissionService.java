package com.start.service;

import com.start.dao.PermissionGroupRepo;
import com.start.model.converter.PermissionGroupConverter;
import com.start.model.dto.PermissionGroupDto;
import com.start.model.entities.PermissionGroup;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PermissionService {

    //private final PermissionGroupGraphRepo permissionGroupGraphRepo;
    private final PermissionGroupRepo permissionGroupRepo;
    private final PermissionGroupConverter permissionGroupConverter;


    public List<PermissionGroupDto> getPermissions() {

        List<PermissionGroup> permissionGroups = permissionGroupRepo.findAll();
        List<PermissionGroupDto> permissionGroupDtos = convertToPermissionGroupDto(permissionGroups);
        List<PermissionGroup> test = convertToPermissionGroup(permissionGroupDtos);
        return permissionGroupDtos;
    }

    private List<PermissionGroupDto> convertToPermissionGroupDto(List<PermissionGroup> permissionGroups) {

        List<PermissionGroupDto> permissionGroupDtos = new ArrayList<>();

        for (PermissionGroup permissionGroup : permissionGroups) {

           if (permissionGroup.getParent() == null) {
               permissionGroupDtos.add(permissionGroupConverter.toDto(permissionGroup));
           }

        }

        return permissionGroupDtos;
    }

    private List<PermissionGroup> convertToPermissionGroup(List<PermissionGroupDto> permissionGroupDtos) {

        List<PermissionGroup> permissionGroup = new ArrayList<>();

        for (PermissionGroupDto permissionGroupDto : permissionGroupDtos) {
            permissionGroup.add(permissionGroupConverter.toEntity(permissionGroupDto));
        }

        return permissionGroup;

    }

}
