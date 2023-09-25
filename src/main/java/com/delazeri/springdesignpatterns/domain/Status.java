package com.delazeri.springdesignpatterns.domain;

import lombok.Getter;

@Getter
public enum Status {
    CREATED("Created"),
    COMPLETED("Completed"),
    CANCELED("Canceled");

    private final String status;

    Status(String status) {
        this.status = status;
    }
}
