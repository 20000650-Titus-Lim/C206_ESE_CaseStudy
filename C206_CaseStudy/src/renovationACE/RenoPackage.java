package renovationACE;

import java.time.LocalDate;

public class RenoPackage {
	private int code;
	private String desc;
	private LocalDate startDate;
	private LocalDate endDate;
	private double amount;
	
	public RenoPackage(int code, String desc, LocalDate startDate, LocalDate endDate, double amount) {
		super();
		this.code = code;
		this.desc = desc;
		this.startDate = startDate;
		this.endDate = endDate;
		this.amount = amount;
	}

	public int getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public double getAmount() {
		return amount;
	}
}
