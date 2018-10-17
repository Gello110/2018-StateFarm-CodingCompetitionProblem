package com.codingcompetition.statefarm;

public class SearchCriteria {
    private Category cat;
    private String value;

	public SearchCriteria(Category cat, String value) {
		this.cat = cat;
		this.value = value;
	} //SearchCriteria

    public Category getCat() {
        return cat;
    } //getCat

    public String getValue() {
        return value;
    } //getValue
} //SearchCriteria
