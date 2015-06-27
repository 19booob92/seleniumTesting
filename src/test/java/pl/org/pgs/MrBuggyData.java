package pl.org.pgs;

public class MrBuggyData implements IData {

	private final String adminLogin = "admin@tc2014.pl";
	private final String adminPassword = "12qwAS";
	private final String url = "http://demo.mrbuggy2.testarena.pl/logowanie";

	private static IData data;

	public static IData getInstance () {

		if (data == null) {
			data = new MrBuggyData();
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

}
