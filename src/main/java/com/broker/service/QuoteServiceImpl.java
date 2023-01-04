package com.broker.service;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import com.broker.entities.Quote;
import com.broker.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class QuoteServiceImpl implements QuoteService{

    private QuoteRepository quoteRepository;

    @Autowired
    public QuoteServiceImpl(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    @Override
    public Stream<Quote> getQuotes() {
        return StreamSupport.stream(quoteRepository.findAll().spliterator(), true);
    }
}
