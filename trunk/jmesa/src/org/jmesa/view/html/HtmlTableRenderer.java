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

import org.jmesa.view.TableRenderer;

/**
 * @since 2.0
 * @author Jeff Johnston
 */
public interface HtmlTableRenderer extends TableRenderer {
	public String getStyle();

	public void setStyle(String style);

	public String getStyleClass();

	public void setStyleClass(String styleClass);
	
	public String getBorder();

	public void setBorder(String border);

	public String getCellpadding();

	public void setCellpadding(String cellpadding);

	public String getCellspacing();

	public void setCellspacing(String cellspacing);
}
