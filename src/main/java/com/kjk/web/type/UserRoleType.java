package com.kjk.web.type;

public enum UserRoleType implements EnumModel {
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER"),
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
