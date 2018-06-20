package Domain;

import java.util.Date;

public interface ITrade {

	String getId();

	String getBuySellIndicator();

	Date getTradeDate();

	int getPrice1();

	int getPrice2();

}
