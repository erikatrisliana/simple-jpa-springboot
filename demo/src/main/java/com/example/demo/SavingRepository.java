package com.example.demo;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface SavingRepository extends PagingAndSortingRepository<Saving, String> {

    Saving findBySavingId(String savingId);

}
