/**
 * Copyright (c) 2013-2016 by Brainwy Software Ltda. All Rights Reserved.
 * Licensed under the terms of the Eclipse Public License (EPL).
 * Please see the license.txt included with this distribution for details.
 * Any modifications to this file must keep this entire header intact.
 */
package org.brainwy.liclipsetext.editor.languages;

import java.util.ArrayList;
import java.util.List;

import org.brainwy.liclipsetext.editor.common.partitioning.rules.ITextMateRule;
import org.eclipse.jface.text.rules.IPredicateRule;

public class ScopeSelector {

    private final String fScope;
    private final List<IPredicateRule> rules;

    public ScopeSelector(String scope, List<ITextMateRule> lst) {
        this.fScope = scope;
        this.rules = new ArrayList<>(lst.size());
        this.rules.addAll(lst);
    }

    public List<IPredicateRule> getRulesAfterScope(String scope2) {
        if (fScope.startsWith(scope2) || fScope.startsWith("R:" + scope2)) {
            return this.rules;
        }
        return null;
    }

    public List<IPredicateRule> getRulesBeforeScope(String scope2) {
        if (fScope.startsWith("L:" + scope2)) {
            return this.rules;
        }
        return null;
    }

    public List<IPredicateRule> getRules() {
        return rules;
    }

    public String getScopeStr() {
        return fScope;
    }

}
