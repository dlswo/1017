package org.zerock.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;
import org.zerock.domain.StoreVO;
import org.zerock.domain.Todo;

@Service
public class TodoServiceImpl implements TodoService {
	
	private Map<String, List<StoreVO>> storeMap;
	
	public TodoServiceImpl() {
		
		storeMap = new HashMap<>();
		
		List<StoreVO> korList = new ArrayList<>();
		korList.add(new StoreVO(1,"청진식당"));
		korList.add(new StoreVO(2,"뚝배기집"));
		korList.add(new StoreVO(3,"마마된장"));
		
		storeMap.put("kor", korList);
		
		List<StoreVO> jpList = new ArrayList<>();
		jpList.add(new StoreVO(11,"이춘복참치"));
		jpList.add(new StoreVO(22,"가쓰야"));
		jpList.add(new StoreVO(33,"갓덴스시"));
		
		storeMap.put("jp", jpList);
		
	}
	
	
	
	@Override
	public List<Todo> getList() {

		ArrayList<Todo> list = new ArrayList<>();
		
		IntStream.range(1,100)
		  .forEach( i -> {
			  Todo todo = new Todo();
			  todo.setTno(i);
			  todo.setTitle("TITEL "+ i);
			  list.add(todo);
		  });
		
		return list;
	
	}



	@Override
	public List<StoreVO> getStores(String cat) {

		return storeMap.get(cat);
	}

}



