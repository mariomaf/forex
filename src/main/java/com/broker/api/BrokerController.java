package com.broker.api;

import com.broker.client.FXClient;
import com.broker.dto.QuoteRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BrokerController {

    ObjectMapper objectMapper = new ObjectMapper();

    FXClient fxClient;

    @GetMapping("/quote/{base}/{quote}")
    public String getQuote(@PathVariable("base") final String baseCurrency, @PathVariable("quote") final String quoteCurrency) throws JsonProcessingException {

        // set the quoteRequest
        QuoteRequest quote = new QuoteRequest(baseCurrency, quoteCurrency);

        return fxClient.GetQuote(quote);
    }
}
