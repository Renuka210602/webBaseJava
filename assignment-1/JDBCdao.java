package practise.jdbc;

import java.util.Collection;

public interface JDBCdao<T,K> {
	Collection<T> getAll();
	T getOne(K key);
	void add(T t);
}
