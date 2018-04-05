package com.expedia.assignment.calculator;

import com.expedia.assignment.item.Item;
import com.expedia.assignment.item.ItemType;
import static com.expedia.assignment.calculator.Constants.TAX_RATE;

import org.springframework.stereotype.Component;

import static com.expedia.assignment.item.ItemType.CD;
import static com.expedia.assignment.item.ItemType.MEDICAL;
import static com.expedia.assignment.item.ItemType.OTHERS;
import static com.expedia.assignment.calculator.Constants.EXTRA_CD_TAX_RATE;

@Component
public class SalesTaxCalculator implements TaxCalculator{

    public double computeTax(final Item item) {
        double tax = 0.0;
        final int numOfItems = item.getNumOfItems();
        final double price = item.getPrice();
        final ItemType itemType = item.getItemType();
        if(itemType.equals(OTHERS)){
            tax = numOfItems * TAX_RATE * price;
        }
        else if(itemType.equals(CD)){
            tax = numOfItems * TAX_RATE * price + EXTRA_CD_TAX_RATE;
        }
        else if(itemType.equals(MEDICAL)){
            tax = 0.0;
        }
        return tax;
    }
}
