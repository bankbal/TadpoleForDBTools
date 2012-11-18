/*******************************************************************************
 * Copyright (c) 2012 Cho Hyun Jong.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cho Hyun Jong - initial API and implementation
 ******************************************************************************/
package com.hangum.tadpole.rdb.core.actions.nosql.mongodb;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PlatformUI;

import com.hangum.tadpole.dao.system.UserDBDAO;
import com.hangum.tadpole.importdb.core.dialog.importdb.mongodb.MongoDBImportDialog;

/**
 * tadpole db data to mongodb migration
 * 
 * @author hangum
 *
 */
public class MongoDBImportAction implements IViewActionDelegate {
	private IStructuredSelection sel;
	
	@Override
	public void run(IAction action) {
		UserDBDAO userDB = (UserDBDAO)sel.getFirstElement();
		
		MongoDBImportDialog dialog = new MongoDBImportDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), userDB);
		dialog.open();
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		this.sel = (IStructuredSelection)selection;
	}

	@Override
	public void init(IViewPart view) {
	}
}
