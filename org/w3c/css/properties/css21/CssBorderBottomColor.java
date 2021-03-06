// $Id$
// Author: Yves Lafon <ylafon@w3.org>
//
// (c) COPYRIGHT MIT, ERCIM and Keio University, 2012.
// Please first read the full copyright statement in file COPYRIGHT.html
package org.w3c.css.properties.css21;

import org.w3c.css.util.ApplContext;
import org.w3c.css.util.InvalidParamException;
import org.w3c.css.values.CssExpression;

/**
 * @spec http://www.w3.org/TR/2011/REC-CSS2-20110607/box.html#propdef-border-bottom-color
 * @see CssBorderColor
 */
public class CssBorderBottomColor extends org.w3c.css.properties.css.CssBorderBottomColor {

    /**
     * Create a new CssBorderBottomColor
     */
    public CssBorderBottomColor() {
    }

    /**
     * Creates a new CssBorderBottomColor
     *
     * @param expression The expression for this property
     * @throws org.w3c.css.util.InvalidParamException
     *          Expressions are incorrect
     */
    public CssBorderBottomColor(ApplContext ac, CssExpression expression, boolean check)
            throws InvalidParamException {
        value = CssBorderColor.checkBorderSideColor(ac, this, expression, check);
    }

    public CssBorderBottomColor(ApplContext ac, CssExpression expression)
            throws InvalidParamException {
        this(ac, expression, false);
    }
}

