package com.expedia.assignment.billing;

import java.util.Collection;

import com.expedia.assignment.item.Item;
import com.expedia.assignment.receipt.Receipt;


public interface Billing {

   public Receipt buyItems(final Collection<Item> itemList);
}
