package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public record Transaction(
        String id,
        BigDecimal price,
        String type,
        LocalDate date
) implements Serializable {

    public Transaction{
        if(price.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("Price has to be positive number");
        }
    }

}
