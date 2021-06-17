/*
 * %W% %E% com.assm - ThoND
 *
 * Copyright (c) 2017-2018 SMAC VNIT, jsc. All Rights Reserved. 
 *
 * This software is the confidential and proprietary information of SMAC VNIT, jsc. 
 * ("Confidential Information"). You shall not disclose such Confidential Information 
 * and shall use it only in accordance with the terms of the license agreement you entered 
 * into with SMAC.
 *
 * SMAC MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF 
 * THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED 
 * TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE, OR NON-INFRINGEMENT. SMAC SHALL NOT BE LIABLE FOR 
 * ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR 
 * DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
*/
package com.assm.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import com.assm.controller.session.CartSession;
import com.assm.dto.ProductDTO;
import com.assm.entity.Product;
import com.assm.repository.ProductRepositories;

@Service
public class CartService {

	@Autowired 
	private ProductRepositories productRepo;
	
	@Autowired 
	private CartSession cartSession;
	
	
	public void addToCart(Integer productId) throws Exception {
		
		// lay danh sach hang hoa trong session ra
		List<ProductDTO> lstProd = cartSession.getLstProduct();
		
		// kiem tra xem neu da ton tai trong gio hang thi + 1
		boolean isExist = false;
		for (ProductDTO prod: lstProd) {
			if (prod.getId().equals(productId)) {
				isExist = true;
				prod.setQuantity(prod.getQuantity() + 1);
			}
		}
		
		// neu chua ton tai thi thuc hien them moi vao gio hang
		if (!isExist) {
			Product product = productRepo.findById(productId).orElse(null);
			if (product == null) {
				throw new Exception("err.prod.does.not.exist");
			}
			
			ProductDTO prod = new ProductDTO();
			BeanUtils.copyProperties(product, prod);
			prod.setQuantity(1);
			lstProd.add(prod);
		}
		
		// cap nhat thong tin gio hang trong session
		cartSession.setLstProduct(lstProd);
		System.out.println(lstProd.toString());
	}
	
}
