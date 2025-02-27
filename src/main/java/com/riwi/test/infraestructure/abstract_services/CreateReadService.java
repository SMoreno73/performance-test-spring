package com.riwi.test.infraestructure.abstract_services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CreateReadService<Request, Response, Id> {
    Response create(Request request);
    Page<Response> getAll(Pageable pageable);
    Optional<Response> getById(Id id);
}
