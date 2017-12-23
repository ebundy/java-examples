package davidhxxx.teach.designpattern.adapter.mapper.inheriting;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class ModelMapperWithInheritanceTest {

	private ModelMapperWithInheritance modelMapper;

	@Before
	public void before() {
		modelMapper = new ModelMapperWithInheritance();
	}

	@Test
	public void mapToListOfInteger_map_strings_to_integers() throws Exception {
		List<Integer> actualIntegers = modelMapper.mapToListOfInteger(Arrays.asList("00", "15", "-15"));
		List<Integer> expectedIntegers = Arrays.asList(new Integer(0), new Integer(15), new Integer(-15));

		Assert.assertEquals(expectedIntegers, actualIntegers);
	}

	@Test
	public void mapToListOString_map_integers_to_strings() throws Exception {
		List<String> actualStrings = modelMapper.mapToListOfString(Arrays.asList(new Integer(0), new Integer(15), new Integer(-15)));
		List<String> expectedStrings = Arrays.asList("0", "15", "-15");

		Assert.assertEquals(expectedStrings, actualStrings);
	}

}
