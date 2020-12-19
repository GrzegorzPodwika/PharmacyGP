package pl.podwikagrzegorz.PharmacyGP.ui.order;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.checkbox.CheckboxGroupVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import pl.podwikagrzegorz.PharmacyGP.backend.entity.Employee;
import pl.podwikagrzegorz.PharmacyGP.backend.entity.Medicine;
import pl.podwikagrzegorz.PharmacyGP.backend.entity.Order;
import pl.podwikagrzegorz.PharmacyGP.backend.entity.User;
import pl.podwikagrzegorz.PharmacyGP.backend.service.*;
import pl.podwikagrzegorz.PharmacyGP.ui.MainView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Route(value = "Order", layout = MainView.class)
@PageTitle("Order")
public class OrderView extends VerticalLayout {
    private final Grid<Order> grid = new Grid<>(Order.class);
    private final OrderService orderService;
    private final EmployeeService employeeService;
    private final MedicineService medicineService;
    private final UserService userService;
    private final PrescriptionService prescriptionService;

    private final HorizontalLayout horizontalLayout = new HorizontalLayout();
    private final IntegerField orderIdField = new IntegerField("OrderId");
    private final ComboBox<Employee> employeeComboBox = new ComboBox<>();
    private final ComboBox<User> userComboBox = new ComboBox<>();
    private final CheckboxGroup<Medicine> medicineCheckboxGroup = new CheckboxGroup<>();
    private final List<Medicine> listOfUnPrescriptionMedicines = new ArrayList<>();

    public OrderView(OrderService orderService, EmployeeService employeeService,
                     MedicineService medicineService, UserService userService,
                     PrescriptionService prescriptionService) {
        this.orderService = orderService;
        this.employeeService = employeeService;
        this.medicineService = medicineService;
        this.userService = userService;
        this.prescriptionService = prescriptionService;

        addClassName("order-view");
        setSizeFull();
        configureHorizontalLayout();
        configureGrid();

        add(horizontalLayout, grid);

        updateGrid();
    }

    private void configureHorizontalLayout() {
        horizontalLayout.add(orderIdField);

        employeeComboBox.setLabel("Employee");
        employeeComboBox.setItemLabelGenerator(Employee::getName);
        employeeComboBox.setItems(employeeService.findAll());
        horizontalLayout.add(employeeComboBox);

        userComboBox.setLabel("Client");
        userComboBox.setItemLabelGenerator(User::getName);
        userComboBox.setItems(userService.findAll());
        userComboBox.addValueChangeListener(event -> {
           if (event.getValue() == null) {
               medicineCheckboxGroup.setItems(listOfUnPrescriptionMedicines);
           } else {
                var prescription = prescriptionService.find(event.getValue());
                if (prescription != null) {
                    List<Medicine> filteredListOfMedicines = Stream.concat(listOfUnPrescriptionMedicines.stream(), new ArrayList<>(prescription.getDrugs()).stream())
                            .collect(Collectors.toList());
                    medicineCheckboxGroup.setItems(filteredListOfMedicines);
                } else {
                    medicineCheckboxGroup.setItems(listOfUnPrescriptionMedicines);
                }
           }
        });
        horizontalLayout.add(userComboBox);

        medicineService.findAll().stream().filter(med -> !med.isOnPrescription()).forEach(listOfUnPrescriptionMedicines::add);
        medicineCheckboxGroup.setLabel("Medicine");
        medicineCheckboxGroup.setItems(listOfUnPrescriptionMedicines);
        medicineCheckboxGroup.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);
        horizontalLayout.add(medicineCheckboxGroup);

        Button addButton = new Button("Dodaj", new Icon(VaadinIcon.PLUS));
        addButton.setIconAfterText(true);
        addButton.addClickListener(event -> {
            if (orderIdField.getValue() == null) {
                Notification.show("Wypełnij orderId!");
            } else if(employeeComboBox.getValue() == null) {
                Notification.show("Wybierz pracownika!");
            } else if(userComboBox.getValue() == null) {
                Notification.show("Wybierz klienta!");
            } else if(medicineCheckboxGroup.getSelectedItems().size() == 0) {
                Notification.show("Wybierz coś do kupienia!");
            } else {
                var orderId = orderIdField.getValue();
                var employee = employeeComboBox.getValue();
                var user = userComboBox.getValue();
                var chosenDrugs = medicineCheckboxGroup.getSelectedItems();
                var sumOfPurchase = chosenDrugs.stream().mapToDouble(Medicine::getPrice).sum();
                var now = LocalDate.now();
                Order newOrder = new Order(orderId, employee, user, chosenDrugs, sumOfPurchase, now);

                orderService.add(newOrder);
                clearViews();
                updateGrid();
            }

        });
        horizontalLayout.add(addButton);
    }

    private void clearViews() {
        orderIdField.clear();
        employeeComboBox.clear();
        userComboBox.clear();
        medicineCheckboxGroup.clear();
    }

    private void configureGrid() {
        grid.addClassName("order-grid");
        grid.setSizeFull();
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
    }

    private void updateGrid() {
        grid.setItems(orderService.findAll());
    }
}

