/*
 *  Gabinet Weterynaryjny - projekt zaliczeniowy
 */
package pl.gw.view;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import pl.gw.model.Supply;
import pl.gw.domain.SupplyType;
import pl.gw.model.Animal;
import pl.gw.model.Client;
import pl.gw.model.VeterinaryOffice;
import pl.gw.model.management.AnimalBean;
import pl.gw.model.management.ClientBean;
import pl.gw.model.management.SupplyBean;
import pl.gw.model.management.VeterinaryOfficeBean;

/**
 *
 * @author Putas
 */

@ManagedBean
public class AnimalController implements Serializable {

    @Inject
    private AnimalBean animalBean;

    private Animal animal = new Animal();
    private List<Animal> animalList;

    public AnimalController() {
    }

    @PostConstruct
    public void init() {
        animalList = animalBean.findAll();
    }

    public void addAnimal() {
        animalBean.save(animal);
//        return "#";
    }

    public AnimalBean getAnimalBean() {
        return animalBean;
    }

    public void setAnimalBean(AnimalBean animalBean) {
        this.animalBean = animalBean;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public List<Animal> getAnimalList() {
        return animalList;
    }

    public void setAnimalList(List<Animal> animalList) {
        this.animalList = animalList;
    }

    public List<Animal> findAll() {
        return animalBean.findAll();
    }

    public Animal findById(int value) {
        return animalBean.find(value);
    }
}
