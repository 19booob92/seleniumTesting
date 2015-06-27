package pl.org.pgs.action;

import pl.org.pgs.IData;

public abstract class AbstractAction {

	protected static IData data;

	public static void setData(IData d) {
		data = d;
	}

}
