package pl.org.pgs;

public interface IData {

	public abstract String getUrl();
	public abstract String getLoginUrl();
	public abstract String getAdminLogin();
	public abstract String getAdminPassword();

	public default String getWrongLogin() {
		return "aaa";
	}

	public default String getWrongPassword() {
		return "aaa";
	}

	public default String getEnviromentsListUrl() {
		return getUrl() + "/environments";
	}
}
