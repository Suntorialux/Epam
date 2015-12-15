package by.gsu.epamlab;

import by.gsu.epamlab.results.Result;

public interface IResultDAO {
	Result nextResult();
	boolean hasResult();
	void closeReader();

}
