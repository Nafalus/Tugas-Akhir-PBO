
import java.util.*;
import Model.*;
import Controller.*;
import View.*;

public class Main {
    public static void main(String[] args) {
        ModelAdmin modelAdmin = new ModelAdmin();
        ControllerAdmin controllerAdmin = new ControllerAdmin(modelAdmin);
        ViewTest viewTest = new ViewTest(controllerAdmin);

        viewTest.Menu();
    }
}
