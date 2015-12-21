package by.gsu.epamlab;

import by.gsu.epamlab.beans.Result;

public interface IResultDAO {
	Result nextResult();
	boolean hasResult();
	void closeReader();
}
