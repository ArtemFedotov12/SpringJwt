package com.start.controller;

import com.start.model.dto.PermissionTreeDto;
import com.start.service.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PermissionController {

    private final PermissionService permissionService;


    @GetMapping("/permissions")
    public PermissionTreeDto perm() {

        PermissionTreeDto permissionTreeDto = new PermissionTreeDto(permissionService.getPermissions());

        return permissionTreeDto;
    }


}
