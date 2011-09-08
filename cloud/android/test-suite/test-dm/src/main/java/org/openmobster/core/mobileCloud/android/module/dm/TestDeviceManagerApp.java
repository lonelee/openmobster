/**
 * Copyright (c) {2003,2011} {openmobster@gmail.com} {individual contributors as indicated by the @authors tag}.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.openmobster.core.mobileCloud.android.module.dm;

import android.os.Bundle;

import org.openmobster.core.mobileCloud.android.errors.ErrorHandler;
import org.openmobster.core.mobileCloud.android.errors.SystemException;
import org.openmobster.core.mobileCloud.android.kernel.DeviceContainer;

import org.openmobster.core.mobileCloud.android_native.framework.App;

/**
 * @author openmobster@gmail.com
 *
 */
public class TestDeviceManagerApp extends App
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		try
		{									   
			this.bootstrapContainer(); 
			super.onCreate(savedInstanceState);
		} 
		catch (Exception e)
		{
			e.printStackTrace(System.out);
			ErrorHandler.getInstance().handle(new SystemException(this.getClass().getName(), "onCreate", new Object[]{
				"Message:"+e.getMessage(),
				"Exception:"+e.toString()
			}));
			this.showError();
		}
	}
	
	@Override
	protected void bootstrapContainer() throws Exception
	{
		//Initialize the kernel
		DeviceContainer.getInstance(this.getApplicationContext()).propagateNewContext(this.getApplicationContext());
    	DeviceContainer.getInstance(this.getApplicationContext()).startup(); 
	}
}
