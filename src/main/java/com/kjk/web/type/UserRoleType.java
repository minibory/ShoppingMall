package com.kjk.web.type;

public enum UserRoleType implements EnumModel {
    USER("ROLE_USER"),
    ADMIN("ROLE_ADMIN"),
    ;

    private final String value;

    UserRoleType(String value) {
        this.value = value;
    }

    @Override
    public String getKey() {
        return name();
    }

    @Override
    public String getValue() {
        return value;
    }
}
