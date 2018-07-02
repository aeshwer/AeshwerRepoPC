package Util;

public enum TradeRequestType {
	CREATE(1,"Create"),
	UPDATE(2,"Update"),
	FETCH(3,"Fetch");

	private final int value;
	private final String name;

	TradeRequestType(final int value, final String name) {
		this.value = value;
		this.name = name;
	}
}
