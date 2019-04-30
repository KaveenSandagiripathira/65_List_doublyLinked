/**
 Test list features.
 */
public class UserOfList {
    private static List_inChainOfNodes list = new List_inChainOfNodes();
    public static void main( String[] args ) {
		System.out.println(list);
		list.add(0, "S");
		System.out.println(list);
		list.add(1, "t");
		System.out.println(list);
		list.add(2, "u");
		System.out.println(list);
		list.add(3, "y");
		System.out.println(list);
		list.add(2, "d");
		System.out.println(list);
		list.remove(1);
		System.out.println(list);
	}

}
