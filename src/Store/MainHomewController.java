package Store;

public class MainHomewController {
	MainHomeView view;

	public MainHomewController() {
		this.view = new MainHomeView(this);
		view.createView();
	}

	public static void main(String[] args) {
		MainHomewController mc= new MainHomewController();
	}
}
