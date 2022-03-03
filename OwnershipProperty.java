package Model.ownership;

// Свойства обладания юнитом (1 коммит в мастер ветку)
public class OwnershipProperty implements CanOwnUnit {

    // ---------------------- Владелец свойства ---------------------
    private final CanOwnUnit _owner; //(2 коммит в мастер ветку Павленко)

    public OwnershipProperty(CanOwnUnit owner) {
        if(owner == null) {
            throw new NullPointerException();
        }
        _owner = owner;//(commit 5 )
    }

    // ---------------------- Юнит, которым владеем ----------------
    private Unit _unit = null;

    public boolean putUnit(Unit unit){
        boolean ok = false;

        if(_unit == null) {
            ok = unit.setOwner(_owner);
            if( ok ) {
                _unit = unit;
            }
        }

        return ok;
    }

    public Unit extractUnit(){
        if( !isEmpty() ) {     // !!!! У владельца НЕ может быть двух юнитов (коммит 1 в свою ветку)
            _unit.removeOwner();
        }

        Unit removedUnit = _unit;
        _unit = null;

        return removedUnit;
    }

    public Unit getUnit() {
        return _unit;
    }

    public boolean isEmpty() {
        return _unit == null;
    }
}
