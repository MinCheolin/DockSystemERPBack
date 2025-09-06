package com.example.docksystem_erp.entity.Client;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ClientType {
    MATERIAL("자재"),
    EQUIPMENT("장비");

    private final String label;

    ClientType(String label){
        this.label=label;
    }
    @JsonValue // READY로 응답받지 않고 대기로 응답받으려면 필요함
    public String getLabel(){
        return label;
    }

}
