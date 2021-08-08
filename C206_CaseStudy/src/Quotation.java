
public class Quotation {


	private int RequestId;
	private int QuotationId;
	private String RenoCategory;
	private String items;
	private int itemPrice;
	private String DesignerName;
	private String StartDate;
	private int totalAmount;
	private String selected;

		public Quotation(int quotationId, int requestId, String renoCategory, String items, int itemPrice, String designerName,
			String startDate, int totalAmount, String selected) {
		RequestId = requestId;
		QuotationId = quotationId;
		RenoCategory = renoCategory;
		this.items = items;
		this.itemPrice = itemPrice;
		DesignerName = designerName;
		StartDate = startDate;
		this.selected = selected;
		
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
		public int getItemPrice() {
			return itemPrice;
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
		public String getSelected() {
			return selected;
		}
		
		
}
