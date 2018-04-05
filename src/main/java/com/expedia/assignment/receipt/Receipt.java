package com.expedia.assignment.receipt;

import java.util.Collection;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import static com.google.common.collect.ImmutableSet.of;
import static com.google.common.collect.ImmutableSortedSet.copyOf;

@Getter
@EqualsAndHashCode
@ToString
public class Receipt {
    private final Collection<Purchase> purchases;
    private final double taxes;
    private final double total;

    public Receipt(final Collection<Purchase> purchases, final double taxes, final double total) {
        this.purchases = (purchases == null ? of() : copyOf(purchases));
        this.taxes = taxes;
        this.total = total;
    }

    
}
