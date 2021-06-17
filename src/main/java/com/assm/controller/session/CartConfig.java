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

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

@Configuration
public class CartConfig {

	@Bean
	@Scope(
	  value = WebApplicationContext.SCOPE_SESSION, 
	  proxyMode = ScopedProxyMode.TARGET_CLASS)
	public CartSession cartSession() {
	    return new CartSession();
	}
	
}
