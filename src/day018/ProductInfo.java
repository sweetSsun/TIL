package day018;

public class ProductInfo {
	
	private int productNum;
	private String productName;
	private int productPrice;
	private int productStock;
	private String productCategory;
	
	public int getProductNum() {
		return productNum;
	}
	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public int getProductStock() {
		return productStock;
	}
	public void setProductStock(int productStock) {
		this.productStock = productStock;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	@Override
	public String toString() { // 전상품 조회
		return "[상품번호 : " + productNum + ", 상품명 : " + productName + ", 상품가격 : "
				+ productPrice + ", 상품수량 : " + productStock + ", 상품종류 : " + productCategory + "]";
	}
}
