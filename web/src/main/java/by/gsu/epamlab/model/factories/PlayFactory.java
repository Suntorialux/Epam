/**
 * 
 */
package by.gsu.epamlab.model.factories;

import by.gsu.epamlab.model.ifaces.IPlayDAO;
import by.gsu.epamlab.model.impl.ReaderXMLImpl;

/**
 * @author Yahorau Andrei
 *
 */
public class PlayFactory {

	public static IPlayDAO getClassFromFactory() {

		return new ReaderXMLImpl();
	}
}
