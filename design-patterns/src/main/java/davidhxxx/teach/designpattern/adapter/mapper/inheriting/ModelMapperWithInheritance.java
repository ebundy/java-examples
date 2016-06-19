package davidhxxx.teach.designpattern.adapter.mapper.inheriting;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

public class ModelMapperWithInheritance extends ModelMapper {

    public List<String> mapToListOfString(List<Integer> integers) {
	List<String> list = new ArrayList<String>();
	for (Integer integer : integers) {
	    list.add(String.valueOf(integer));
	}
	return list;
    }

    public List<Integer> mapToListOfInteger(List<String> strings) {
	List<Integer> list = new ArrayList<Integer>();
	for (String integer : strings) {
	    list.add(Integer.valueOf(integer));
	}
	return list;
    }

}
