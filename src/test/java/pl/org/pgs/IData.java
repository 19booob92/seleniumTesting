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

	public default String getAddPhaseUrl() {
		return getUrl() + "/add_phase";
	}

	public default String getRoleListUrl() {
		return getUrl() + "/administration/role_list";
	}
}
