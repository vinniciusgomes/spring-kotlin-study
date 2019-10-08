package com.jetherrodrigues.unisal.application.web;

import com.jetherrodrigues.unisal.application.web.request.StoreRequest;
import com.jetherrodrigues.unisal.application.web.response.StoreResponse;
import com.jetherrodrigues.unisal.domain.store.Store;
import com.jetherrodrigues.unisal.domain.store.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

import static org.springframework.data.domain.Sort.Direction.DESC;

@RestController
@RequestMapping("/stores")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @GetMapping
    public Page<Store> findAll(@PageableDefault(sort = "name", direction = DESC, page = 0, size = 10)
                                   final Pageable pageable) {
        return storeService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StoreResponse> findById(@PathVariable long id) {
        final Optional<Store> store = storeService.findById(id);

        if (store.isPresent()) {
            return ResponseEntity.ok(StoreResponse.from(store.get()));
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<StoreResponse> create(@RequestBody @Valid final StoreRequest request,
                                    final UriComponentsBuilder uriBuilder) {

        final Store created = storeService.save(StoreRequest.toStore(request));

        URI uri = uriBuilder.path("/stores/{id}").buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uri).body(StoreResponse.from(created));
    }

}
