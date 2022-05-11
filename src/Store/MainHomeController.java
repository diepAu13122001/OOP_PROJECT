package Store;

public class MainHomeController {
	MainHomeView view;

	public MainHomeController() {
		this.view = new MainHomeView(this);
		view.createView();
	}

	public static void main(String[] args) {
		MainHomeController mc= new MainHomeController();
	}
}
