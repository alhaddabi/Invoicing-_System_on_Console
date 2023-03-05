package InvoicingPackage;

import java.util.ArrayList;

public class invoice {
	
	ArrayList<Items> itemsList = new ArrayList<Items>();
	
	private int invoiceId ;
	private int invoicDate ;
	private int numberOfItems ;
	private int totalAmount ;
	private int paidAmount ;
	private int totalBalanc ;
	
	
	
	public int getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}
	public int getInvoicDate() {
		return invoicDate;
	}
	public void setInvoicDate(int invoicDate) {
		this.invoicDate = invoicDate;
	}
	public int getNumberOfItems() {
		return numberOfItems;
	}
	public void setNumberOfItems(int numberOfItems) {
		this.numberOfItems = numberOfItems;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public int getPaidAmount() {
		return paidAmount;
	}
	public void setPaidAmount(int paidAmount) {
		this.paidAmount = paidAmount;
	}
	public int getTotalBalanc() {
		return totalBalanc;
	}
	public void setTotalBalanc(int totalBalanc) {
		this.totalBalanc = totalBalanc;
	}
	

}
