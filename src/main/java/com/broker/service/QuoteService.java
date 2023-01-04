package com.broker.service;

import java.util.stream.Stream;

import com.broker.entities.Quote;

public interface QuoteService {
    Stream<Quote> getQuotes();
}
