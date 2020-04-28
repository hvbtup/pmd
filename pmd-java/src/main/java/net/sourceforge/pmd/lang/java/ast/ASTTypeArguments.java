/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.java.ast;

import java.util.Iterator;

import net.sourceforge.pmd.annotation.InternalApi;


/**
 * Represents a list of type arguments. This is different from {@linkplain ASTTypeParameters type parameters}!
 *
 * <pre>
 *
 *  TypeArguments ::= "<" {@linkplain ASTTypeArgument TypeArgument} ( "," {@linkplain ASTTypeArgument TypeArgument} )* ">"
 *                  | "<" ">"
 * </pre>
 */
public class ASTTypeArguments extends AbstractJavaNode implements Iterable<ASTTypeArgument> {

    @InternalApi
    @Deprecated
    public ASTTypeArguments(int id) {
        super(id);
    }


    @Override
    protected <P, R> R acceptVisitor(JavaVisitor<P, R> visitor, P data) {
        return visitor.visit(this, data);
    }


    /**
     * Returns true if this is a diamond, that is, the
     * actual type arguments are inferred.
     */
    public boolean isDiamond() {
        return getNumChildren() == 0;
    }


    @Override
    public Iterator<ASTTypeArgument> iterator() {
        return children(ASTTypeArgument.class).iterator();
    }
}
