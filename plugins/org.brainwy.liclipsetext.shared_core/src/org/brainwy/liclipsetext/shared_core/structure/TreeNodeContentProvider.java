/******************************************************************************
* Copyright (C) 2013  Fabio Zadrozny
*
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*     Fabio Zadrozny <fabiofz@gmail.com> - initial API and implementation
******************************************************************************/
package org.brainwy.liclipsetext.shared_core.structure;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

@SuppressWarnings("rawtypes")
public class TreeNodeContentProvider implements ITreeContentProvider {

    @Override
    public void dispose() {
    }

    @Override
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    }

    @Override
    public Object[] getElements(Object inputElement) {
        return getChildren(inputElement);
    }

    @Override
    public Object[] getChildren(Object parentElement) {
        if (parentElement == null) {
            return new Object[0];
        }
        TreeNode m = (TreeNode) parentElement;
        return m.children.toArray();
    }

    @Override
    public Object getParent(Object element) {
        TreeNode m = (TreeNode) element;
        return m.getParent();
    }

    @Override
    public boolean hasChildren(Object element) {
        TreeNode m = (TreeNode) element;
        return m.children.size() > 0;
    }

}
