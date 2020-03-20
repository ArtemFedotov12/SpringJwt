package com.start.model.converter;

import com.start.model.dto.PermissionGroupDto;
import com.start.model.entities.PermissionGroup;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor
public class PermissionGroupConverter implements IConverter<PermissionGroup, PermissionGroupDto> {

    private final PermissionConverter permissionConverter;

    @Override
    public PermissionGroup toEntity(PermissionGroupDto permissionGroupDto) {

        return Optional.ofNullable(permissionGroupDto).map(item -> {

            PermissionGroup permissionGroup1 = new PermissionGroup();

            if (item.getNodes() != null && !item.getNodes().isEmpty()) {
                for (PermissionGroupDto pgd : item.getNodes()) {
                    permissionGroup1.getNodes().add(this.toEntity(pgd));
                }
            }

            permissionGroup1.setCode(item.getCode());
            permissionGroup1.setName(item.getName());
            permissionGroup1.setActions(
                    item.getActions()
                            .stream()
                            .map(permissionConverter::toEntity)
                            .collect(Collectors.toSet())
            );

            return permissionGroup1;
        })
                .orElse(null);

    }

    @Override
    public PermissionGroupDto toDto(PermissionGroup permissionGroup) {

        return Optional.ofNullable(permissionGroup).map(item -> {

            PermissionGroupDto permissionGroupDto1 = new PermissionGroupDto();

            if (item.getNodes() != null && !item.getNodes().isEmpty()) {
                for (PermissionGroup pg : item.getNodes()) {
                    permissionGroupDto1.getNodes().add(this.toDto(pg));
                }
            } else {
                PermissionGroupDto permissionGroupDto2 = new PermissionGroupDto();
                permissionGroupDto2.setCode(item.getCode());
                permissionGroupDto2.setName(item.getName());
                permissionGroupDto2.setActions(
                        item.getActions()
                                .stream()
                                .map(permissionConverter::toDto)
                                .collect(Collectors.toSet())
                );
                return permissionGroupDto2;
            }

            permissionGroupDto1.setCode(item.getCode());
            permissionGroupDto1.setName(item.getName());
            permissionGroupDto1.setActions(
                    item.getActions()
                            .stream()
                            .map(permissionConverter::toDto)
                            .collect(Collectors.toSet())
            );

            return permissionGroupDto1;
        })
                .orElse(null);

    }

}
