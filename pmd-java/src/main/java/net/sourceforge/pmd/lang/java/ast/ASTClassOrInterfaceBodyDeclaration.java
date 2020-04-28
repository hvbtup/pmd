/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.java.ast;

import net.sourceforge.pmd.Rule;
import net.sourceforge.pmd.annotation.InternalApi;

public class ASTClassOrInterfaceBodyDeclaration extends AbstractTypeBodyDeclaration implements CanSuppressWarnings, ASTAnyTypeBodyDeclaration {

    @InternalApi
    @Deprecated
    public ASTClassOrInterfaceBodyDeclaration(int id) {
        super(id);
    }

    @Override
    public boolean hasSuppressWarningsAnnotationFor(Rule rule) {
        for (int i = 0; i < getNumChildren(); i++) {
            if (getChild(i) instanceof ASTAnnotation) {
                ASTAnnotation a = (ASTAnnotation) getChild(i);
                if (a.suppresses(rule)) {
                    return true;
                }
            }
        }
        return false;
    }


    @Override
    public boolean isFindBoundary() {
        // TODO remove from java-grammar
        return isAnonymousInnerClass();
    }

    @Override
    protected <P, R> R acceptVisitor(JavaVisitor<P, R> visitor, P data) {
        return visitor.visit(this, data);
    }


    public boolean isAnonymousInnerClass() {
        return getParent().getParent() instanceof ASTAllocationExpression;
    }

    public boolean isEnumChild() {
        return getParent().getParent() instanceof ASTEnumConstant;
    }
}
