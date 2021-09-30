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

import com.vaadin.componentfactory.combobox.V8ComboBox;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.demo.DemoView;
import com.vaadin.flow.router.Route;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * View for {@link V8ComboBox} demo.
 *
 * @author Vaadin Ltd
 */
@Route("")
public class V8ComboBoxDemoView extends DemoView {

    @Override
    public void initView() {
        createComboBoxExample();
        
        addCard("Additional code used in the demo",
            new Label("These methods are used in the demo."));
    }

    private void createComboBoxExample() {
      Div message = createMessageDiv("combo-box-message");
      
      List<String> items = new ArrayList<>(Arrays.asList("Anna", "Thomas", "Annabella", "John", "Tom", "William", "Henry", "Johnatan", "Anthony", "Anne"));
            
      // begin-source-example
      // source-example-heading: V8 ComboBox example
      V8ComboBox<String> combo = new V8ComboBox<>("Select an option", items);
      combo.setClearButtonVisible(true);
      
      combo.addValueChangeListener(e -> {
        if(e.getValue() != null) {
          message.setText("New selected value: " + e.getValue());
        } else {
          message.setText("No value selected");
        }
        
      });
      
      combo.addCustomValueSetListener(e -> {
        String newItem = e.getDetail();
        combo.setValue(newItem);
        message.setText("New selected value: " + e.getDetail());
      });
      
      // end-source-example
      addCard("V8 ComboBox example", combo, message);
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
