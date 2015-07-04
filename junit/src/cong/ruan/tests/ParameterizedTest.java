package cong.ruan.tests;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParameterizedTest {
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { { 0, 0 }, { 1, 1 }, { 2, 1 },
				{ 3, 2 }, { 4, 3 }, { 5, 5 }, { 6, 8 } });
	}

	@Parameter(0)
	public int fInput;

	@Parameter(1)
	public int fExpected;

	@Test
	public void test() {
		Assert.assertEquals(fExpected, Com.com(fInput));
	}
}

class Com
{
	public static int com(int input)
	{
		return input;
	}
}