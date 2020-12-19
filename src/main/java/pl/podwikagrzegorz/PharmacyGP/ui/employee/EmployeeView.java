package pl.podwikagrzegorz.PharmacyGP.ui.employee;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.crudui.crud.impl.GridCrud;
import pl.podwikagrzegorz.PharmacyGP.backend.entity.Employee;
import pl.podwikagrzegorz.PharmacyGP.backend.service.EmployeeService;
import pl.podwikagrzegorz.PharmacyGP.ui.MainView;

@Route(value = "employees", layout = MainView.class)
@PageTitle("Pracownicy")
public class EmployeeView extends VerticalLayout {

    public EmployeeView(EmployeeService service) {
        GridCrud<Employee> crud = new GridCrud<Employee>(Employee.class, service);
        add(crud);
        setSizeFull();
    }
}
