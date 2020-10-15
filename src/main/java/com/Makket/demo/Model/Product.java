package com.Makket.demo.Model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="products")
public class Product {
	
	
	
	@Id 
	private String id;
	
	@Field (value="Prod_Name")
	private String product;
	
	@Field (value="Price")
	private String price;
	
	@Field (value="Description")
	private String description;
	
	@Field (value="Img_1")
	private String image1;
	
	@Field (value="Img_2")
	private String image2;
	
	@Field (value="Quantity")
	private String quantity;
	
	@Field (value="Category")
	private String category;
	
	@Field (value="Type")
	private String type;
	
	@Field (value="Count")
	private int count;

	public Product(String id, String product, String price, String description, String image1, String image2,
			String category, String quantity, String type, int count) {
		
		super();
		this.id = id;
		this.product = product;
		this.price = price;
		this.description = description;
		this.image1 = image1;
		this.image2 = image2;
		this.quantity = quantity;
		this.category = category;
		this.type = type;
		this.count = count;
	}

	
	


	@Override
	public String toString() {
		return "Product [id=" + id + ", product=" + product + ", price=" + price + ", description=" + description
				+ ", image1=" + image1 + ", image2=" + image2 + ", quantity=" + quantity + ", category=" + category
				+ ", type=" + type + ", count=" + count + "]";
	}





	public String getId() {
		return id;
	}





	public void setId(String id) {
		this.id = id;
	}





	public String getProduct() {
		return product;
	}





	public void setProduct(String product) {
		this.product = product;
	}





	public String getPrice() {
		return price;
	}





	public void setPrice(String price) {
		this.price = price;
	}





	public String getDescription() {
		return description;
	}





	public void setDescription(String description) {
		this.description = description;
	}





	public String getImage1() {
		return image1;
	}





	public void setImage1(String image1) {
		this.image1 = image1;
	}





	public String getImage2() {
		return image2;
	}





	public void setImage2(String image2) {
		this.image2 = image2;
	}





	public String getQuantity() {
		return quantity;
	}





	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}





	public String getCategory() {
		return category;
	}





	public void setCategory(String category) {
		this.category = category;
	}





	public String getType() {
		return type;
	}





	public void setType(String type) {
		this.type = type;
	}





	public int getCount() {
		return count;
	}





	public void setCount(int count) {
		this.count = count;
	}


	
	
	
	
	


	
	
	
	
	

}
