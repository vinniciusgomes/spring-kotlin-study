package com.jetherrodrigues.unisal.application.web.request;

import com.jetherrodrigues.unisal.domain.store.Store;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public final class StoreRequest {

    @NotEmpty
    @NotNull
    private String name;

    public static Store toStore(final StoreRequest request) {
        return new Store(request.getName());
    }

    public String getName() {
        return name;
    }
}
