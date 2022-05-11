package Menu.Controller;

import Menu.Model.DishDetailModel;
import Menu.View.DishDetailView;

public class DishDetailController {
    DishDetailModel model;
    DishDetailView view;

    public DishDetailController(DishDetailModel model) {
        this.model = model;
        this.view = new DishDetailView(this, model);
        view.createView();
    }

    public static void main(String[] args) {
        DishDetailModel model = new DishDetailModel();
        DishDetailController controller = new DishDetailController(model);
    }
}
