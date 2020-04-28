/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.jsp.ast;

public final class ASTJspDeclarations extends AbstractJspNode {

    ASTJspDeclarations(int id) {
        super(id);
    }

    @Override
    protected <P, R> R acceptVisitor(JspVisitor<P, R> visitor, P data) {
        return visitor.visit(this, data);
    }
}
