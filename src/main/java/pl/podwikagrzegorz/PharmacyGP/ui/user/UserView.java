package pl.podwikagrzegorz.PharmacyGP.ui.user;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.crudui.crud.impl.GridCrud;
import pl.podwikagrzegorz.PharmacyGP.backend.entity.User;
import pl.podwikagrzegorz.PharmacyGP.backend.service.UserService;
import pl.podwikagrzegorz.PharmacyGP.ui.MainView;

@Route(value = "users", layout = MainView.class)
@PageTitle("Klienci")
public class UserView extends VerticalLayout {

    public UserView(UserService userService) {
        GridCrud<User> crud = new GridCrud<User>(User.class, userService);
        add(crud);
        setSizeFull();
    }
}
