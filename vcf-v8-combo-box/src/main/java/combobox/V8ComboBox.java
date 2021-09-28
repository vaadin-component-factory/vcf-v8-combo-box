package combobox;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.combobox.ComboBox;
import java.io.Serializable;
import java.util.Collection;

public class V8ComboBox<T> extends ComboBox<T> {

  public V8ComboBox(String label, Collection<T> items) {
    super(label, items);
  }

  public V8ComboBox() {
  }

  public V8ComboBox(int pageSize) {
    super(pageSize);
  }

  public V8ComboBox(String label) {
    super(label);
  }

  public V8ComboBox(String label, T... items) {
    super(label, items);
  }

  @Override
  protected void onAttach(AttachEvent attachEvent) {
      super.onAttach(attachEvent);
      this.getElement().getNode().runWhenAttached((ui) -> {
        ui.beforeClientResponse(this, (context) -> {
          ui.getPage().executeJs(
            "$0._loadingChanged = (loading) => {" +
            " if (loading) {" +
            "   $0._focusedIndex = -1;" +
            " } else if ($0.filteredItems && $0.filteredItems.length > 0 && !$0.selectedItem) {" +
            "   $0._focusedIndex = 0;" +
            " }" +
            "};" +
            "var indexOfLabel = $0.$.overlay.indexOfLabel.bind($0.$.overlay);" + 
            "$0.$.overlay.indexOfLabel = (label) => {" +
            " var i = indexOfLabel(label);" +
            " return  i<0 && $0.$.overlay._items && label.length ? 0 : i;" +
            "}"
            , 
            new Serializable[]{this.getElement()});
                    ui.getPage().executeJs(
            "var _selectedItemChanged = $0._selectedItemChanged.bind($0);  " +
            "$0._selectedItemChanged = (selectedItem, itemLabelPath) => { " +
              "_selectedItemChanged(selectedItem, itemLabelPath);"+

              "$0.$.overlay._selectedItem = selectedItem;"+
              "if ($0.filteredItems && $0.$.overlay._items) {"+
                "if(selectedItem == null) {"+
                  "$0._focusedIndex = 0;"+
                "} else {"+
                  "$0._focusedIndex = $0.filteredItems.indexOf(selectedItem);"+
                "}"+
              "}"+
            "}", new Serializable[]{this.getElement()});
        });
    });
  }
  
}
