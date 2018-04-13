package com.example.demo.Components;

import com.example.demo.domen.EventDAO;
import com.example.demo.domen.EventDTO;
import com.example.demo.domen.EventRepository;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.ui.Grid;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.components.grid.HeaderRow;

import java.util.ArrayList;

public class MainGrid extends VerticalLayout {

    //private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    public MainGrid(EventRepository eventRepository, EventDAO eventDAO) {
       // VerticalLayout root = new VerticalLayout();
        this.addStyleName("catfinder");
        this.setMargin(true);
        this.setWidth("100%");

        ArrayList<EventDTO> arrayList = (ArrayList<EventDTO>) eventRepository.findAll();

        Grid<EventDTO> grid = new Grid<>();
        grid.setItems( arrayList);
        grid.addColumn(EventDTO::getId).setId("ID") .setCaption("ID");
        grid.addColumn(EventDTO::getDescription).setId("Description") .setCaption("Description");
        //grid.getColumn("Description").setEditable(true);
        grid.addColumn(EventDTO::getEventDt).setId("EventDt") .setCaption("EventDt");
        grid.addColumn(EventDTO::getType).setId("Type") .setCaption("Type");
        grid.setWidth("100%");

        //HeaderRow hdr = grid.getHeaderRow(0);
        HeaderRow filterRow = grid.appendHeaderRow();
        TextField txtFld_Description = new TextField();
        txtFld_Description.setHeight("70%");

        txtFld_Description.addValueChangeListener(
                event -> { grid.setItems((ArrayList<EventDTO>) eventDAO.findByDescriptionLike(txtFld_Description.getValue())); } );
        txtFld_Description.setValueChangeMode(ValueChangeMode.BLUR);

        filterRow.getCell("Description").setComponent( txtFld_Description);
        this.addComponent(grid);
        /*Notification.show("Tu-Tu");*/
    }

}
