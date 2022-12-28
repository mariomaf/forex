package broker.dto;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuoteRequest {

    private final String baseCurrency;

    private final String quotedCurrency;

    private final String requestId;

    public QuoteRequest(String baseCurrency, String quotedCurrency)
    {
        this.baseCurrency = baseCurrency;
        this.quotedCurrency = quotedCurrency;
        this.requestId = UUID.randomUUID().toString();
    }

}
