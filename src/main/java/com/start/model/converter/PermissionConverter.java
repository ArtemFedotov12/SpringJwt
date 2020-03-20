package com.start.model.converter;

import com.start.model.entities.Permission;
import com.start.model.dto.PermissionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static java.util.Optional.ofNullable;

@Component
@RequiredArgsConstructor
public class PermissionConverter implements IConverter<Permission, PermissionDto> {

    @Override
    public Permission toEntity(PermissionDto permissionDto) {
        return ofNullable(permissionDto)
                .map(item -> {
                    Permission permission = new Permission();
                    permission.setCode(item.getCode());
                    permission.setName(item.getName());
                    return permission;
                })
                .orElse(null);
    }

    @Override
    public PermissionDto toDto(Permission permission) {
        return ofNullable(permission)
                .map(item -> {
                    PermissionDto permissionDto = new PermissionDto();
                    permissionDto.setCode(item.getCode());
                    permissionDto.setName(item.getName());
                    return permissionDto;
                })
                .orElse(null);
    }

}
