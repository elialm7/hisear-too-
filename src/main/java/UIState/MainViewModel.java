package UIState;

import Entities.ObservableProperty;

import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.util.Objects;

public class MainViewModel {


    //information section

    private ObservableProperty<String> titleProperty = new ObservableProperty<>("");
    private ObservableProperty<String> urlProperty = new ObservableProperty<>("");
    private ObservableProperty<String>  tagProperty = new ObservableProperty<>("");
    private ObservableProperty<Boolean> readStatusProperty = new ObservableProperty<>(Boolean.FALSE);
    private ObservableProperty<Date> dateProperty = new ObservableProperty<>();
    private ObservableProperty<String>  notesProperty = new ObservableProperty<>("");


    //status info section

    private ObservableProperty<String>  currentOperationProperty = new ObservableProperty<>("Current Operation");
    private ObservableProperty<String> currentDateProperty = new ObservableProperty<>("Current Date");

    //Histories-searches section

    private ObservableProperty<String> searchProperty = new ObservableProperty<>("");
    private ObservableProperty<Boolean> byTitleproperty = new ObservableProperty<>(Boolean.FALSE);
    private ObservableProperty<Boolean> byUrlProperty = new ObservableProperty<>(Boolean.FALSE);
    private ObservableProperty<Boolean> byTagProperty = new ObservableProperty<>(Boolean.FALSE);
    private ObservableProperty<Boolean> byNotesProperty = new ObservableProperty<>(Boolean.FALSE);
    private ObservableProperty<Boolean> byIsReadProperty = new ObservableProperty<>(Boolean.FALSE);
    private ObservableProperty<Date> byRange = new ObservableProperty<>();

    // table
    private DefaultTableModel tablemodel = new DefaultTableModel();

    public MainViewModel() {
    }

    public ObservableProperty<String> getTitleProperty() {
        return titleProperty;
    }

    public void setTitleProperty(ObservableProperty<String> titleProperty) {
        this.titleProperty = titleProperty;
    }

    public ObservableProperty<String> getUrlProperty() {
        return urlProperty;
    }

    public void setUrlProperty(ObservableProperty<String> urlProperty) {
        this.urlProperty = urlProperty;
    }

    public ObservableProperty<String> getTagProperty() {
        return tagProperty;
    }

    public void setTagProperty(ObservableProperty<String> tagProperty) {
        this.tagProperty = tagProperty;
    }

    public ObservableProperty<Boolean> getReadStatusProperty() {
        return readStatusProperty;
    }

    public void setReadStatusProperty(ObservableProperty<Boolean> readStatusProperty) {
        this.readStatusProperty = readStatusProperty;
    }

    public ObservableProperty<Date> getDateProperty() {
        return dateProperty;
    }

    public void setDateProperty(ObservableProperty<Date> dateProperty) {
        this.dateProperty = dateProperty;
    }

    public ObservableProperty<String> getNotesProperty() {
        return notesProperty;
    }

    public void setNotesProperty(ObservableProperty<String> notesProperty) {
        this.notesProperty = notesProperty;
    }

    public ObservableProperty<String> getCurrentOperationProperty() {
        return currentOperationProperty;
    }

    public void setCurrentOperationProperty(ObservableProperty<String> currentOperationProperty) {
        this.currentOperationProperty = currentOperationProperty;
    }

    public ObservableProperty<String> getCurrentDateProperty() {
        return currentDateProperty;
    }

    public void setCurrentDateProperty(ObservableProperty<String> currentDateProperty) {
        this.currentDateProperty = currentDateProperty;
    }

    public ObservableProperty<String> getSearchProperty() {
        return searchProperty;
    }

    public void setSearchProperty(ObservableProperty<String> searchProperty) {
        this.searchProperty = searchProperty;
    }

    public ObservableProperty<Boolean> getByTitleproperty() {
        return byTitleproperty;
    }

    public void setByTitleproperty(ObservableProperty<Boolean> byTitleproperty) {
        this.byTitleproperty = byTitleproperty;
    }

    public ObservableProperty<Boolean> getByUrlProperty() {
        return byUrlProperty;
    }

    public void setByUrlProperty(ObservableProperty<Boolean> byUrlProperty) {
        this.byUrlProperty = byUrlProperty;
    }

    public ObservableProperty<Boolean> getByTagProperty() {
        return byTagProperty;
    }

    public void setByTagProperty(ObservableProperty<Boolean> byTagProperty) {
        this.byTagProperty = byTagProperty;
    }

    public ObservableProperty<Boolean> getByNotesProperty() {
        return byNotesProperty;
    }

    public void setByNotesProperty(ObservableProperty<Boolean> byNotesProperty) {
        this.byNotesProperty = byNotesProperty;
    }

    public ObservableProperty<Boolean> getByIsReadProperty() {
        return byIsReadProperty;
    }

    public void setByIsReadProperty(ObservableProperty<Boolean> byIsReadProperty) {
        this.byIsReadProperty = byIsReadProperty;
    }

    public ObservableProperty<Date> getByRange() {
        return byRange;
    }

    public void setByRange(ObservableProperty<Date> byRange) {
        this.byRange = byRange;
    }

    public DefaultTableModel getTablemodel() {
        return tablemodel;
    }

    public void setTablemodel(DefaultTableModel tablemodel) {
        this.tablemodel = tablemodel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MainViewModel that = (MainViewModel) o;
        return Objects.equals(titleProperty, that.titleProperty) && Objects.equals(urlProperty, that.urlProperty) && Objects.equals(tagProperty, that.tagProperty) && Objects.equals(readStatusProperty, that.readStatusProperty) && Objects.equals(dateProperty, that.dateProperty) && Objects.equals(notesProperty, that.notesProperty) && Objects.equals(currentOperationProperty, that.currentOperationProperty) && Objects.equals(currentDateProperty, that.currentDateProperty) && Objects.equals(searchProperty, that.searchProperty) && Objects.equals(byTitleproperty, that.byTitleproperty) && Objects.equals(byUrlProperty, that.byUrlProperty) && Objects.equals(byTagProperty, that.byTagProperty) && Objects.equals(byNotesProperty, that.byNotesProperty) && Objects.equals(byIsReadProperty, that.byIsReadProperty) && Objects.equals(byRange, that.byRange) && Objects.equals(tablemodel, that.tablemodel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titleProperty, urlProperty, tagProperty, readStatusProperty, dateProperty, notesProperty, currentOperationProperty, currentDateProperty, searchProperty, byTitleproperty, byUrlProperty, byTagProperty, byNotesProperty, byIsReadProperty, byRange, tablemodel);
    }
}
