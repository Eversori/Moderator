
package lib.collections;

import java.util.HashMap;

public class Collection<K1, K2, V>
{
	private HashMap<K1, V>	firstKeyValue;
	private HashMap<K2, V>	secondKeyValue;

	public Collection()
	{
		super();
		this.firstKeyValue = new HashMap<K1, V>();
		this.secondKeyValue = new HashMap<K2, V>();
	}

	public boolean add(V value, K1 key1, K2 Key2)
	{
		if (firstKeyValue.containsValue(value) || secondKeyValue.containsValue(value))
		{
			return false;
		}
		else
		{
			firstKeyValue.put(key1, value);
			secondKeyValue.put(Key2, value);
			return false;
		}
	}

	public V getByFirstKey(K1 key)
	{
		V val = firstKeyValue.get(key);
		return val;
	}

	public V getBySecondKey(K2 key)
	{
		V val = secondKeyValue.get(key);
		return val;
	}

	public boolean containsFirstKey(K1 key)
	{
		return firstKeyValue.containsKey(key);
	}

	public boolean containsSecondKey(K2 key)
	{
		return secondKeyValue.containsKey(key);
	}

	public boolean isEmpty()
	{
		if (firstKeyValue.isEmpty() || secondKeyValue.isEmpty())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public void clear()
	{
		firstKeyValue.clear();
		secondKeyValue.clear();
	}

	public void remove(K1 key)
	{
		firstKeyValue.remove(key);
	}
}
