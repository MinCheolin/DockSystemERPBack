package com.example.docksystem_erp.entity;

import com.fasterxml.jackson.annotation.JsonValue;

public enum AccountType {
    DEPOSIT("입금"),
    DEBIT("출금");

    private final String label;

    AccountType(String label){
        this.label = label;
    }

    @JsonValue // READY로 응답받지 않고 대기로 응답받으려면 필요함
    public String getLabel(){
        return label;
    }
}
