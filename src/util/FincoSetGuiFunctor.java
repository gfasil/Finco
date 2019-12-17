package util;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class FincoSetGuiFunctor implements SetGulFunctor {
    List<String> items;
    public FincoSetGuiFunctor( List<String> items){
        this.items=items;
    }
    @Override
    public void setCols(DefaultTableModel model) {
      items.stream().forEach(x->model.addColumn(x));
    }

    @Override
    public void setButtons(String button1, String button2) {

    }
}
