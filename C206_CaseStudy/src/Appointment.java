
public class Appointment {

	private int appId;
	private String custName;
	private String dName;
	private String dateofApp;
	private String timeofApp;
	private String address;

	public Appointment(int appId, String custName, String dName, String dateofApp, String timeofApp, String address) {
		this.appId = appId;
		this.custName = custName;
		this.dName = dName;
		this.dateofApp = dateofApp;
		this.timeofApp = timeofApp;
		this.address = address;
	}

	public int getAppId() {
		return appId;
	}

	public String getCustName() {
		return custName;
	}

	public String getdName() {
		return dName;
	}

	public String getDateofApp() {
		return dateofApp;
	}

	public void setDateofApp(String dateofApp) {
		this.dateofApp = dateofApp;
	}

	public String getAddress() {
		return address;
	}

	public String getTimeofApp() {
		return timeofApp;
	}

	public void setTimeofApp(String timeofApp) {
		this.timeofApp = timeofApp;
	}
}
