package controllers;

import data.*;
import javafx.beans.property.*;
import javafx.beans.value.ObservableValue;

import java.time.LocalDate;

public class OrganizationProp {
    private LongProperty id;
    private StringProperty name;
    private ObjectProperty<LocalDate> creationDate;
    private FloatProperty annualTurnover;
    private StringProperty fullName;
    private LongProperty employeesCount;
    private ObjectProperty<OrganizationType> type;
    private StringProperty owner;
    private DoubleProperty tX;
    private LongProperty tY;
    private LongProperty tZ;
    private FloatProperty x;
    private FloatProperty y;
    private StringProperty street;
    private StringProperty zipCode;


    public OrganizationProp(Long id, String name, LocalDate creationDate, Float annualTurnover, String fullName, Long employeesCount, OrganizationType type, String owner, Double tX, Long tY, Long tZ, Float x, Float y, String street, String zipCode) {
        this.id = new SimpleLongProperty(id);
        this.name = new SimpleStringProperty(name);
        this.creationDate = new SimpleObjectProperty<>(creationDate);
        this.annualTurnover = new SimpleFloatProperty(annualTurnover);
        this.fullName = new SimpleStringProperty(fullName);
        this.employeesCount = new SimpleLongProperty(employeesCount);
        this.type = new SimpleObjectProperty<>(type);
        this.owner = new SimpleStringProperty(owner);
        this.tX = new SimpleDoubleProperty(tX);
        this.tY = new SimpleLongProperty(tY);
        this.tZ = new SimpleLongProperty(tZ);
        this.x = new SimpleFloatProperty(x);
        this.y = new SimpleFloatProperty(y);
        this.street = new SimpleStringProperty(street);
        this.zipCode = new SimpleStringProperty(zipCode);
    }


    public static OrganizationProp getOrgProp(Organization or) {
        return new OrganizationProp(or.getId(), or.getName(), or.getCreationDate(), or.getAnnualTurnover(),
                or.getFullName(), or.getEmployeesCount(), or.getType(), or.getOwner(),
                or.getPostalAddress().getTown().getX(),
                or.getPostalAddress().getTown().getY(),
                or.getPostalAddress().getTown().getZ(),
                or.getCoordinates().getX(),
                or.getCoordinates().getY(),
                or.getPostalAddress().getStreet(),
                or.getPostalAddress().getZipCode());
    }

    public long getId() {
        return id.get();
    }

    public LongProperty idProperty() {
        return id;
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }


    public LocalDate getCreationDate() {
        return creationDate.get();
    }

    public ObjectProperty<LocalDate> creationDateProperty() {
        return creationDate;
    }

    public float getAnnualTurnover() {
        return annualTurnover.get();
    }

    public FloatProperty annualTurnoverProperty() {
        return annualTurnover;
    }

    public String getFullName() {
        return fullName.get();
    }

    public StringProperty fullNameProperty() {
        return fullName;
    }

    public long getEmployeesCount() {
        return employeesCount.get();
    }

    public LongProperty employeesCountProperty() {
        return employeesCount;
    }

    public OrganizationType getType() {
        return type.get();
    }

    public ObjectProperty<OrganizationType> typeProperty() {
        return type;
    }

    public String getOwner() {
        return owner.get();
    }

    public StringProperty ownerProperty() {
        return owner;
    }

    public double gettX() {
        return tX.get();
    }

    public DoubleProperty tXProperty() {
        return tX;
    }

    public long gettY() {
        return tY.get();
    }

    public LongProperty tYProperty() {
        return tY;
    }

    public long gettZ() {
        return tZ.get();
    }

    public LongProperty tZProperty() {
        return tZ;
    }

    public float getX() {
        return x.get();
    }

    public FloatProperty xProperty() {
        return x;
    }

    public float getY() {
        return y.get();
    }

    public FloatProperty yProperty() {
        return y;
    }

    public String getStreet() {
        return street.get();
    }

    public StringProperty streetProperty() {
        return street;
    }

    public String getZipCode() {
        return zipCode.get();
    }

    public StringProperty zipCodeProperty() {
        return zipCode;
    }


}
