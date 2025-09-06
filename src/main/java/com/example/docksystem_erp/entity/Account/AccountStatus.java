package com.example.docksystem_erp.entity.Account;

import com.fasterxml.jackson.annotation.JsonValue;

public enum AccountStatus {
    READY("대기"),
    COMPLETE("완료");

    private final String label;

    AccountStatus(String label){
        this.label = label;
    }

    @JsonValue // READY로 응답받지 않고 대기로 응답받으려면 필요함
    public String getLabel(){
        return label;
    }
}
