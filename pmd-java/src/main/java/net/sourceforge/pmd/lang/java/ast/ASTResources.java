/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.java.ast;

import net.sourceforge.pmd.annotation.InternalApi;

public class ASTResources extends AbstractJavaNode {

    @InternalApi
    @Deprecated
    public ASTResources(int id) {
        super(id);
    }


    @Override
    protected <P, R> R acceptVisitor(JavaVisitor<P, R> visitor, P data) {
        return visitor.visit(this, data);
    }
}
