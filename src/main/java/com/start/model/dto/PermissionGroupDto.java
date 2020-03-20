package com.start.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Set;

@Data
public class PermissionGroupDto {

    private String code;
    private String name;
    @EqualsAndHashCode.Exclude
    private Set<PermissionGroupDto> nodes = new HashSet<>();
    @EqualsAndHashCode.Exclude
    private Set<PermissionDto> actions;

}
