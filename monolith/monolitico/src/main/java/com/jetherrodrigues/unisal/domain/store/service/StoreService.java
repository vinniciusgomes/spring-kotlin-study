package com.jetherrodrigues.unisal.domain.store.service;

import com.jetherrodrigues.unisal.domain.store.Store;
import com.jetherrodrigues.unisal.domain.store.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class StoreService {

    @Autowired
    private StoreRepository repository;

    public Optional<Store> findById(final long id) {
        return repository.findById(id);
    }

    public Page<Store> findAll(final Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Transactional
    public Store save(final Store store) {
        return repository.save(store);
    }

}
