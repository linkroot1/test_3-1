package Model.units;
// Первые изменения Рыбчиц
import Model.gamefield.Direction;
import Model.gamefield.Cell;
import Model.updatableunit.UpdatableUnit;
// Рыбчиц изменения 2
// Робот, который может перемещаться по полю и взаимодействовать с другими юнитами
public class Robot extends UpdatableUnit {

    // ------------------------------- Заряд ---------------------------------
    private int _charge = 25;
    // Третьи изменения Рыбчиц
    private static final int REQUIRED_CHARGE_FOR_MOVE = 1;
    
    public int charge() {
        return _charge;
    }
    // Рыбчиц этап 5
    public boolean isAvailableCharge(int chargeQuery) {
        return chargeQuery <= _charge;
    }
    
    protected int reduceCharge(int chargeQuery) {
        int retrievedCharge = Math.min(_charge, chargeQuery);
        _charge -= retrievedCharge;
        return retrievedCharge;
    }

    // --------------------------- Перемещение ------------------------------------
    public boolean canMoveTo(Cell to) {
        return to.isEmpty();
    }
    
    public void move(Direction direct) {
       
        Cell pos = typedOwner();
        
        if(!isAvailableCharge(REQUIRED_CHARGE_FOR_MOVE)) {
            return;
        }
        
        Cell newPos = pos.neighbor(direct);
        if(newPos == null) {
            return;
        }

        if(!canMoveTo(newPos)) {
            return;
        }
        
        pos.extractUnit();
        newPos.putUnit(this);
        reduceCharge(REQUIRED_CHARGE_FOR_MOVE);

        fireStateChanged();
    }

    // -----------------------------------------------------------------

    @Override
    public String toString() {

        String msg;
        msg = "R(" + charge() + ")";

        return msg;
    }
}
