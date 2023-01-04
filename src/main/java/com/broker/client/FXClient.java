package com.broker.client;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

import com.broker.dto.QuoteRequest;
import com.broker.dto.QuoteResponse;
import com.broker.entities.Quote;
import com.broker.repository.QuoteRepository;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;


public class FXClient {
    @Autowired
    private QuoteRepository quoteRepository;

    public String GetQuote(QuoteRequest quote) throws JsonProcessingException {

        // Currently this is a fake client with a dummy response
        final String uri = "https://api.polygon.io/v2/aggs/ticker/C:EURUSD/range/1/day/2021-07-22/2021-07-22?adjusted=true&sort=asc&limit=120&apiKey=rUleT2MQq0nwSDfFpBSKqPqQl7dVtp61";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);

        // Now map to quoteResponse
        QuoteResponse quoteResponse = new QuoteResponse(quote.getBaseCurrency(), quote.getQuotedCurrency(), UUID.randomUUID().toString(), BigDecimal.valueOf(1.11), BigDecimal.valueOf(1.12));

        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

        // TODO persist quote
        final Quote entity = new Quote();
        entity.setAsk("1.11");
        entity.setBid("1.10");
        entity.setBase_currency("EUR");
        entity.setQuoted_currency("USD");
        entity.setRequestId("testrequestId");
        entity.setReceivedRequestId("rcvdrqId");
        entity.setDateCreated(Instant.now());

        quoteRepository.save(entity);

        return mapper.writeValueAsString(quoteResponse);
    }

}
