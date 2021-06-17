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
package com.assm.controller.session;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.assm.dto.ProductDTO;

/**
 * Class description goes here.
 * 
 * @since 11:31:30 PM
 * @author ThoND
 */
public class CartSession {

	private Integer id;
	private Date createDate;
	private List<ProductDTO> lstProduct;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public List<ProductDTO> getLstProduct() {
		if (lstProduct == null) {
			return new ArrayList<>();
		}
		
		return lstProduct;
	}

	public void setLstProduct(List<ProductDTO> lstProduct) {
		this.lstProduct = lstProduct;
	}

	public CartSession(Integer id, Date createDate, List<ProductDTO> lstProduct) {
		super();
		this.id = id;
		this.createDate = createDate;
		this.lstProduct = lstProduct;
	}

	public CartSession() {
		super();
	}

}
