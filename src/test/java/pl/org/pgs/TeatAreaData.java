package pl.org.pgs;

public class TeatAreaData implements IData {

	private final String adminLogin = "administrator@testarena.pl";
	private final String adminPassword = "sumXQQ72$L";
	private final String url = "http://demo.testarena.pl";

	private static IData data;

	public static IData getInstance () {

		if (data == null) {
			data = new TeatAreaData();
		}
		
		return data;
	}

	@Override
	public String getUrl() {
		return url;
	}

	@Override
	public String getAdminLogin() {
		return adminLogin;
	}

	@Override
	public String getAdminPassword() {
		return adminPassword;
	}

	@Override
	public String getLoginUrl() {
		return url + "/zaloguj";
	}

}
