package com.example.lavrastore.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.lavrastore.domain.Item;
import com.example.lavrastore.domain.WishList;

@Mapper
public interface WishListMapper {
	/* Read */
	List<WishList> getAllWishList();
	List<Item> getItemByWishListId(String MemberId);
	
	/* Create */
	int insertWishList(WishList wishList);
	
	/* Update */
	int updateWishList(WishList wishList); 
	
	/* Delete */
	int deleteWishList(WishList wishList);
}
