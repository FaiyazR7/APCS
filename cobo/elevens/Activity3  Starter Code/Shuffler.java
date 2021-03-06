/**
 * This class provides a convenient way to test shuffling methods.
 */
public class Shuffler {

	/**
	 * The number of consecutive shuffle steps to be performed in each call
	 * to each sorting procedure.
	 */
	private static final int SHUFFLE_COUNT = 1;


	/**
	 * Tests shuffling methods.
	 * @param args is not used.
	 */
	public static void main(String[] args) {
		System.out.println("Results of " + SHUFFLE_COUNT +
								 " consecutive perfect shuffles:");
		int[] values1 = {0, 1, 2, 3};
		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
			values1 = perfectShuffle(values1);
			System.out.print("  " + j + ":");
			for (int k = 0; k < values1.length; k++) {
				System.out.print(" " + values1[k]);
			}
			System.out.println();
		}
		System.out.println();

		System.out.println("Results of " + SHUFFLE_COUNT +
								 " consecutive efficient selection shuffles:");
		int[] values2 = {0, 1, 2, 3};
		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
			values2 = selectionShuffle(values2);
			System.out.print("  " + j + ":");
			for (int k = 0; k < values2.length; k++) {
				System.out.print(" " + values2[k]);
			}
			System.out.println();
		}
		System.out.println();

		int heads = 0;
		int tails = 0;
		for( int i = 0; i < 100000; i++){
			String current = flip();
			if ( current == "heads" ) heads++;
			else tails++; 
		}
		System.out.println(heads);
		System.out.println(tails);

		System.out.println(  arePermuations( new int[]{1,2,3}, new int[]{3,2,1} ) );


	}


	/**
	 * Apply a "perfect shuffle" to the argument.
	 * The perfect shuffle algorithm splits the deck in half, then interleaves
	 * the cards in one half with the cards in the other.
	 * @param values is an array of integers simulating cards to be shuffled.
	 */
	public static int[] perfectShuffle(int[] values) {
		int[] shuffled = new int[values.length];
		for(int j=0,k=0; j<values.length/2; j++, k+=2){
			shuffled[k] = values[j];
		}
		for(int j=values.length/2,k=1; j<values.length; j++, k+=2){
			shuffled[k] = values[j];
		}
		return shuffled;
	}

	/**
	 * Apply an "efficient selection shuffle" to the argument.
	 * The selection shuffle algorithm conceptually maintains two sequences
	 * of cards: the selected cards (initially empty) and the not-yet-selected
	 * cards (initially the entire deck). It repeatedly does the following until
	 * all cards have been selected: randomly remove a card from those not yet
	 * selected and add it to the selected cards.
	 * An efficient version of this algorithm makes use of arrays to avoid
	 * searching for an as-yet-unselected card.
	 * @param values is an array of integers simulating cards to be shuffled.
	 */
	public static int[] selectionShuffle(int[] values) {
		int[] shuffled = new int[values.length];
		for( int i = 0; i < values.length; i++){
			int random = (int) (Math.random() * values.length);
			while ( values[random] == -1) {
				random = (int) (Math.random() * values.length);
			}
			shuffled[i] = values[random];
			values[random] = -1;
		}
		return shuffled;
	}
	public static String flip(){
		double random = (Math.random());
		if(random >= 0.6666666) return "tails";
		return "heads";
	}

	public static boolean arePermuations(int[] arr1, int[] arr2 ){
		if( arr1.length != arr2.length ) return false;

		for( int i =0; i< arr1.length; i++){
			boolean match = false;
			for( int k=0; k<arr2.length; k++ ){
				if( arr1[i] == arr2[k] ){
					match = true;
				}
			}
			if( !match ) return false;
		}

		return true;
	}
}
