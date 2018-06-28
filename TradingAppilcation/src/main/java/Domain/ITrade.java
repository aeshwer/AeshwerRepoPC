package Domain;

import java.util.Date;

public interface ITrade {

	int getId();

	String getBuySellIndicator();

	Date getTradeDate();

	int getPrice1();

	int getPrice2();

}
