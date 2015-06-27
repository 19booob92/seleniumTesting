package pl.org.pgs.action;

import pl.org.pgs.IData;

public abstract class AbstractAction {

	protected static IData data;

	public static void setIData(IData d) {
		data = d;
	}

}
