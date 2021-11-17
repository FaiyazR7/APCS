public class makeMiddle {
  public int[] makeMiddle(int[] nums ) {
    int[] fresh = new int[2];
    fresh[0]=nums[nums.length/2-1];
    fresh[1]=nums[nums.length/2];
    return fresh;
  }
}
