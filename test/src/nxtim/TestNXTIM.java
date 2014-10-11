package nxtim;

import org.junit.Test;
import static org.junit.Assert.*;

import nxtim.exception.NXTIMBadTypeElementException;
import nxtim.instruction.*;

public class TestNXTIM {
	
	@Test
	public void testNonLogiqueException() {
		boolean exception = false;
		try {
			new NonLogique(new VariableConstante(TypeElement.DOUBLE, "2"));
		} catch(NXTIMBadTypeElementException e) {
			exception = true;
			assertEquals("Information de l'exception incorrecte.", TypeElement.DOUBLE, e.getTypeElement());
		}
		assertTrue("Une NXTIMBadTypeElementException devrait être levée.", exception);
	}

	@Test
	public void testCondition() {	
		Condition con = new Condition(Operateur.OU, new VariableConstante(TypeElement.BOOL, "1"), new VariableConstante(TypeElement.BOOL, "0")) ;
		boolean exception = false;
		try {
			con.setMembreDroit(new VariableConstante(TypeElement.INT, "1"));
		} catch(NXTIMBadTypeElementException e) {
			exception = true;
			assertEquals("Information de l'exception incorrecte.", TypeElement.INT, e.getTypeElement());
		}
		assertTrue("Une NXTIMBadTypeElementException devrait être levée.", exception);
	}

}
