package be.josimon.GSDAO;

import java.sql.Connection;
import java.util.List;

public abstract class DAO<T> {
	protected Connection connect = null;
	
	public DAO(Connection conn) {
		this.connect = conn;
	}	
	 public abstract boolean Create(T obj);
	 public abstract boolean Delete(T obj);
	 public abstract T Update(T obj);
	 public abstract T Find(T obj);
	 public abstract List<T> getAll(T obj);
	 public abstract List<T> getAll();
}
