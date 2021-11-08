package ua.brodnikovska.repairproject.entity;

import org.springframework.security.core.GrantedAuthority;

public enum RoleType implements GrantedAuthority {
    ROLE_ADMIN,
    ROLE_USER,
    ROLE_MASTER;

    @Override
    public String getAuthority() {
        return name();
    }
}
