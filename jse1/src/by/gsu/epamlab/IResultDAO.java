package by.gsu.epamlab;

public interface IResultDAO {
	Result nextResult();
	boolean hasResult();
	void closeReader();

}
