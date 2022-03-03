package Model.ownership;

//hi

// Может владеть юнитом
public interface CanOwnUnit {

    Unit getUnit();
    boolean isEmpty();

	//whats good
    boolean putUnit(Unit init);
    Unit extractUnit(); //new initial
}
