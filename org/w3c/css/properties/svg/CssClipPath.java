//
// Author: Yves Lafon <ylafon@w3.org>
//
// (c) COPYRIGHT MIT, ERCIM, Keio, Beihang, 2016.
// Please first read the full copyright statement in file COPYRIGHT.html
package org.w3c.css.properties.svg;

import org.w3c.css.util.ApplContext;
import org.w3c.css.util.InvalidParamException;
import org.w3c.css.values.CssExpression;
import org.w3c.css.values.CssTypes;
import org.w3c.css.values.CssValue;

/**
 * @spec http://www.w3.org/TR/2011/REC-SVG11-20110816/masking.html#ClipPathProperty
 */
public class CssClipPath extends org.w3c.css.properties.css.CssClipPath {

	/**
	 * Create a new CssClipPath
	 */
	public CssClipPath() {
		value = initial;
	}

	/**
	 * Creates a new CssClipPath
	 *
	 * @param expression The expression for this property
	 * @throws org.w3c.css.util.InvalidParamException
	 *          Expressions are incorrect
	 */
	public CssClipPath(ApplContext ac, CssExpression expression, boolean check)
			throws InvalidParamException {
		if (check && expression.getCount() > 1) {
			throw new InvalidParamException("unrecognize", ac);
		}
		setByUser();

		CssValue val;
		char op;

		val = expression.getValue();
		op = expression.getOperator();

		switch (val.getType()) {
			case CssTypes.CSS_URL:
				value = val;
				break;
			case CssTypes.CSS_IDENT:
				if (inherit.equals(val)) {
					value = inherit;
					break;
				}
				if (none.equals(val)) {
					value = none;
					break;
				}
			default:
				throw new InvalidParamException("value",
						val.toString(),
						getPropertyName(), ac);
		}
		expression.next();
	}

	public CssClipPath(ApplContext ac, CssExpression expression)
			throws InvalidParamException {
		this(ac, expression, false);
	}

}
