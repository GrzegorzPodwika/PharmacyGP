package pl.podwikagrzegorz.PharmacyGP.ui.prescription;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.TextRenderer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.crudui.crud.impl.GridCrud;
import org.vaadin.crudui.form.impl.field.provider.CheckBoxGroupProvider;
import org.vaadin.crudui.form.impl.field.provider.ComboBoxProvider;
import pl.podwikagrzegorz.PharmacyGP.backend.entity.Medicine;
import pl.podwikagrzegorz.PharmacyGP.backend.entity.Prescription;
import pl.podwikagrzegorz.PharmacyGP.backend.entity.User;
import pl.podwikagrzegorz.PharmacyGP.backend.service.MedicineService;
import pl.podwikagrzegorz.PharmacyGP.backend.service.PrescriptionService;
import pl.podwikagrzegorz.PharmacyGP.backend.service.UserService;
import pl.podwikagrzegorz.PharmacyGP.ui.MainView;

import java.util.stream.Collectors;

@Route(value = "Prescription", layout = MainView.class)
@PageTitle("Prescription")
public class PrescriptionView extends VerticalLayout {

    public PrescriptionView(PrescriptionService service, MedicineService medicineService, UserService userService) {
        GridCrud<Prescription> crud = new GridCrud<>(Prescription.class, service);
        crud.getGrid().setColumnReorderingAllowed(true);

   /*     crud.getCrudFormFactory().setFieldProvider("drugs",
                new CheckBoxGroupProvider<>(medicineService.findAll()));*/
        crud.getCrudFormFactory().setFieldProvider("drugs",
                new CheckBoxGroupProvider<>("Drugs", medicineService.findAll().stream().filter(Medicine::isOnPrescription).collect(Collectors.toList()), Medicine::getName));
/*        crud.getCrudFormFactory().setFieldProvider("user",
                new ComboBoxProvider<>(userService.findAll()));*/
        crud.getCrudFormFactory().setFieldProvider("user",
                new ComboBoxProvider<>("User", userService.findAll(), new TextRenderer<>(User::getName), User::getName));
        add(crud);
        setSizeFull();
    }

}
