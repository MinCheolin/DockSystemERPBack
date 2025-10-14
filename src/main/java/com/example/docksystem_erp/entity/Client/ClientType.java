package com.example.docksystem_erp.entity.Client;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ClientType {
    MATERIAL("자재"),
    EQUIPMENT("장비"),
    PAINT("도료/코팅"),
    ENGINEERING("설계/엔지니어링"),
    CERTIFICATION("검사/인증"),
    LOGISTICS("물류/운송"),
    IT_SOLUTION("it소프트웨어");

    private final String label;

    ClientType(String label){
        this.label=label;
    }
    @JsonValue // READY로 응답받지 않고 대기로 응답받으려면 필요함
    public String getLabel(){
        return label;
    }

}
