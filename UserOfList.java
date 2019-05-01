/**
 Test list features.
 */
public class UserOfList {
    private static List_inChainOfNodes list = new List_inChainOfNodes();
    public static void main( String[] args ) {
		System.out.println(list);
		list.add(0, "S");
		System.out.println(list);
		list.add(1, "T");
		list.add(2, "U");
		list.add(3, "Y");
		System.out.println(list);
		list.remove(3);
		list.remove(0);
		System.out.println(list);
	}

}
