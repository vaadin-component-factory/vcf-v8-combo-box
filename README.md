# ComboBox with Vaadin 8 behavior

This component provides a modified combobox that mimics some of Vaadin 8 combobox behavior:

- the first item is always highlighted (focused) when dropdown is manually open (by clicking the arrow) if no item is already selected.
- the first item is always highlighted (focused) when filtering is triggered by entering some text in the input field. This gives the user the possibility to just press enter to select highlighted item on top.
- the first item is always highlighted (focused) when dropdown is open after clearing the previous selected value with the clear button.
- no item is selected if focusout event is triggered and there was a highlighted item in the dropdown.
 
The rest of the functionalities are the same as in the Flow ComboBox component.

This component is part of Vaadin Component Factory.

## How to use it

Create a new component V8ComboBox and use it like a ComboBox component.

For example:

```java
V8ComboBox<String> comboBox = new V8ComboBox<>("Select an option", "Option 1", "Option 2", "Option 3");
```

## Development instructions

Build the project and install the add-on locally:
```
mvn clean install
```
Starting the demo server:

Go to vcf-v8-combo-box-demo and run:
```
mvn jetty:run
```

This deploys demo at http://localhost:8080

## Using the component in a Flow application
To use the component in an application using maven, add the following dependency to your `pom.xml`:
```
<dependency>
    <groupId>com.vaadin.componentfactory</groupId>
    <artifactId>vcf-v8-combo-box</artifactId>
    <version>${component.version}</version>
</dependency>
```

## Missing features or bugs

You can report any issue or missing feature on [github](https://github.com/vaadin-component-factory/vcf-v8-combo-box/issues).

## Licence

Apache License 2.0

