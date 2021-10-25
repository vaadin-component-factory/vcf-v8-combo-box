/*
 * Copyright 2000-2021 Vaadin Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.vaadin.componentfactory.combobox;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.JavaScript;
import com.vaadin.flow.component.dependency.JsModule;
import java.util.Collection;

/**
 * Extension of ComboBox component that provides a modified ComboBox that mimics some of Vaadin 8
 * ComboBox behavior:
 * 
 * <p>
 * - First item is always focused when dropdown is manually open if no item is already selected.
 * <p>
 * - First item is always focused when filtering is triggered by entering some text in the input
 * field.
 * <p>
 * - First item is always focused when dropdown is open after clearing the previous selected value
 * with the clear button.
 * <p>
 * - No item is selected if focusout event is triggered and there was a highlighted item in the
 * dropdown.
 *
 */
@JavaScript("@vaadin/flow-frontend/comboBoxConnector.js")
@JsModule("@vaadin/flow-frontend/comboBoxConnector-es6.js")
@JsModule("./vcf-v8-combo-box.js")
@Tag("vcf-v8-combo-box")
public class V8ComboBox<T> extends ComboBox<T> {

    public V8ComboBox(int pageSize) {
      super(pageSize);
    }

    public V8ComboBox() {
       super();
    }

    public V8ComboBox(String label) {
        super(label);
    }

    public V8ComboBox(String label, Collection<T> items) {
        super(label, items);
    }

    @SafeVarargs
    public V8ComboBox(String label, T... items) {
        super(label, items);
    }

}
