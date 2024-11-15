package com.mm.bootproja.entity;

public class UserType {
    private Integer typeId;
    private Integer typeName;

    public UserType() {
    }

    @Override
    public String toString() {
        return "UserType{" +
                "typeId=" + typeId +
                ", typeName=" + typeName +
                '}';
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getTypeName() {
        return typeName;
    }

    public void setTypeName(Integer typeName) {
        this.typeName = typeName;
    }
}
