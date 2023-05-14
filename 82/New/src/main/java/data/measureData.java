package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="info")
public class measureData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	private float distance;
	private long time;
	public measureData(){}
	public measureData(float distance, long time) {
		super();
		this.distance = distance;
		this.time = time;
	}
	public float getDistance() {
		return distance;
	}
	public void setDistance(float distance) {
		this.distance = distance;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}


}
