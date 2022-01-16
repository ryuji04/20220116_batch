package com.example.entity;

public class SpendingEntity {
private String spending;
private String memo;
public String getSpending() {
	return spending;
}
public void setSpending(String spending) {
	this.spending = spending;
}
public String getMemo() {
	return memo;
}
public void setMemo(String memo) {
	this.memo = memo;
}
@Override
public String toString() {
	return "SpendingEntity [spending=" + spending + ", memo=" + memo + "]";
}



}
