package com.expedia.assignment.billing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.expedia.assignment.calculator.SalesTaxCalculator;
import com.expedia.assignment.item.Item;
import com.expedia.assignment.receipt.Purchase;
import com.expedia.assignment.receipt.Receipt;

import static com.expedia.assignment.calculator.Constants.TWENTY;

@Component
public class ItemBilling implements Billing {

    @Resource private SalesTaxCalculator salesTaxCalculator;

    public Receipt buyItems(final Collection<Item> itemList) {
    		final Collection<Purchase> purchaseList = new ArrayList<>();
        double totalTax = 0.0;
        double totalPrice = 0.0;
        for (final Item item : itemList) {
            final double tax = salesTaxCalculator.computeTax(item);
            final double roundedTax =  Math.ceil(tax * TWENTY) / TWENTY;
            final double itemPrice = tax + (item.getNumOfItems() * item.getPrice());
            final double roundedItemPrice =  Math.ceil(itemPrice * TWENTY) / TWENTY;
            final Purchase purchase = new Purchase(item, roundedTax, roundedItemPrice);
            totalTax = totalTax + tax;
            totalPrice = totalPrice + itemPrice;
            purchaseList.add(purchase);
        }
        return new Receipt(purchaseList, Math.ceil(totalTax * TWENTY) / TWENTY,
                Math.ceil(totalPrice * TWENTY) / TWENTY);
    }

}
