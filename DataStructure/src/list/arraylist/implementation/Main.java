package list.arraylist.implementation;

public class Main {

	public static void main(String[] args) {
		
		ArrayList numbers = new ArrayList();
		numbers.addLast(10);
		numbers.addLast(20);
		numbers.addLast(30);
		numbers.addLast(40);
//		numbers.add(1, 15);
//		numbers.addFirst(5);
//		numbers.remove(1);
//		System.out.println(numbers.get(0));
//		System.out.println(numbers.size());
//		System.out.println(numbers.indexOf(22));
		
//		for(int i = 0; i < numbers.size(); i++) {
//			System.out.println(numbers.get(i));
//		}
		
		// ArrayList객체의 반복적인 작업을 처리하기 위한 객체
		// 단순 반복보다는 Iterator 형식을 권장
		// ArrayList 클래스 안의 포함되어 있는 ListIterator 클래스
		ArrayList.ListIterator li = numbers.listIterator();
//		while(li.hasNext()) {
//			System.out.println(li.next());
//		}
//		
//		while(li.hasPrevious()) {
//			System.out.println(li.previous());
//		}		

		while(li.hasNext()) {
			int number = (int)li.next();
			if(number == 30) {
				li.add(35);
//				li.remove();
			}
		}
		System.out.println(numbers);
	}

}
