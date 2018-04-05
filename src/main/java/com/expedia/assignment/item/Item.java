package com.expedia.assignment.item;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class Item {

    private final String itemName;
    private final ItemType itemType;
    private final int numOfItems;
    private final double price;
    
    @JsonCreator
	public Item(@JsonProperty("itemName") final String itemName, 
				@JsonProperty("type") final ItemType itemType, 
				@JsonProperty("quantity") final int numOfItems, 
				@JsonProperty("price") final double price) {
		this.itemName = itemName;
		this.itemType = itemType;
		this.numOfItems = numOfItems;
		this.price = price;
	}
}
