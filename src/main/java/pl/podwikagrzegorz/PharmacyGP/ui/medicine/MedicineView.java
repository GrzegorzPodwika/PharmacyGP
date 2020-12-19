package pl.podwikagrzegorz.PharmacyGP.ui.medicine;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.crudui.crud.impl.GridCrud;
import pl.podwikagrzegorz.PharmacyGP.backend.entity.Medicine;
import pl.podwikagrzegorz.PharmacyGP.backend.service.MedicineService;
import pl.podwikagrzegorz.PharmacyGP.ui.MainView;

@Route(value = "Medicine", layout = MainView.class)
@PageTitle("Medicine")
public class MedicineView extends VerticalLayout {

    public MedicineView(MedicineService medicineService) {
        GridCrud<Medicine> crud = new GridCrud<>(Medicine.class, medicineService);
        add(crud);
        setSizeFull();
    }
}
