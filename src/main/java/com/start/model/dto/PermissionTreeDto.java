package com.start.model.dto;


import lombok.Data;

import java.util.List;

import static com.start.utils.Constants.PERMISSION_TREE;

@Data
public class PermissionTreeDto {

    private String name;
    private AttributeDto attributeDto;


    public PermissionTreeDto(List<PermissionGroupDto> permissionGroupDtos) {
        this.name = PERMISSION_TREE;
        this.attributeDto = new AttributeDto(permissionGroupDtos);
    }

}
