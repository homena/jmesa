/*
 * Copyright 2004 original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jmesa.view.html;

import org.apache.commons.lang.StringUtils;
import org.jmesa.view.AbstractRenderer;
import org.jmesa.view.Row;
import org.jmesa.view.ViewUtils;

/**
 * @since 2.0
 * @author Jeff Johnston
 */
public abstract class AbstractHtmlRowRenderer extends AbstractRenderer implements HtmlRowRenderer {
	private String style;
	private String styleClass;
	private String highlightStyle;
	private String highlightClass;
	
	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getStyleClass() {
		return styleClass;
	}

	protected String getStyleClass(int rowcount) {
        String styleClass = getStyleClass();
        if (StringUtils.isNotBlank(styleClass)) {
            return styleClass;
        }

        if (ViewUtils.isRowEven(rowcount)) {
            return HtmlConstants.ROW_EVEN_CSS;
        }

        return HtmlConstants.ROW_ODD_CSS;
	}

	public void setStyleClass(String styleClass) {
		this.styleClass = styleClass;
	}
	
	public String getHighlightClass() {
		return highlightClass;
	}

	public void setHighlightClass(String highlightClass) {
		this.highlightClass = highlightClass;
	}

	public String getHighlightStyle() {
		return highlightStyle;
	}

	public void setHighlightStyle(String highlightStyle) {
		this.highlightStyle = highlightStyle;
	}

	protected String getOnmouseover(boolean highlighter, String onmouseover) {
        if (highlighter) {
            String highlightClass = getHighlightClass();
            if (StringUtils.isNotBlank(onmouseover)) {
                return "this.className='" + highlightClass + "';" + onmouseover;
            } else {
                return "this.className='" + highlightClass + "'";
            }
        } else {
            return onmouseover;
        }
    }

	protected String getOnmouseout(boolean highlighter, String onmouseout, int rowcount) {
        if (highlighter) {
            String styleClass = getStyleClass(rowcount);
            if (StringUtils.isNotBlank(onmouseout)) {
                return "this.className='" + styleClass + "';" + onmouseout;
            } else {
                return "this.className='" + styleClass + "'";
            }
        } else {
            return onmouseout;
        }
    }

	public Object render(Row row, Object item, int rowcount) {
		return render((HtmlRow)row, item, rowcount);
	}
	
	/**
	 * A convience method to convert a Row to an HtmlRow.
	 * 
	 * @param row The table row.
	 * @param item The current item in the Collection of items.
	 * @param rowcount The current row count in the page. 
	 * @return The markup to render for this row.
	 */
	public abstract Object render(HtmlRow row, Object item, int rowcount);
}
