package com.expedia.assignment.receipt;

import com.expedia.assignment.item.Item;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class Purchase {

    private final Item item;
    private final double taxes;
    private final double total;
    
    public Purchase(final Item item, final double taxes, final double total) {
        this.item = item;
        this.total = total;
        this.taxes = taxes;
    }

}
