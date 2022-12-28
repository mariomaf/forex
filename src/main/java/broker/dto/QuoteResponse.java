package broker.dto;

import java.math.BigDecimal;

public class QuoteResponse {

    private final String baseCurrency;
    private final String quotedCurrency;
    private final String externalRequestId;
    private final BigDecimal ask;
    private final BigDecimal bid;

    public QuoteResponse(String baseCurrency, String quotedCurrency, String externalRequestId, BigDecimal ask, BigDecimal bid)
    {
        this.baseCurrency = baseCurrency;
        this.quotedCurrency = quotedCurrency;
        this.externalRequestId = externalRequestId;
        this.ask = ask;
        this.bid = bid;
    }

}
