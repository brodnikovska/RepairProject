package ua.brodnikovska.repairproject.entity;

import org.springframework.security.core.GrantedAuthority;

public enum RoleType implements GrantedAuthority {
    ADMIN,
    USER,
    MASTER;

    @Override
    public String getAuthority() {
        return name();
    }
}
