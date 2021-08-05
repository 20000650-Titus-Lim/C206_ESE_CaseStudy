
public class Quotation {


	private int RequestId;
	private int QuotationId;
	private String RenoCategory;
	private String items;
	private String DesignerName;
	private String StartDate;
	private int totalAmount;

		public Quotation(int requestId, int quotationId, String renoCategory, String items, String designerName,
			String startDate, int totalAmount) {
		RequestId = requestId;
		QuotationId = quotationId;
		RenoCategory = renoCategory;
		this.items = items;
		DesignerName = designerName;
		StartDate = startDate;
		
		this.totalAmount = totalAmount;
	}

		public int getRequestId() {
			return RequestId;
		}

		public int getQuotationId() {
			return QuotationId;
		}

		public String getRenoCategory() {
			return RenoCategory;
		}

		public String getItems() {
			return items;
		}

		public String getDesignerName() {
			return DesignerName;
		}

		public String getStartDate() {
			return StartDate;
		}

		public int getTotalAmount() {
			return totalAmount;
		}
		
		
}
