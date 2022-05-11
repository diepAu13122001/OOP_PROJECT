package Personel_Worker;

public class TimekeepingController {
    TimekeepingModel model;
    TimekeepingView view;

   public TimekeepingController (TimekeepingModel model) {
       this.model = model;
       this.view = new TimekeepingView(this, model);
       view.createView();
   }

    public static void main(String[] args) {
        TimekeepingModel model = new TimekeepingModel();
        TimekeepingController controller = new TimekeepingController(model);
    }
}
