/*
 * Copyright 2000-2017 Vaadin Ltd.
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
package com.vaadin.componentfactory.demo;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.demo.DemoView;
import com.vaadin.flow.router.Route;

import combobox.V8ComboBox;

/**
 * View for {@link EnhancedDateRangePicker} demo.
 *
 * @author Vaadin Ltd
 */
@Route("")
public class V8ComboBoxDemoView extends DemoView {

    @Override
    public void initView() {
        createPatternDatePicker();

        addCard("Additional code used in the demo",
                new Label("These methods are used in the demo."));
    }


    private void createPatternDatePicker() {
        Div message = createMessageDiv("simple-picker-message");

        // begin-source-example
        // source-example-heading: Date picker with pattern

        V8ComboBox<String> vcb = new V8ComboBox<>("Basic usage", "Option 1", "Option 2", "Option 3");

        // end-source-example


        addCard("V8 ComboBox Basic example", vcb, message);
    }

    // begin-source-example
    // source-example-heading: Additional code used in the demo
    /**
     * Additional code used in the demo
     */
    private Div createMessageDiv(String id) {
        Div message = new Div();
        message.setId(id);
        message.getStyle().set("whiteSpace", "pre");
        return message;
    }
    // end-source-example
}
