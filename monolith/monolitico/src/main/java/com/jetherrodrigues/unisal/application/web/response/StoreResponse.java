package com.jetherrodrigues.unisal.application.web.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jetherrodrigues.unisal.domain.store.Store;

import java.time.LocalDateTime;

public final class StoreResponse {

    private long id;
    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-ddTHH:mm:ss.SSSZ")
    private LocalDateTime created;

    public StoreResponse(){}

    private StoreResponse(final long id, final String name, final LocalDateTime created) {
        this.id = id;
        this.name = name;
        this.created = created;
    }

    public static StoreResponse from(final Store store) {
        return new StoreResponse(store.getId(), store.getName(), store.getCreated());
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreated() {
        return created;
    }

}
