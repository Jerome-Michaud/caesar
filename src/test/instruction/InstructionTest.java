package test.instruction;

import instruction.*;

public class InstructionTest {
	public static void test()
	{
		//System.out.printf("chat");
		
		InstructionStructure n1 = new InstructionTache();
		Instruction n2 = new InstructionMoteurRotate();
		Instruction n3 = new InstructionMoteurOff();
		Instruction n4 = new InstructionMoteurMov();
		n1.inserer(0,n2);
		n1.inserer(1,n3);
		n1.inserer(2,n4);
		System.out.println(n1);
		
		
		
	}
	
	public static void main(String [] args)
	{
		InstructionTest.test();
	}

}
