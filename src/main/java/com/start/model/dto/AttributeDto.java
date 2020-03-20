package com.start.model.dto;

import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
public class AttributeDto {

    @NonNull
    private List<PermissionGroupDto> tree;


}
