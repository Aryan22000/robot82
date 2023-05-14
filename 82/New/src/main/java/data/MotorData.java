package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="speeds")
public class MotorData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	private int Speed;

    public MotorData(int speed) {
		super();
		Speed = speed;
	}
    public MotorData() {
        super();
    }

	public int getSpeed() {
		return Speed;
	}

	public void setSpeed(int speed) {
		Speed = speed;
	}

}
