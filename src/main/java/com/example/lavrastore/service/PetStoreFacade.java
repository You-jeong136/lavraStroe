package com.example.lavrastore.service;

import java.util.List;
import java.util.Map;

import com.example.lavrastore.domain.CartItem;
import com.example.lavrastore.domain.Category;
import com.example.lavrastore.domain.Item;
import com.example.lavrastore.domain.Product;

/**
 * JPetStore's central business interface.
 *
 * @author Juergen Hoeller
 * @since 30.11.2003
 */
public interface PetStoreFacade {


	/* Category */

	List<Category> getCategoryList();
	Category getCategoryById(int categoryId);
	int insertCategory(Category category); // 0이면 실패, 0 초과는 성공
	int updateCategory(Category category);
	int deleteCategory(String categoryId);

	/* Product */
	
	List<Product> getProductListByCategory(int categoryId);
	Product getProductById(int productId);
	Product getProductByName(String name);
	Category getCategoryByProId(int productId);
	int insertProduct(Product product);
	int updateProduct(Product product); // 기존에 설계한 것을 합쳐버림(ppt 참고)
	int deleteProduct(Product product);
	

	/* Item */
	
	List<Item> getItemListByProduct(int productId);
	Item getItem(int itemId);
	List<Item> getItemForNotUser(); // 인기순으로 되어 있음. 비로그인 용
	List<Item> getItemForUser(String memberId);

	//높은 가격순
	List<Item> getItemOrderByHighPriceForUser(String memberId);
	List<Item> getItemOrderByHighPriceForNotUser();
	
	// 낮은 가격순
	List<Item> getItemOrderByLowPriceForUser(String memberId);
	List<Item> getItemOrderByLowPriceForNotUser();

	int insertItem(int itemId);
	int updateItem(int itemId); // ppt ItemDao의 update 부분의 기능들을 다 합침.
	int deleteItem(int itemId);
	
	/* CartItem */
	
	List<CartItem> getAllCartList();
	List<CartItem> getCartListByGeneralCategory(int categoryId);
	List<CartItem> getCartListByGroupCategory(int categoryId);
	List<CartItem> getCartListByPTPCategory(int categoryId);
	List<CartItem> getItemByCartItemId(int cartItemId); //cartItemId로 cartItem에 있는 Item 가져오기
	
	int insertCartItem(CartItem cartItem);
	int updateCartItem(CartItem cartItem); // ppt에 있는 메소드들 합침. 
	int deleteCartItem(int cartItemId);
	

}