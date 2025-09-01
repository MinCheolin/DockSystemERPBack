package com.example.docksystem_erp.entity;

public enum AccountType {
    DEPOSIT("입금"),
    DEBIT("출금");

    private final String label;

    AccountType(String label){
        this.label = label;
    }

    public String getLabel(){
        return label;
    }
}
