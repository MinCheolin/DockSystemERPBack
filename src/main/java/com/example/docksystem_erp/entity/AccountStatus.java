package com.example.docksystem_erp.entity;

public enum AccountStatus {
    READY("대기"),
    COMPLETE("완료");

    private final String label;

    AccountStatus(String label){
        this.label = label;
    }

    public String getLabel(){
        return label;
    }
}
